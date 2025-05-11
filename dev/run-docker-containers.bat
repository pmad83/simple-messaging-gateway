cd %~dp0..

call ./messages-sender/gradlew -p ./messages-sender clean build -x test

call docker compose -p simple-messaging-gateway -f ./docker/conf/docker-compose.yml build --no-cache

call docker compose -p simple-messaging-gateway -f ./docker/conf/docker-compose.yml up
