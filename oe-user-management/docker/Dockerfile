FROM java:8u111-jdk-alpine

ADD user-management-1.0.0.RELEASE.jar /app/user-management-1.0.0.RELEASE.jar

WORKDIR /app

EXPOSE 8080

ENTRYPOINT ["java", "-Dspring.profiles.active=container", "-jar", "user-management-1.0.0.RELEASE.jar"]
