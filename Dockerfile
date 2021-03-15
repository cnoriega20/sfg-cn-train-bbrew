FROM adoptopenjdk/openjdk11:latest
ADD target/sfg-cn-train-bbrew-0.0.1-SNAPSHOT.jar sfg-cn-train-bbrew-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/sfg-cn-train-bbrew-0.0.1-SNAPSHOT.jar"]