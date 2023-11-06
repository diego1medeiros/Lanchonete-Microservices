FROM openjdk:17-alpine
RUN addgroup -S spring && adduser -S spring -G spring
#COPY src/main/resources/application-prod.properties application.yml
#ENV SPRING_PROFILES_ACTIVE=prod
USER spring:spring
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]