package com.example.springJavaApi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.springJavaApi.model.Order;

public interface OrderRepository extends MongoRepository<Order, String> {
	
	// @Query("{name:'?0'}")
	// Order findItemByName(String name);
	
	// @Query(value="{category:'?0'}", fields="{'name' : 1, 'quantity' : 1}")
	// List<Order> findAll(String category);
	
	// public long count();

}