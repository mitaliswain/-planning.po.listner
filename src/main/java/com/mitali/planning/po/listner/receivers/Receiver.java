package com.mitali.planning.po.listner.receivers;

import java.util.concurrent.CountDownLatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mitali.planning.po.listener.domain.ReceiptEvent;
import com.mitali.planning.po.listner.proxy.PurchaseOrderListnerProxy;

@Component
public class Receiver {
	@Autowired
	PurchaseOrderListnerProxy purchaseOrderListnerProxy;

  private CountDownLatch latch = new CountDownLatch(1);

  public void receiveMessage(String message) throws JsonMappingException, JsonProcessingException {
	
	  ReceiptEvent receiptEvent = new ObjectMapper().readValue(message, ReceiptEvent.class) ;
	  purchaseOrderListnerProxy.addPOService(receiptEvent);
	  
	  
	  System.out.println("Received <" + receiptEvent.toString() + ">");
	  latch.countDown();
  }

  public CountDownLatch getLatch() {
    return latch;
  }

}
