#!/bin/bash

kubectl create namespace mykafka
kubens mykafka

kubectl apply -f kubefiles/prometheus.yaml
kubectl apply -f kubefiles/alerting-rules.yaml

# deploy Grafana
oc apply -f https://raw.githubusercontent.com/strimzi/strimzi-kafka-operator/0.11.4/metrics/examples/grafana/grafana.yaml

# Manual configuration of Grafana
# https://strimzi.io/docs/0.11.4/#grafana_dashboard