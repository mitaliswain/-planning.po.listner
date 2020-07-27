package com.mitali.planning.po.listner.receivers;

import java.util.concurrent.CountDownLatch;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mitali.planning.po.listener.domain.Message;

@Component
public class Receiver {

  private CountDownLatch latch = new CountDownLatch(1);

  public void receiveMessage(String message) throws JsonMappingException, JsonProcessingException {
	Message message2 = new ObjectMapper().readValue(message, Message.class) ;
    System.out.println("Received <" + message2.toString() + ">");
    latch.countDown();
  }

  public CountDownLatch getLatch() {
    return latch;
  }

}
