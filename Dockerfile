FROM adoptopenjdk/openjdk11:alpine-jre
COPY target/cms-0.0.1-SNAPSHOT.jar ./service.jar
ENTRYPOINT exec java $JAVA_OPTS -jar /service.jar
