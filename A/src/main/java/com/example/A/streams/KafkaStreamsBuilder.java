package com.example.A.streams;

import com.example.A.models.Widget;
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
public class KafkaStreamsBuilder {

    @Bean
    public KafkaStreams kafkaStreamsCustom(){

        Properties settings = new Properties();
        settings.setProperty(StreamsConfig.APPLICATION_ID_CONFIG, "app1");
        settings.setProperty(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");

        StreamsBuilder builder = new StreamsBuilder();

        JsonSerde<Widget> widgetSerde = new JsonSerde<>(Widget.class);

        KStream<String, Widget> source = builder.stream("t1", Consumed.with(Serdes.String(), widgetSerde));

        KStream<String, Widget> filteredLess = source.filter((key, widget) -> widget.getNum() < 5);

        KStream<String, Widget> filteredAndModified = source
                .filter((key, widget) -> widget.getNum() >= 5)
                .mapValues(widget -> {
                    widget.setFruit("NA");
                    return widget;
                });


        filteredLess.to("t2", Produced.with(Serdes.String(), widgetSerde));
        filteredAndModified.to("t3", Produced.with(Serdes.String(), widgetSerde));

        final Topology topology = builder.build();

        //System.out.println(topology.describe());

        return new KafkaStreams(topology, settings);
    }

}
