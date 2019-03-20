name := "graal-native-image-test"

version := "0.1"

scalaVersion := "2.12.8"

libraryDependencies += "org.bouncycastle" % "bcpkix-jdk15on" % "1.60"
libraryDependencies += "com.pauldijou" %% "jwt-core" % "2.1.0" % Test
