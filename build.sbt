name := """vitelioproject"""
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean)

scalaVersion := "2.11.11"

libraryDependencies ++= Seq(
    javaJdbc,
    evolutions,
    filters,
    "mysql" % "mysql-connector-java" % "5.1.18"
)
