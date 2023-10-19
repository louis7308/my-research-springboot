FROM openjdk:17-jdk

ARG JAR_FILE=/build/libs/*.jar

COPY ${JAR_FILE} /startspring.jar

ENTRYPOINT ["java","-jar", "/startspring.jar"]