package com.example.springJavaApi.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.example.springJavaApi.commons.GenericServiceImpl;
import com.example.springJavaApi.model.Order;
import com.example.springJavaApi.repository.OrderRepository;
import com.example.springJavaApi.serviceApi.OrderServiceApi;

@Service
public class OrderServiceImpl extends GenericServiceImpl<Order, String> implements OrderServiceApi {

  @Autowired
  private OrderRepository orderRepository;

  @Override
  public CrudRepository<Order, String> getDao() {
    return orderRepository;
  }
  
}
