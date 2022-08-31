package com.i2i;

import java.util.*;
import java.time.Duration;

import com.i2i.intern.kafkaClasses.Message;
import com.i2i.intern.kafkaClasses.kafkaConsumer;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.ConsumerRecord;

import static com.i2i.intern.operationClasses.IsFibonacci.isFibonacci;
import static com.i2i.intern.operationClasses.IsFibonacciPrime.isFibonacciPrime;
import static com.i2i.intern.operationClasses.IsPrime.isPrime;

public class ConsumerMain {

    public static void main(String[] args) throws Exception {

        String groupName = "MessageTopicGroup";
        Consumer<Long, Message> consumer = kafkaConsumer.createConsumer();
        while (true) {
            ConsumerRecords<Long, Message> consumerRecords = consumer.poll(Duration.ofSeconds(1));
            if (consumerRecords.count() == 0) {
                System.out.println("No message to read");
                continue;
            }
            for (ConsumerRecord<Long, Message> record : consumerRecords) {
                System.out.println("Message received");
                Message msg = record.value();
                int operand= msg.getOperand();
                String operation= msg.getOperation();

                if (operation.equalsIgnoreCase("isPrime")) {
                    if(isPrime(operand)){
                        System.out.println(operand + " is a prime number");
                    }
                    else{
                        System.out.println(operand + " is not a prime number");
                    }
                }
                else if(operation.equalsIgnoreCase("isFibonacci")){
                    if (isFibonacci(operand)) {
                        System.out.println(operand + " is a fibonacci number");
                    } else {
                        System.out.println(operand + " is not a fibonacci number");
                    }
                }
                else if(operation.equalsIgnoreCase("isFibonacciPrime")){
                    if(isFibonacciPrime(operand)){
                        System.out.println(operand + " is a fibonacci and prime number");
                    }
                    else{
                        System.out.println(operand + " is not a fibonacci and prime number");
                    }
                }
                else{
                    System.out.println("Message is wrong: Operation should be one of the following: isPrime, isFibonacci, isFibonacciPrime");
                }
                System.out.println(operand);
                System.out.println(operation);

            }

            consumer.commitAsync();
        }
    }
}
