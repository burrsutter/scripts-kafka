FROM registry.access.redhat.com/ubi7-dev-preview/ubi-minimal
WORKDIR /work/
COPY target/quarkus-kafka-knative-consumer-1.0.1-runner /work/quarkus-kafka-knative-consumer-1.0.1-runner
RUN chmod 775 /work
EXPOSE 8080
ENTRYPOINT [ "./quarkus-kafka-knative-consumer-1.0.1-runner",  "-Xmx8m", "-Xmn8m", "-Xms8m"]