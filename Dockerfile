FROM openjdk:8-jdk-alpine
EXPOSE 8089
ADD target/tpStockProject-1.0.jar tpStockProject-1.0.jar
ENTRYPOINT ["java","-jar","/tpStockProject-1.0.jar"]