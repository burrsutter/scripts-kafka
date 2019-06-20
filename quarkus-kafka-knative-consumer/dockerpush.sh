#!/bin/bash

# use docker images | grep qkafkaproducer to get the image ID for $1

docker login docker.io

docker tag $1 docker.io/burrsutter/qkafka-knative-consumer:1.0.0

docker push docker.io/burrsutter/qkafka-knative-consumer:1.0.0

