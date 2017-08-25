FROM java:8u111-jdk-alpine

ADD inventory-1.0.0.RELEASE.jar /app/inventory-1.0.0.RELEASE.jar

WORKDIR /app

EXPOSE 8080

ENTRYPOINT ["java", "-Dspring.profiles.active=container", "-jar", "inventory-1.0.0.RELEASE.jar"]
