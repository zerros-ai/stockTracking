package org.example.stocktracking.Controller;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.example.stocktracking.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class KafkaController {
    @Autowired
    private KafkaProducerService kafkaProducerService;

    @PostMapping("/send")
    public String sendMessage(String message) {
        kafkaProducerService.sendMessage(message);
        return "success";
    }
}
