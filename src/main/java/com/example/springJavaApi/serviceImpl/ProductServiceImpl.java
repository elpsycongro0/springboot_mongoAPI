package com.example.springJavaApi.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.example.springJavaApi.commons.GenericServiceImpl;
import com.example.springJavaApi.model.Product;
import com.example.springJavaApi.repository.ProductRepository;
import com.example.springJavaApi.serviceApi.ProductServiceApi;

@Service
public class ProductServiceImpl extends GenericServiceImpl<Product, String> implements ProductServiceApi{

  @Autowired
  private ProductRepository productRepository;

  @Override
  public CrudRepository<Product, String> getDao() {
    return productRepository;
  }
  
}
