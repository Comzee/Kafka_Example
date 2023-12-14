# Kafka_Example
Application where Service A is the producer, and Service B is the consumer.

# Usage
Docker compose file grabs from kafka repository, latest versions. Run the Zookeeper and Broker cluster with:<br>
**docker compose build**<br>
**docker compose up -d**<br>
Trigger the system to send a Widget object to Kafka with: **http://localhost:8080/widget**
