package com.MessageKafka.testeKafka.SERVICE;


import com.MessageKafka.testeKafka.MODEL.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProductProducer {

    private static final Logger logger = LoggerFactory.getLogger(ProductProducer.class);

    private KafkaTemplate<String, String> kafkaTemplate;

    public ProductProducer(KafkaTemplate<String, String>kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message){
        kafkaTemplate.send("RegisterMessage", message);
        logger.info("O chamado foi criado");
    }

}
