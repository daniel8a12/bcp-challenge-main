## Necesita usar docker build --build-arg ARGUMENTO=VALOR

ARG flavor=alpine

FROM maven:3.6-jdk-8-$flavor AS builder

WORKDIR /app/

COPY pom.xml .
RUN mvn -e -B dependency:resolve
COPY src ./src
RUN cd /app && mvn -e -B package


FROM openjdk:8-jre-$flavor
COPY --from=builder /app/target/challenge-bcp-1.0-SNAPSHOT.jar /
CMD ["java", "-jar", "/challenge-bcp-1.0-SNAPSHOT.jar"]
