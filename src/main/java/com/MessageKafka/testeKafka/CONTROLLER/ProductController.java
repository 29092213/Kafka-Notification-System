package com.MessageKafka.testeKafka.CONTROLLER;

import com.MessageKafka.testeKafka.DTOs.MensagemPersonalizada;
import com.MessageKafka.testeKafka.DTOs.ProductDto;
import com.MessageKafka.testeKafka.MODEL.Product;
import com.MessageKafka.testeKafka.PRODUCER.KafkaProducer;
import com.MessageKafka.testeKafka.SERVICE.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private KafkaProducer kafkaProducer;

    @PostMapping("/RegisterChamado")
    ResponseEntity<MensagemPersonalizada> RegisterChamado(@RequestBody @Valid ProductDto dto){

        Product product = productService.Register(dto);

        kafkaProducer.SendMessage(product.getUuid().toString());

        MensagemPersonalizada mensagemPersonalizada = new MensagemPersonalizada(
                "Um chamado foi criado com o id: ",
                product.getUuid()
        );

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(mensagemPersonalizada);

    }

    @PostMapping("/Aumoxarifado")
    ResponseEntity<MensagemPersonalizada> ChamadoAumoxarifado(@RequestBody @Valid ProductDto dto){

        Product product = productService.Register(dto);

        MensagemPersonalizada mensagemPersonalizada = new MensagemPersonalizada(
                "Chamado para o Aumoxarifado, criado com sucesso, ID: " ,
                product.getUuid());

        kafkaProducer.SendAumoxarifado(product.getUuid().toString());

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(mensagemPersonalizada);
    }

    @PostMapping("/Cozinha")
    ResponseEntity<MensagemPersonalizada> ChamadoCozinha(@RequestBody @Valid ProductDto dto){

        Product product = productService.Register(dto);

        MensagemPersonalizada mensagemPersonalizada = new MensagemPersonalizada(
                "Chamado para a Cozinha, criado com sucesso, ID: " ,
                product.getUuid());

        kafkaProducer.SendCozinha(product.getUuid().toString());

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(mensagemPersonalizada);
    }

    @PostMapping("/Producao")
    ResponseEntity<MensagemPersonalizada> ChamadoProducao(@RequestBody @Valid ProductDto dto){

        Product product = productService.Register(dto);

        MensagemPersonalizada mensagemPersonalizada = new MensagemPersonalizada(
                "Chamado para a Producao, criado com sucesso, ID: " ,
                product.getUuid());

        kafkaProducer.SendProducao(product.getUuid().toString());

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(mensagemPersonalizada);
    }

    @PostMapping("/RecurHumam")
    ResponseEntity<MensagemPersonalizada> ChamadoRecurHumam(@RequestBody @Valid ProductDto dto){

        Product product = productService.Register(dto);

        MensagemPersonalizada mensagemPersonalizada = new MensagemPersonalizada(
                "Chamado para o R.H. , criado com sucesso, ID: " ,
                product.getUuid());

        kafkaProducer.SendRecurHumam(product.getUuid().toString());

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(mensagemPersonalizada);
    }
}
