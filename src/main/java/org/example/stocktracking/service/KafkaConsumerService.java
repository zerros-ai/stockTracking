package org.example.stocktracking.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

//    @KafkaListener(topics = "stockTracking")
    public void listen(ConsumerRecord<?, ?> record) {
        System.out.println(record.value());
    }
}
