package com.github.dcshock

import sbt._
import Keys._
import java.util.jar.Attributes.Name._
import sbt.Defaults._
import sbt.Package.ManifestAttributes

object SbtBinks extends Plugin {
  val binks = TaskKey[File]("binks", "Create a JAR of JAR files")
  val binksSettings: Seq[Def.Setting[_]] = inTask(binks)(Seq(
    artifactPath <<= artifactPathSetting(artifact),
    cacheDirectory <<= cacheDirectory / "binks"
  )) ++ Seq(
    publishArtifact in binks <<= publishMavenStyle,
    artifact in binks <<= moduleName(Artifact(_, "binks")),
    mappings in binks <<= (packageBin in Compile, dependencyClasspath in Runtime).map { (artifact, classpath) =>
      val thisArtifactMapping = (artifact, (file(".") / artifact.name).getPath)
      val deps: Seq[(File, String)] = {
        val allDeps = Attributed.data(classpath).map(f => (f, (file(".") / f.name).getPath))
        allDeps.filterNot(_._1 == artifact)
      }
      Seq(thisArtifactMapping) ++ deps
    },
    binks <<= (mappings in binks, artifactPath in binks, cacheDirectory in binks, streams) map { (mappings, output, cacheDir, s) =>
      val packageConf = new Package.Configuration(mappings, output, Seq())
      Package(packageConf, cacheDir, s.log)
      output
    }
  )
}
