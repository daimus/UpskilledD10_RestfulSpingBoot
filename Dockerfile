FROM openjdk:21-jdk
WORKDIR /app
ARG JAR_FILE=build/libs/restful-springboot-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} /app/app.jar
EXPOSE 8080
CMD ["java","-jar","/app/app.jar"]