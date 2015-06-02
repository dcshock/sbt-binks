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
      publishTo := Some(Resolver.url("sbt-plugin-releases", new URL("http://repo.scala-sbt.org/scalasbt/sbt-plugin-releases/"))(Resolver.ivyStylePatterns)),
      publishMavenStyle := false
    )
  )
}
