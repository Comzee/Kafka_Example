package com.example.A.controller;

import com.example.A.services.KafkaProducerService;
import com.example.A.models.Widget;
import com.example.A.services.WidgetCreator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WidgetController {

    private final KafkaProducerService producerService;

    public WidgetController(KafkaProducerService producerService) {
        this.producerService = producerService;
    }

    @GetMapping("/trigger-producer")
    public ResponseEntity<String> triggerProducer(@RequestParam String message) {
        producerService.sendMessageForTest(message);
        return ResponseEntity.ok("Message sent to Kafka: " + message);
    }

    @GetMapping("/widget")
    public ResponseEntity<String> createWidget() {
        Widget newWidget = WidgetCreator.createWidgets();
        producerService.sendMessageForT(newWidget);
        return ResponseEntity.ok("Widget sent to Kafka topic t1 for Kafka Streams!");
    }
}
