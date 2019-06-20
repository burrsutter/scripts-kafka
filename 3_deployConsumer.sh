#!/bin/bash

kubectl apply -f qkafkaconsumer/Deployment.yml
stern qkafkaconsumer