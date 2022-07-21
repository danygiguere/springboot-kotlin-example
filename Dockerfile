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


#FROM openjdk:17-alpine
#WORKDIR /app
#EXPOSE 8080
#ADD ./build/libs/app-0.0.1-SNAPSHOT.jar .
#CMD ["java", "-jar", "app-0.0.1-SNAPSHOT.jar"]