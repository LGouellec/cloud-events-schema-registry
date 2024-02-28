#!/bin/bash

echo "Clean all running docker containers"
docker rm -f $(docker ps -aq) > /dev/null 2>&1

echo "Build and package the java producer client"
cd java-producer/
mvn clean package

cd ../

source .env
docker-compose -f docker-compose.yaml up -d

docker-compose exec broker-1 kafka-topics --bootstrap-server broker-1:29092 --topic orders --partitions 6 --create

# Start the JAVA process to publish in background
java -jar java-producer/target/java-producer-1.0-SNAPSHOT-jar-with-dependencies.jar > /dev/null 2>&1 &
pidJavaProducer=$!

# Start consume messages applications
echo "Consume messages from the orders topic, CTRL+C to finish"
docker-compose exec schema-registry kafka-avro-console-consumer --bootstrap-server broker-1:29092 --topic orders --from-beginning

kill -9 ${pidJavaProducer}