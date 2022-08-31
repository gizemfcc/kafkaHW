package com.i2i;

import com.i2i.intern.kafkaClasses.Message;

import java.util.Scanner;

import com.i2i.intern.kafkaClasses.kafkaProducer;
import com.i2i.intern.kafkaConstants.Constants;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.io.Serializable;
import java.util.concurrent.ExecutionException;

public class ProducerMain {
    private static Serializable SerializeUsage(Message msg){
        return msg;
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter operand number- ");
        int operand = scanner.nextInt();
        System.out.print("Enter operation- ");
        String operation = scanner.next();

        Message message = new Message();
        message.setOperand(operand);
        message.setOperation(operation);

        Producer<Long, Serializable> producer = kafkaProducer.createProducer();
        ProducerRecord<Long,Serializable> record = new ProducerRecord<>(Constants.topicName,message);
        try{
            producer.send(record).get();
            System.out.println("Message Send");
        }
        catch (ExecutionException e){
            System.out.println("Error during producer send : ");
            System.out.println(e);
        }
        catch (InterruptedException e){
            System.out.println("Error during producer send : ");
            System.out.println(e);
        }

        System.out.println("Producer send the message.");
        producer.close();

    }
}
