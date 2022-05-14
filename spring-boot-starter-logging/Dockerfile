FROM openjdk
RUN apt update && apt install -y curl && rm -rf /var/lib/apt/lists/*
VOLUME /tmp
COPY build/libs/spring-boot-starter-logging-1.0-SNAPSHOT.jar spring-boot-starter-logging-1.0-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","spring-boot-starter-logging-1.0-SNAPSHOT.jar"]