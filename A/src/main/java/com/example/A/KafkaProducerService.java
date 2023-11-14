package com.example.A;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class KafkaProducerService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String msg) {
        try {
            kafkaTemplate.send("test_topic", msg);
        } catch (Exception e) {
            System.err.println("Failed to send message: " + e.getMessage());
        }
    }

    public void produceMessage() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter a message to send to Kafka: ");
            String message = scanner.nextLine();
            if(message.equals("exit")) {
                System.exit(0);
            }
            sendMessage(message);
            System.out.println("Message sent to Kafka: " + message);
        }
    }
}
