#!/bin/bash
cd $(realpath $(dirname $0))

cd ../messages-sender
./gradlew clean build -x test

docker compose -p simple-messaging-gateway -f ../docker/conf/docker-compose.yml build --no-cache

docker compose -p simple-messaging-gateway -f ../docker/conf/docker-compose.yml up
