package com.example.A;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Produced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.serializer.JsonSerde;

import java.util.Properties;

@Configuration
public class KafkaStreamsConfig {

    @Bean
    public KafkaStreams kafkaStreamsCustom(){

        Properties settings = new Properties();
        settings.put(StreamsConfig.APPLICATION_ID_CONFIG, "app1");
        settings.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");

        StreamsBuilder builder = new StreamsBuilder();

        JsonSerde<Widget> widgetSerde = new JsonSerde<>(Widget.class);

        KStream<String, Widget> source = builder.stream("t1", Consumed.with(Serdes.String(), widgetSerde));

        KStream<String, Widget> filteredGreater = source.filter((key, widget) -> widget.getNum() < 5);

        KStream<String, Widget> filteredAndModified = source
                .filter((key, widget) -> widget.getNum() >= 5)
                .mapValues(widget -> {
                    widget.setFruit("NA");
                    return widget;
                });

        filteredGreater.to("t2", Produced.with(Serdes.String(), widgetSerde));
        filteredAndModified.to("t3", Produced.with(Serdes.String(), widgetSerde));

        final Topology topology = builder.build();
        System.out.println(topology.describe());

        return new KafkaStreams(topology, settings);
    }

}
