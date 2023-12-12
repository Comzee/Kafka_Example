package com.example.A.controller;

import com.example.A.KafkaProducerConfig;
import com.example.A.KafkaProducerService;
import com.example.A.Widget;
import com.example.A.WidgetCreator;
import lombok.RequiredArgsConstructor;

import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class WidgetController {

    private final KafkaProducerService producerService;
    private final KafkaProducerConfig kafkaProducerConfig;

    @GetMapping("/trigger-producer")
    public ResponseEntity<String> triggerProducer(@RequestParam String message) {
        producerService.sendMessage(message);
        return ResponseEntity.ok("Message sent to Kafka: " + message);
    }

    @GetMapping("/widget")
    public ResponseEntity<String> createWidget() {
        Widget newWidget = WidgetCreator.createWidgets();
        producerService.sendMessageTone(newWidget);
        KafkaStreams streams = kafkaProducerConfig.kafkaStreamsCustom();
        return ResponseEntity.ok("Widget sent to Kafka topic t1 for Kafka Streams!");
    }




}
