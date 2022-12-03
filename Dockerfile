FROM openjdk:17
COPY target/tripscheduling.jar tripscheduling.jar
ENTRYPOINT ["java","-jar","/tripscheduling.jar"]

EXPOSE 8080