FROM openjdk:17
WORKDIR /app
ADD build/libs/Fups-Test-Case-0.0.1-SNAPSHOT.jar Fups-Test-Case-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","Fups-Test-Case-0.0.1-SNAPSHOT.jar"]