name := "cuc-proto-project"

version := "0.1.0-SNAPSHOT"

organization := "org.smop"

scalaVersion := "2.9.0-1"

libraryDependencies ++= Seq(
  "org.specs2" %% "specs2" % "1.4" % "test",
  "org.seleniumhq.selenium" % "selenium-server" % "2.0rc3" % "test"
)


publishTo := Some("Lunatech Public" at "http://nexus.lunatech.com/content/repositories/lunatech-public/")

credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")

seq(cucumberSettings : _*)
