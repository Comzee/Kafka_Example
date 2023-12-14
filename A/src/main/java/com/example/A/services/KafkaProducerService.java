package com.example.A.services;

import com.example.A.models.Widget;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    private final KafkaTemplate<String, String> producerTemplateForTest;
    private final KafkaTemplate<String, Widget> producerTemplateForT;

    public KafkaProducerService(KafkaTemplate<String, String> producerTemplateForTest,KafkaTemplate<String, Widget> producerTemplateForT) {
        this.producerTemplateForTest = producerTemplateForTest;
        this.producerTemplateForT = producerTemplateForT;
    }

    public void sendMessageForTest(String msg) {
        try {
            producerTemplateForTest.send("test_topic", msg);
        } catch (Exception e) {
            System.err.println("Failed to send message: " + e.getMessage());
        }
    }

    public void sendMessageForT(Widget widget) {

        try{
            producerTemplateForT.send("t1",widget);
            System.out.println("Message sent to Kafka topic t1: " + widget);
        } catch (Exception e) {
            System.err.println("Failed to send message: " + e.getMessage());
        }
    }
}
