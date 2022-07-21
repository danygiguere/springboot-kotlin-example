#  This script below is from https://www.richyhbm.co.uk/posts/kotlin-docker-spring-oh-my/

# FROM openjdk:17-alpine
# WORKDIR /app
# EXPOSE 8080
# ADD ./build/libs/app-0.0.1-SNAPSHOT.jar .
# CMD ["java", "-jar", "app-0.0.1-SNAPSHOT.jar"]

#  This version below is a multi-stage build
#  A multi-stage build is a docker build process that builds the application using a heavy image, then deploys the application onto a much lighter image that only needs to contain the runtime for the application.
FROM gradle:7.5.0-jdk17-alpine as builder
USER root
WORKDIR /builder
ADD . /builder
RUN gradle build --info

FROM openjdk:17-alpine
WORKDIR /app
EXPOSE 8080
COPY --from=builder /builder/build/libs/app-0.0.1-SNAPSHOT.jar .
CMD ["java", "-jar", "app-0.0.1-SNAPSHOT.jar"]