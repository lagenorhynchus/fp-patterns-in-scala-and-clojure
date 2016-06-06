lazy val root = (project in file("."))
  .settings(
    name := "fp-patterns-in-scala-and-clojure",
    version := "0.1.0",
    scalaVersion := "2.11.8",
    scalacOptions ++= Seq("-deprecation", "-feature", "-unchecked", "-Xlint")
  )
