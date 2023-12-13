package com.example.A;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.apache.kafka.streams.KafkaStreams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class KafkaStreamsLifecycleManager {

    private final KafkaStreams kafkaStreams;

    @Autowired
    public KafkaStreamsLifecycleManager(KafkaStreams kafkaStreams) {
        this.kafkaStreams = kafkaStreams;
    }

    @PostConstruct
    public void startKafkaStreams() {
        kafkaStreams.start();
    }

    @PreDestroy
    public void closeKafkaStreams() {
        kafkaStreams.close();
    }
}

