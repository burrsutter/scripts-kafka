FROM registry.access.redhat.com/ubi7-dev-preview/ubi-minimal
WORKDIR /work/
COPY target/quarkus-kafka-knative-consumer-1.0-SNAPSHOT-runner /work/quarkus-kafka-knative-consumer-1.0-SNAPSHOT-runner
RUN chmod 775 /work
EXPOSE 8080
ENTRYPOINT [ "./quarkus-kafka-knative-consumer-1.0-SNAPSHOT-runner",  "-Xmx8m", "-Xmn8m", "-Xms8m"]