ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.0.0"

lazy val root = (project in file("."))
  .settings(
    name := "scala3Hw6MonadParser",
    idePackagePrefix := Some("ru.otus")
  )
