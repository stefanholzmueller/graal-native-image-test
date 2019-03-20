sbt assembly
native-image --no-server -H:ReflectionConfigurationFiles=graal-reflection-config.json --enable-all-security-services -jar target/scala-2.12/graal-native-image-test-assembly-0.1.jar

