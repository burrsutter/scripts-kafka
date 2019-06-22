
# curl -L "https://raw.githubusercontent.com/openshift/knative-eventing/release-v0.6.0/openshift/release/knative-eventing-kafka-v0.6.0.yaml" \
# | sed 's/REPLACE_WITH_CLUSTER_URL/burr-cluster-kafka-bootstrap.mykafka:9092/' \
# | kubectl apply --filename -

kubectl create namespace knative-sources
kubens knative-sources
kubectl apply -f https://raw.githubusercontent.com/openshift/knative-eventing-contrib/release-v0.6.0/openshift/release/knative-eventing-kafka-sources-v0.6.0.yaml

#curl -L "https://raw.githubusercontent.com/openshift/knative-eventing/release-v0.6.0/openshift/release/knative-eventing-kafka-v0.6.0.yaml" \
# | sed 's/REPLACE_WITH_CLUSTER_URL/burr-cluster-kafka-bootstrap.mykafka:9092/' \
# | kubectl delete --filename -

#kubectl delete -f https://raw.githubusercontent.com/openshift/knative-eventing-contrib/release-v0.6.0/openshift/release/knative-eventing-kafka-sources-v0.6.0.yaml 