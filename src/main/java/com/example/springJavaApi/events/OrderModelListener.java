package com.example.springJavaApi.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

import com.example.springJavaApi.model.Order;
import com.example.springJavaApi.services.SequenceGeneratorService;

@Component
public class OrderModelListener extends AbstractMongoEventListener<Order>{
  private SequenceGeneratorService sequenceGenerator;

  @Autowired
  public OrderModelListener(SequenceGeneratorService sequenceGenerator){
    this.sequenceGenerator = sequenceGenerator;
  }

  @Override
  public void onBeforeConvert(BeforeConvertEvent<Order> event){
    if(event.getSource().getOrderNum() < 1){
      event.getSource().setOrderNum(sequenceGenerator.generateSequence(Order.SEQUENCE_NAME));
    }
  }
}
