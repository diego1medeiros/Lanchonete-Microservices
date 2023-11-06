FROM openjdk:17-alpine
RUN addgroup -S spring && adduser -S spring -G spring
ENV LANG="pt_BR.UTF-8"
ENV LC_ALL="pt_BR.UTF-8"
USER spring:spring
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]