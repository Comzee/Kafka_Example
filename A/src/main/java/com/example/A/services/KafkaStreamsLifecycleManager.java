package com.example.A.services;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.apache.kafka.streams.KafkaStreams;
import org.springframework.stereotype.Component;

@Component
public class KafkaStreamsLifecycleManager {

    private final KafkaStreams kafkaStreams;

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

