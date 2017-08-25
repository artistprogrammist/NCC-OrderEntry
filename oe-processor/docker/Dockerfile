FROM java:8u111-jdk-alpine

ADD processor-1.0.0.RELEASE.jar /app/processor-1.0.0.RELEASE.jar

WORKDIR /app

EXPOSE 8080

ENTRYPOINT ["java", "-Dspring.profiles.active=container", "-jar", "processor-1.0.0.RELEASE.jar"]
