name := "brando"

organization := "com.digital-achiever"

version := "1.0.2"

scalaVersion := "2.10.3"

scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature")

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.3.0",
  "org.scalatest" %% "scalatest" % "2.1.0" % "test",
  "com.typesafe.akka" %% "akka-testkit" % "2.3.0" % "test"
)

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

publishTo <<= version { (v: String) =>
   if (v.trim.endsWith("-SNAPSHOT"))
    Some("snapshots" at "http://artifactory.mdialog.com/artifactory/snapshots")
   else
    Some("releases" at "http://artifactory.mdialog.com/artifactory/releases")
 }

credentials += Credentials(Path.userHome / ".mdialog.credentials")

publishArtifact in (Compile, packageDoc) := false
