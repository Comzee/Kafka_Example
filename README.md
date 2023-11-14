# Kafka_Example
Application where Service A is the producer, and Service B is the consumer.

# Usage
Docker compose file grabs from kafka repository, latest versions. Run the Zookeeper and Broker cluster with:<br>
**docker compose build**<br>
**docker compose up -d**<br>
Next Line Scanner on the Producer to enter a String.<br>
The Consumer prints that to console.<br>
Type **exit** on the producer to shut the application down.
