import sbt._

name := "euler"

organization := "com.github.ldaniels528"

version := "0.01"

scalaVersion := "2.12.12"

scalacOptions ++= Seq("-deprecation", "-encoding", "UTF-8", "-feature", "-unchecked",
  "-Ywarn-adapted-args", "-Ywarn-value-discard", "-Xlint")

//javacOptions ++= Seq("-Xlint:deprecation", "-Xlint:unchecked", "-source", "1.7", "-target", "1.7", "-g:vars")

// General Dependencies
libraryDependencies ++= Seq(
  "log4j" % "log4j" % "1.2.17",
  "org.slf4j" % "slf4j-api" % "1.7.7",
  "org.slf4j" % "slf4j-log4j12" % "1.7.7",
  "junit" % "junit" % "4.11" % "test"
)
