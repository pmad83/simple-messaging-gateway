cd %~dp0..

call docker compose -p simple-messaging-gateway -f docker/conf/docker-compose.yml down --volumes
