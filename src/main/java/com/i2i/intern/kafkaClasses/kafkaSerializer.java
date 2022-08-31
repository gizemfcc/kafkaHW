package com.i2i.intern.kafkaClasses;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;

public class kafkaSerializer implements Serializer<Message>{
    private static Logger logger = LogManager.getLogger(kafkaSerializer.class);
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
    }

    @Override
    public byte[] serialize(String topic, Message data) {
        try {
            if (data == null) {
                logger.info("Null received at serializing");
                return null;
            }
            logger.info("Serializing...");
            return objectMapper.writeValueAsBytes(data);
        } catch (Exception e) {
            logger.info(e);
            throw new SerializationException("Error when serializing MessageDto to byte[]");
        }
    }

    @Override
    public void close() {
    }
}
