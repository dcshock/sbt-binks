name := "sbt-binks"
version := "0.1"
organization := "com.github.dcshock"

libraryDependencies ++= Seq(
  "commons-lang" % "commons-lang" % "2.6"
)

publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases" at nexus + "service/local/staging/deploy/maven2")
}

publishMavenStyle := true

publishArtifact in Test := false

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
    <developer>
      <id>zdavep</id>
      <name>Dave Pederson</name>
      <url>https://github.com/zdavep</url>
    </developer>
    <developer>
      <id>vultron81</id>
      <name>Ben Williams</name>
      <url>https://github.com/vultron81</url>
    </developer>
  </developers>)



