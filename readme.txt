
1. Deploy the Strimzi Operator or find some another way to get a working Kafka cluster inside of your Kubernetes
https://screencast.com/t/mLucXD01sq

2. Create a Kafka cluster
kubectl create -f kubefiles/newcluster.yaml

3. Deploy the Kafka Channel CRD
curl -L "https://raw.githubusercontent.com/openshift/knative-eventing/release-v0.6.0/openshift/release/knative-eventing-kafka-v0.6.0.yaml" \
 | sed 's/REPLACE_WITH_CLUSTER_URL/burr-cluster-kafka-bootstrap.franz:9092/' \
 | kubectl apply --filename -

 This loads into knative-eventing

4. Deploy the Kafka Event source CRD
kubectl create namespace knative-sources
kubectl apply -f https://raw.githubusercontent.com/openshift/knative-eventing-contrib/release-v0.6.0/openshift/release/knative-eventing-kafka-sources-v0.6.0.yaml

5. Deploy the specific Kafka Event Source
kubectl apply -f kafkasource2service.yaml

6. Deploy the consuming Knative service (indentified in the kafkasource2service.yaml)
cd quarkus-kafka-knative-consumer
kubectl apply -f knService_docker.yaml
and see that it is installed, no errors like RevisionMissing
kubectl get ksvc

if you need to change the code:
mvn clean package
./buildNativeLinux.sh
modify the dockerbuild.sh for your image coordinates (note: does not work for quay.io)
./dockerbuild.sh
modify dockerpush.sh for your image coordinates
./dockerpush.sh
then 
kubectl replace -f knService_docker.yaml

7.  Deploy a message producer
cd qkafkaproducer
kubectl apply -f Deployment.yaml

8. Watch the logs
stern qkafkaproducer
stern qkafka-knative-consumer

9. Remove the producer 
kubectl delete -f deployment/qkafkaproducer

10. Wait 90 seconds to 2 minutes and watch qkafka-knative-consumer autoscale to 0

11. kubectl get ksvc/qkafka-knative-consumer | awk 'NR==2{print $2}'
use URL value to curl
curl $(kubectl get ksvc/qkafka-knative-consumer | awk 'NR==2{print $2}')
This will autoscale up from 0

12. Deploy the CronJobSource - the code does not care which EventSource invokes it
kubectl create -f kubefiles/cronsource2service.yaml
It sends a message every 60 seconds
Keeping the qkafka-knative-consumer alive indenifitely 
(60 seconds is more frequent than the 90 second autoscale to 0)

Clean up:
13. Delete CronJobSource
kubectl delete cronjobsource/cronjobsource-aloha

14. Delete the Knative Service 
kubectl delete ksvc/qkafka-knative-consumer

You can also delete the KafkaEventSource as well as the Kafka Cluster 
but it might be easier to just delete the whole namespace

