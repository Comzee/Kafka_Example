# Kafka_Example
Application where Service A is the producer, and Service B is the consumer.

# Usage
Docker compose file grabs from kafka repository, latest versions. Run the Zookeeper and Broker cluster with:<br>
**docker compose build**<br>
**docker compose up -d**<br>
Next Line Scanner on the Producer to enter a String.<br>
The Consumer prints that to console.<br>
Type **exit** on the producer to shut the application down.

# Broker commands
CD to /usr/bin

kafka-topics --bootstrap-server localhost:9092 --list

kafka-topics --create --topic t1 --bootstrap-server localhost:9092 --partitions 1 --replication-factor 1

kafka-topics --create --topic t2 --bootstrap-server localhost:9092 --partitions 1 --replication-factor 1

kafka-topics --create --topic t3 --bootstrap-server localhost:9092 --partitions 1 --replication-factor 1

kafka-console-consumer --bootstrap-server localhost:9092 --topic t1 --from-beginning
