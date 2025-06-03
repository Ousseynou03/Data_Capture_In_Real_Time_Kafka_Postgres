package com.dione.controller;

import com.dione.dto.Order;
import com.dione.producer.KafkaAvroProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @Autowired
    private KafkaAvroProducer producer;

    @PostMapping("/invoke")
    public String sendMessage(@RequestBody Order order) {
        producer.send(order);
        return "message published !";
    }
}
