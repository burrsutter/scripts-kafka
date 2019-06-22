#!/bin/bash

# use docker images | grep qkafkaconsumer to get the image ID for $1

docker login docker.io

docker tag $1 docker.io/burrsutter/qkafkaconsumer:1.0.1

docker push docker.io/burrsutter/qkafkaconsumer:1.0.1

