package com.example.kafka.analytics;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Materialized;
import org.apache.kafka.streams.kstream.Produced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafkaStreams;

import java.util.Arrays;

@Configuration
@EnableKafkaStreams
public class KafkaStreamsAnalytics {

    @Bean
    public KStream<String, String> kStream(StreamsBuilder streamsBuilder) {
        KStream<String, String> stream = streamsBuilder.stream("input-topic");
        
        // Word count processing - CE QUI MANQUE !
        stream.flatMapValues(value -> Arrays.asList(value.toLowerCase().split("\\W+")))
              .groupBy((key, word) -> word)
              .count(Materialized.as("word-count-store"))
              .toStream()
              .to("word-count-output", Produced.with(Serdes.String(), Serdes.Long()));
        
        // Also forward original messages to output-topic
        stream.to("output-topic");
        
        return stream;
    }
}