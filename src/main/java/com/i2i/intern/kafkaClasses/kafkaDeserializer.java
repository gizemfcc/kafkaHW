package com.i2i.intern.kafkaClasses;

import java.util.Map;
import org.apache.kafka.common.serialization.Deserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.errors.SerializationException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class kafkaDeserializer implements Deserializer<Message> {
    private static Logger logger=LogManager.getLogger(kafkaDeserializer.class);

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
    }

    @Override
    public Message deserialize(String topic, byte[] data) {
        try {
            if (data == null){
                logger.info("Null received at deserializing");
                return null;
            }
            logger.info("Deserializing...");
            return objectMapper.readValue(new String(data, "UTF-8"), Message.class);
        } catch (Exception e) {
            logger.info(e);
            throw new SerializationException("Error when deserializing byte[] to MessageDto");
        }
    }

    @Override
    public void close() {
    }

}
