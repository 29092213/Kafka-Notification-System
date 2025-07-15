package com.MessageKafka.testeKafka.SERVICE;


import com.MessageKafka.testeKafka.MODEL.Product;
import com.MessageKafka.testeKafka.REPOSITORIES.ProductRepositorie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProductProducer {

    private static final Logger logger = LoggerFactory.getLogger(ProductProducer.class);

    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private EmailService emailService;

    public ProductProducer(KafkaTemplate<String, String>kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message){

        kafkaTemplate.send("RegisterMessage", message);
        emailService.SendEmailText(
                "luizjdf13@gmail.com",
                "Chamado criado",
                "Chamado DE tecnologia pendente");
        logger.info("O chamado foi criado");
    }

}
