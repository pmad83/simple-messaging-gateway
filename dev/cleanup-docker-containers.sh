#!/bin/bash
cd $(realpath $(dirname $0))

docker compose -p simple-messaging-gateway -f ../docker/conf/docker-compose.yml down --volumes
