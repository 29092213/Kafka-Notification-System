package com.MessageKafka.testeKafka.CONTROLLER;

import com.MessageKafka.testeKafka.DTOs.MensagemPersonalizada;
import com.MessageKafka.testeKafka.DTOs.ProductDto;
import com.MessageKafka.testeKafka.MODEL.Product;
import com.MessageKafka.testeKafka.SERVICE.ProductProducer;
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
    private ProductProducer productProducer;

    @PostMapping("/RegisterChamado")
    ResponseEntity<MensagemPersonalizada> RegisterChamado(@RequestBody @Valid ProductDto dto){

        Product product = productService.Register(dto);

        productProducer.sendMessage(product.getUuid().toString());

        MensagemPersonalizada mensagemPersonalizada = new MensagemPersonalizada(
                "Um chamado foi criado com o id: ",
                product.getUuid()
        );

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(mensagemPersonalizada);

    }


}
