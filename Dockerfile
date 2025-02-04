FROM amazoncorretto:21

COPY target/ProyectoVerano-0.0.1-SNAPSHOT.jar EgoTaskApp.jar

EXPOSE 8081
ENTRYPOINT ["java","-jar","/AVIAPP.jar"]