FROM openjdk:11
RUN apt update && apt install -y curl && rm -rf /var/lib/apt/lists/*
VOLUME /tmp
COPY build/libs/payment-service-1.0-SNAPSHOT.jar payment-service-1.0-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","payment-service-1.0-SNAPSHOT.jar"]