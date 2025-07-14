package com.MessageKafka.testeKafka.REPOSITORIES;

import com.MessageKafka.testeKafka.MODEL.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepositorie extends JpaRepository<Product, UUID> {
}
