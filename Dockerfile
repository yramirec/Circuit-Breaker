FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/hystrix.jar app.jar
ENTRYPOINT ["java","-jar","hystrix.jar"]
 
