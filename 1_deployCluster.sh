#!/bin/bash

echo "Assumes you have deployed the Strimzi Operator for Kafka"
# https://screencast.com/t/AtpWkc3K

kubectl create namespace mystuff

kubens mystuff
# the next line for using Knative 0.6
oc adm policy add-scc-to-user privileged -z default -n mystuff

kubectl apply -f kubefiles/burr-cluster-no-metrics.yaml