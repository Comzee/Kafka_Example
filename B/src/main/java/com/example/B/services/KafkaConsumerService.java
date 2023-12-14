package com.example.B.services;

import com.example.B.models.Widget;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "test_topic", groupId = "test-group", containerFactory = "kafkaListenerContainerForTest")
    public void consume(String message) {
        System.out.println("Consumed message: " + message);
    }

    @KafkaListener(topics = "t2", groupId = "t-group", containerFactory = "kafkaListenerContainerFactoryForT")
    public void consumeTTwo(Widget message) {
            System.out.println("Consumed message T2: " + message);
    }

    @KafkaListener(topics = "t3", groupId = "t-group", containerFactory = "kafkaListenerContainerFactoryForT")
    public void consumeTThree(Widget message) {
            System.out.println("Consumed message T3: " + message);
    }
}