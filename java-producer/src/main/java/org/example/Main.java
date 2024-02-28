package org.example;

import io.confluent.kafka.serializers.KafkaAvroSerializer;
import io.confluent.kafka.serializers.KafkaAvroSerializerConfig;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.example.events.OrderEvent;
import org.example.events.OrderEventData;

import java.util.*;

public class Main {
    static boolean isRunning = true;

    public static void main(String[] args) throws InterruptedException {

        Properties producerConf = new Properties();
        producerConf.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092, localhost:9093");
        producerConf.put(ProducerConfig.CLIENT_ID_CONFIG, "producer-order-event-client");
        producerConf.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        producerConf.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class);
        producerConf.put(KafkaAvroSerializerConfig.AUTO_REGISTER_SCHEMAS, "true");
        producerConf.put(KafkaAvroSerializerConfig.SCHEMA_REGISTRY_URL_CONFIG, "http://localhost:8081");

        KafkaProducer<String, OrderEvent> producer = new KafkaProducer<>(producerConf);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
           isRunning = false;
        }));

        long orderId = 0;
        Random rd = new Random();

        while(isRunning){

            OrderEvent event = new OrderEvent();
            event.setId(UUID.randomUUID().toString());
            event.setTime(System.currentTimeMillis());
            event.setType("org.example.events.OrderEvent");
            event.setSubject("orders-value");
            event.setDataschema("http://localhost:8081/subjects/orders-value/versions");
            event.setSpecversion("1.0");
            event.setDatacontenttype("application/octet-stream");
            event.setSource("kafka");

            event.setData(
                    new OrderEventData(
                            ++orderId,
                            UUID.randomUUID().toString(),
                            "User:"+UUID.randomUUID().toString(),
                            (long)rd.nextInt(10) + 1));

            producer.send(new ProducerRecord<>("orders", event.getId().toString(), event));

            Thread.sleep(500);
        }

        producer.flush();
        producer.close();


    }
}