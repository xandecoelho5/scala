course := "effective-scala"
assignment := "quickcheck"

ThisBuild / scalaVersion := "3.2.2"

lazy val root = (project in file("."))
  .settings(
    name := "unit-testing"
  )

scalacOptions ++= Seq("-deprecation")
libraryDependencies += "org.scalameta" %% "munit" % "0.7.26" % Test
libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.15.4"
