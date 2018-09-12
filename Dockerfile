FROM openjdk:8-jdk
ADD target/pim-0.0.1-SNAPSHOT.jar pim-0.0.1-SNAPSHOT.jar
CMD ["java", "-jar", "pim-0.0.1-SNAPSHOT.jar"]
