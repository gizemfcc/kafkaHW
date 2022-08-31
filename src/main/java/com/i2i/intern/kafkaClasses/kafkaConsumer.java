package com.i2i.intern.kafkaClasses;

import com.i2i.intern.kafkaConstants.Constants;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.LongDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Collections;
import java.util.Properties;

public class kafkaConsumer {
    public static Consumer <Long, Message> createConsumer(){
        Properties properties = new Properties();
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, Constants.bootstrapServers);
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, "consumerGroup");
        properties.setProperty(ConsumerConfig.CLIENT_ID_CONFIG, Constants.clientID);
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, LongDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "com.i2i.intern.kafkaClasses.kafkaDeserializer");
        properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, Constants.autoOffsetReset);

        Consumer<Long, Message> consumer = new KafkaConsumer<>(properties);
        consumer.subscribe(Collections.singletonList(Constants.topicName));
        return consumer;
    }
}
