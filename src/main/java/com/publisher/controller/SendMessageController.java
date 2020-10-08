package com.publisher.controller;

import com.publisher.producer.Message;
import com.publisher.producer.Publish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendMessageController {

  @Autowired
  private Publish publish;

  @PostMapping("/send")
  public void sendMessage(@RequestBody Message message){
    publish.send(message);
  }
}
