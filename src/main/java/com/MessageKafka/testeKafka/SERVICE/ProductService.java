package com.MessageKafka.testeKafka.SERVICE;

import com.MessageKafka.testeKafka.DTOs.ProductDto;
import com.MessageKafka.testeKafka.MODEL.Product;
import com.MessageKafka.testeKafka.REPOSITORIES.ProductRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepositorie productRepositorie;

    public Product Register(ProductDto dto){
        Product product = new Product();
        product.setNome(dto.nome());
        product.setMessage(dto.message());
        return productRepositorie.save(product);
    }

}
