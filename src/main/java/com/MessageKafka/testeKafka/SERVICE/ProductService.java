package com.MessageKafka.testeKafka.SERVICE;

import com.MessageKafka.testeKafka.DTOs.ProductDto;
import com.MessageKafka.testeKafka.MODEL.Product;
import com.MessageKafka.testeKafka.REPOSITORIES.ProductRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    private ProductRepositorie productRepositorie;

    public Product Register(ProductDto dto){
        Product product = new Product();
        product.setNome(dto.nome());
        product.setMessage(dto.message());
        product.setEmail(dto.email());
        return productRepositorie.save(product);
    }

    public Product VisualizarChamado(UUID uuid){
        Product product = productRepositorie.findById(uuid)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Não encontramos um chamado com esse ID: " + uuid));
        return product;

    }

}
