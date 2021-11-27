name := "heroku-akka-multi"

version := "0.1"

scalaVersion := "2.13.7"

lazy val settings = Seq(
  scalacOptions ++= Seq(
    "-unchecked",
    "-feature",
    "-language:existentials",
    "-language:higherKinds",
    "-language:implicitConversions",
    "-language:postfixOps",
    "-deprecation",
    "-encoding",
    "utf8",
  )
)

lazy val global = project
  .in(file("."))
  .settings(settings)
  .aggregate(
    common,
    api,
  )
  .enablePlugins(JavaAppPackaging)

lazy val common = project
  .settings(
    settings,
    libraryDependencies ++= dependencies,
  )
  .enablePlugins(JavaAppPackaging)

lazy val api = project
  .settings(
    settings,
    libraryDependencies ++= dependencies,
  )
  .dependsOn(
    common
  )
  .enablePlugins(JavaAppPackaging)

val akkaHttpVersion     = "10.2.4"
val akkaVersion         = "2.6.8"
val logbackVersion      = "1.2.3"
val scalaLoggingVersion = "3.9.2"

lazy val akkaHttp   = "com.typesafe.akka" %% "akka-http"   % akkaHttpVersion
lazy val akkaActors = "com.typesafe.akka" %% "akka-actor"  % akkaVersion
lazy val akkaStream = "com.typesafe.akka" %% "akka-stream" % akkaVersion

lazy val logback      = "ch.qos.logback"              % "logback-classic" % logbackVersion % Runtime
lazy val scalaLogging = "com.typesafe.scala-logging" %% "scala-logging"   % scalaLoggingVersion

lazy val dependencies = Seq(akkaHttp, akkaActors, akkaStream, logback, scalaLogging)
