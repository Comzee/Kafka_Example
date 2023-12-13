package com.example.B;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "test_topic", groupId = "my-group")
    public void consume(String message) {
        System.out.println("Consumed message: " + message);
    }

    @KafkaListener(topics = "t2")
    public void consumeTTwo(String message) {
        System.out.println("Consumed message T2: " + message);
    }

    @KafkaListener(topics = "t3")
    public void consumeTThree(String message) {
        System.out.println("Consumed message T3: " + message);
    }
}