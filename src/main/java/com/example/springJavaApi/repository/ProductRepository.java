package com.example.springJavaApi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.springJavaApi.model.Product;


public interface ProductRepository extends MongoRepository<Product, String> {
  
}
