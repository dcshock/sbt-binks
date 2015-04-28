import sbt._
import Keys._

object build extends Build {
  val sbtXjc = Project(
    id = "sbt-binks",
    base = file("."),
    settings = Defaults.defaultSettings ++ ScriptedPlugin.scriptedSettings ++ Seq[Project.Setting[_]](
      organization := "com.github.dcshock",
      version := "0.1",
      sbtPlugin := true,
      scalacOptions in Compile ++= Seq("-deprecation"),
      publishTo := Some(Resolver.url("sbt-dcshock-snapshots", new URL("https://oss.sonatype.org/content/repositories/snapshots"))(Resolver.ivyStylePatterns)),
      publishMavenStyle := false
    )
  )
}
