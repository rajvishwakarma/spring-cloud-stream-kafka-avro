FROM openjdk:8-jre-alpine
ADD target/schema-registry-0.0.1-SNAPSHOT.jar schema-registry-0.0.1-SNAPSHOT.jar
EXPOSE 8990
CMD ["java", "-jar", "schema-registry-0.0.1-SNAPSHOT.jar"]