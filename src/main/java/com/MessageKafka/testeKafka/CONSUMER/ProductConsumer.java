package com.MessageKafka.testeKafka.CONSUMER;

import com.MessageKafka.testeKafka.SERVICE.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProductConsumer {

    private static final Logger logger = LoggerFactory.getLogger(ProductConsumer.class);

    @Autowired
    private ProductService productService;

    @KafkaListener(topics = "RegisterMessage", groupId = "group-1")
    public void ReceiveMesssage(String message){
        logger.info("Temos um novo chamado, referente a este ID: " + message);
    }
}
