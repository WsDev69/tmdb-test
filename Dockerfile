FROM maven:3.6.2-jdk-11-slim as builder
WORKDIR /building

ADD . .
RUN mvn package -T 4 -B -Dmaven.javadoc.skip=true
RUN mv target/$(ls ./target | grep \.jar | grep -v original | grep -v javadoc | grep -v sources) ./application.jar

FROM openjdk:11.0.5-jre-stretch
WORKDIR /app
COPY --from=builder /building/application.jar .

ENTRYPOINT java \
    -Xss1M -Xmx261240K \
    -jar application.jar \
	--server.port=8080