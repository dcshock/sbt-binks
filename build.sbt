organization := "com.github.dcshock"

name := "sbt-binks"

version := "1.0"

sbtPlugin := true

scalacOptions in Compile ++= Seq("-deprecation")

publishMavenStyle := false

scalaVersion := "2.10.6"

resolvers ++= Seq(
    "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots",
    "Maven Central" at "http://repo1.maven.org/maven2",
    "Fuse Snapshots" at "http://repo.fusesource.com/nexus/content/repositories/snapshots",
    "Fuse" at "http://repo.fusesource.com/nexus/content/groups/public"
)

publishMavenStyle := true

publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}

pomIncludeRepository := { _ => false }

pomExtra := (
  <url>https://github.com/dcshock/sbt-binks</url>
  <licenses>
    <license>
      <name>BSD-style</name>
      <url>http://www.opensource.org/licenses/bsd-license.php</url>
      <distribution>repo</distribution>
    </license>
  </licenses>
  <scm>
    <url>git@github.com:dcshock/sbt-binks.git</url>
    <connection>scm:git:git@github.com:dcshock/sbt-binks.git</connection>
  </scm>
  <developers>
    <developer>
      <id>dcshock</id>
      <name>Matt Conroy</name>
      <url>http://www.mattconroy.com</url>
    </developer>
  </developers>)
