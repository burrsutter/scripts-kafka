FROM registry.access.redhat.com/ubi7-dev-preview/ubi-minimal
WORKDIR /work/
COPY target/qkafkaproducer-1.0.2-runner /work/qkafkaproducer-1.0.2-runner
RUN chmod 775 /work
EXPOSE 8080
ENTRYPOINT [ "./qkafkaproducer-1.0.2-runner",  "-Xmx12m", "-Xmn12m", "-Xms12m"]