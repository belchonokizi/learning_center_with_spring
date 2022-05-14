FROM openjdk
RUN apt update && apt install -y curl && rm -rf /var/lib/apt/lists/*
VOLUME /tmp
COPY build/libs/study-center-1.0-SNAPSHOT.jar study-center-1.0-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","study-center-1.0-SNAPSHOT.jar"]