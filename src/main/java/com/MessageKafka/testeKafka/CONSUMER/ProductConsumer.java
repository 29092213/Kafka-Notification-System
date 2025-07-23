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

    @KafkaListener(topics = "Aumoxarifado", groupId = "group-1")
    public void ReceiveAumoxarifado(String messsage){
        logger.info("Recebemos um chamados com esse ID: " + messsage);
    }

    @KafkaListener(topics = "Producao", groupId = "group-1")
    public void ReceiveProducao(String messsage){
        logger.info("Recebemos um chamados com esse ID: " + messsage);
    }

    @KafkaListener(topics = "RecurHumam", groupId = "group-1")
    public void ReceiveRecurHumanm(String messsage){
        logger.info("Recebemos um chamados com esse ID: " + messsage);
    }

    @KafkaListener(topics = "Cozinha", groupId = "group-1")
    public void ReceiveCozinha(String messsage){
        logger.info("Recebemos um chamados com esse ID: " + messsage);
    }

}
