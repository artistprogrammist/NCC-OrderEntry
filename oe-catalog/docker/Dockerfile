FROM java:8u111-jdk-alpine

ADD catalog-1.0.0.RELEASE.jar /app/catalog-1.0.0.RELEASE.jar

WORKDIR /app

EXPOSE 8080

ENTRYPOINT ["java", "-Dspring.profiles.active=container", "-jar", "catalog-1.0.0.RELEASE.jar"]
