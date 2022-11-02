FROM openjdk:8-jdk-alpine
EXPOSE 8082
ADD target/docker-spring-boot.jar docker-spring-boot.jar
ENTRYPOINT ["java","-jar","/docker-spring-boot.jar"]


