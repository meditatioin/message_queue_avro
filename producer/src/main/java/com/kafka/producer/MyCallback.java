package com.kafka.producer;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

public class MyCallback implements Callback {
    private ProducerRecord<String, Object> record;

    public MyCallback(ProducerRecord<String, Object> record) {
        this.record = record;
    }

    @Override
    public void onCompletion(RecordMetadata metadata, Exception e) {
        if (e != null) {
            e.printStackTrace();
        } else {
            System.out.printf("callback => Topic: %s, Partition: %d, Offset: %d, Key: %s, Received Message: %s\n", metadata.topic(), metadata.partition(), metadata.offset(), record.key(), record.value());
        }
    }
}