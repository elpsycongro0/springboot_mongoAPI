package com.example.springJavaApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springJavaApi.model.Product;
import com.example.springJavaApi.serviceApi.ProductServiceApi;

@RestController
@RequestMapping("product/api/")
@CrossOrigin("*")
public class ProductController {
  
  @Autowired
  private ProductServiceApi productServiceApi;

  @GetMapping(value = "/all")
  public List<Product> getAll(){
    return productServiceApi.getAll();
  }

  @GetMapping(value = "/find/{id}")
  public Product find(@PathVariable String id) {
    return productServiceApi.get(id);
  }
  @PostMapping(value = "/save")
  public ResponseEntity<Product> save(@RequestBody Product product) {
    Product obj = productServiceApi.save(product);
    return new ResponseEntity<Product>(obj, HttpStatus.OK);
  }

  @GetMapping(value = "/delete/{id}")
  public ResponseEntity<Product> delete(@PathVariable String id){
    Product order = productServiceApi.get(id);
    if(order != null){
      productServiceApi.delete(id);
    } else{
      return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
    }

    return new ResponseEntity<Product>(order, HttpStatus.OK);
  }
}
