package com.mitali.planning.po.listner.proxy;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import com.mitali.planning.po.listener.domain.ReceiptEvent;
import com.mitali.planning.po.listner.mapper.POProxyMapper;

import com.mitali.planning.po.listner.proxy.domain.PostPurchaseOrderRequest;
import com.mitali.planning.po.listner.proxy.domain.PostPurchaseOrderResponse;
import com.mitali.planning.po.listner.proxy.domain.Sku;
import com.mitali.planning.po.listner.proxy.domain.SkuQuantity;


@Component
public class PurchaseOrderListnerProxy {

	@Autowired
	POProxyMapper poProxyMapper;
	
	private static final Logger log = LoggerFactory.getLogger(PurchaseOrderListnerProxy.class);


	public PostPurchaseOrderResponse addPOService(ReceiptEvent receiptEvent) {
		

		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("apigee-signature", "123456789012");
		
		String url ="http://localhost:8083/pms/purchase-order/";

		 PostPurchaseOrderRequest postPurchaseOrderRequest =poProxyMapper.poMapping(receiptEvent);
		
		
		log.info(postPurchaseOrderRequest.toString());
		try {
			HttpEntity<PostPurchaseOrderRequest> entity = new HttpEntity<>(postPurchaseOrderRequest, headers);

			ResponseEntity<PostPurchaseOrderResponse> postPurchaseOrderResponse = restTemplate.exchange(
					url,HttpMethod.POST, entity, PostPurchaseOrderResponse.class);
			log.info(postPurchaseOrderResponse.toString());
			
			return postPurchaseOrderResponse.getBody();
		} catch(HttpClientErrorException e) {
			log.error(" Something went wrong check "+ e.getMessage() );
		} catch (HttpServerErrorException e) {
			log.error(" Something went wrong in target machine "+ e.getMessage() );
		}
		return null;
		
	}
	
	
}
