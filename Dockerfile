FROM openjdk:8
ARG JAR_FILE=target/*.jar
ADD ./target/CarRentSystem.jar CarRentSystem.jar
ENTRYPOINT ["java","-jar","/CarRentSystem.jar"]
EXPOSE 8080