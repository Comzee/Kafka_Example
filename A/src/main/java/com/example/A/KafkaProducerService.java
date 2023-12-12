package com.example.A;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class KafkaProducerService {


    private final KafkaTemplate<String, String> kafkaTemplate;
    private final KafkaTemplate<String, Widget> kafkaTemplate2;


    public void sendMessage(String msg) {
        try {
            kafkaTemplate.send("test_topic", msg);
        } catch (Exception e) {
            System.err.println("Failed to send message: " + e.getMessage());
        }
    }

    public void sendMessageTone(Widget widget) {

        try{
            kafkaTemplate2.send("t1",widget);
            System.out.println("Message sent to Kafka topic t1: " + widget);
        } catch (Exception e) {
            System.err.println("Failed to send message: " + e.getMessage());
        }
    }


}
