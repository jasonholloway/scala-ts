import sbt.Keys._

lazy val pomSettings = Seq(
  publishMavenStyle := true,
  publishTo := {
    val nexus = "https://oss.sonatype.org/"
    if (isSnapshot.value)
      Some("snapshots" at nexus + "content/repositories/snapshots")
    else
      Some("releases"  at nexus + "service/local/staging/deploy/maven2")
  },
  publishArtifact in Test := false,
  pomExtra :=
    <url>https://github.com/miloszpp/scala-ts</url>
    <licenses>
      <license>
        <name>MIT</name>
        <url>https://opensource.org/licenses/MIT</url>
        <distribution>repo</distribution>
      </license>
    </licenses>
    <scm>
      <url>git@github.com:miloszpp/scala-ts.git</url>
      <connection>scm:git:git@github.com:miloszpp/scala-ts.git</connection>
    </scm>
    <developers>
      <developer>
        <id>miloszpp</id>
        <name>Miłosz Piechocki</name>
        <url>http://codewithstyle.info</url>
      </developer>
    </developers>
)

lazy val root = (project in file(".")).
  settings(
    name := "scala-ts_2.12",
    version := "0.3.1",
    organization := "com.github.miloszpp",
    scalaVersion := "2.12.2",
    mainClass in (Compile, run) := Some("com.mpc.scalats.Main"),
    sbtPlugin := true,
    sbtVersion := "1.0.0"
  ).
  settings(pomSettings)

libraryDependencies ++= Seq(
  "org.scala-lang" % "scala-reflect" % "2.12.2",
  "ch.qos.logback" % "logback-classic" % "1.1.7",
  "org.scalatest" %% "scalatest" % "3.0.1" % "test"
)
