name := "akkademy-db-client"

version := "1.0"

scalaVersion := "2.11.12"
// Run in a separate JVM, to make sure sbt waits until all threads have
// finished before returning.
// If you want to keep the application running while executing other
// sbt tasks, consider https://github.com/spray/sbt-revolver/
fork := true

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.3.3",
  "com.typesafe.akka" %% "akka-testkit" % "2.3.6",
  "org.scalatest" %% "scalatest" % "2.1.6",
  "com.typesafe.akka" %% "akka-remote" % "2.3.6",
  "com.akkademy-db" %% "akkademy-db" % "0.0.1-SNAPSHOT"
)
