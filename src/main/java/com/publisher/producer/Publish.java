package com.publisher.producer;

import java.util.Collections;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Publish {

  @Value("${exchange}")
  private String exchange;
  @Value("${bind-key}")
  private String bindKey;

  @Autowired
  RabbitMessagingTemplate rabbitTemplate;

  public void send(Message message){
    rabbitTemplate.convertAndSend(exchange, bindKey, message, Collections.singletonMap("header1", "header1Value1"));
  }
}
