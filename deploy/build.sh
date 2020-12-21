#! /bin/bash

pwd

TAG=v1

cd ../hello-dubbo-consumer
docker build -t hello-dubbo-consumer:$TAG .

cd ../hello-dubbo-provider
docker build -t hello-dubbo-provider:$TAG .

docker push hello-dubbo-consumer:$TAG
docker push hello-dubbo-provider:$TAG

echo "Build Completed!!!"