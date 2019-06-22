#!/bin/bash

echo "Assumes you have deployed the Strimzi Operator for Kafka"

kubectl apply -f kubefiles/burr-cluster-no-metrics.yaml