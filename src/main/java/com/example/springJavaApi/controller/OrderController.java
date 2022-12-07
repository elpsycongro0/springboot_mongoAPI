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

import com.example.springJavaApi.model.Order;
import com.example.springJavaApi.serviceApi.OrderServiceApi;

@RestController
@RequestMapping("/order/api/")
@CrossOrigin("*")
public class OrderController {

  @Autowired
  private OrderServiceApi orderServiceApi;

  @GetMapping(value = "/all")
  public List<Order> getAll(){
    return orderServiceApi.getAll();
  }

  @GetMapping(value = "/find/{id}")
  public Order find(@PathVariable String id) {
    return orderServiceApi.get(id);
  }

  @PostMapping(value = "/save")
  public ResponseEntity<Order> save(@RequestBody Order order) {
    Order obj = orderServiceApi.save(order);
    return new ResponseEntity<Order>(obj, HttpStatus.OK);
  }

  @GetMapping(value = "/delete/{id}")
  public ResponseEntity<Order> delete(@PathVariable String id){
    Order order = orderServiceApi.get(id);
    if(order != null){
      orderServiceApi.delete(id);
    } else{
      return new ResponseEntity<Order>(HttpStatus.NO_CONTENT);
    }

    return new ResponseEntity<Order>(order, HttpStatus.OK);
  }
}
