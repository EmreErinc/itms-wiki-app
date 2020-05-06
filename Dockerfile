FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD /target/*.jar app.jar
RUN sh -c 'touch /app.jar'
EXPOSE 7000
ENTRYPOINT ["java","-Dspring.data.mongodb.uri=mongodb://itms_mongodb:27017/itms","-Dspring.datasource.url=jdbc:postgresql://itms_postgresql:5432/itms","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar","--spring.profiles.active=dc"]