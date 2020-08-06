package com.mitali.planning.po.listner.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.mitali.planning.po.listener.domain.ReceiptEvent;
import com.mitali.planning.po.listner.proxy.domain.PostPurchaseOrderRequest;
import com.mitali.planning.po.listner.proxy.domain.Sku;
import com.mitali.planning.po.listner.proxy.domain.SkuQuantity;


@Component
public class POProxyMapper {
	
	public PostPurchaseOrderRequest poMapping(ReceiptEvent receiptEvent) {
		
		PostPurchaseOrderRequest postPurchaseOrderRequest = new PostPurchaseOrderRequest();
		
		postPurchaseOrderRequest.setAgent(receiptEvent.getAgent());
		postPurchaseOrderRequest.setBrandId(receiptEvent.getBrandId());
		postPurchaseOrderRequest.setMarketId(receiptEvent.getMarketId());
		postPurchaseOrderRequest.setStyleId(receiptEvent.getStyleId());
		postPurchaseOrderRequest.setProductHierarchyId(receiptEvent.getProductHierarchyId());
		postPurchaseOrderRequest.setVendorId(receiptEvent.getVendorId());
		postPurchaseOrderRequest.setOrderType("INITIAL");
		postPurchaseOrderRequest.setShipmentMethod("AIR");
		postPurchaseOrderRequest.setSeasonId("1");
		postPurchaseOrderRequest.setWarehouseId("1");
		postPurchaseOrderRequest.setGarmentType("1");
		postPurchaseOrderRequest.setTicketId("1");
		
		postPurchaseOrderRequest.setInWarehouseDate(receiptEvent.getInWarehouseDate());
		postPurchaseOrderRequest.setBulkPackFactor(receiptEvent.getBulkPackFactor());
		postPurchaseOrderRequest.setFreightPaidBy(receiptEvent.getFreightPaidBy());
		postPurchaseOrderRequest.setTermOfSale(receiptEvent.getTermOfSale());
		postPurchaseOrderRequest.setFreightNames(receiptEvent.getFreightNames());
		postPurchaseOrderRequest.setOrderComment(receiptEvent.getOrderComment());
		postPurchaseOrderRequest.setEarliestShippingDate(receiptEvent.getEarliestShippingDate());
		postPurchaseOrderRequest.setLatestShippingDate(receiptEvent.getLatestShippingDate());
		postPurchaseOrderRequest.setEarliestCancelDate(receiptEvent.getEarliestCancelDate());
		postPurchaseOrderRequest.setPaymentTerms(receiptEvent.getPaymentTerms());
		postPurchaseOrderRequest.setPlannedReceiptMonth(receiptEvent.getPlannedReceiptMonth());
		postPurchaseOrderRequest.setReceiptWeek(receiptEvent.getReceiptWeek());
		postPurchaseOrderRequest.setTransferPointCode(receiptEvent.getTransferPointCode());
		postPurchaseOrderRequest.setOrigin(receiptEvent.getOrigin());
		
		postPurchaseOrderRequest.setSkuQuantitties(mappingToProxySkuQuantities(receiptEvent));
				
		
		return postPurchaseOrderRequest;
		
	}
	
	private List<SkuQuantity> mappingToProxySkuQuantities(ReceiptEvent receiptEvent){
		
		List<SkuQuantity>  proxySkuQuantities= new ArrayList<SkuQuantity>();
		SkuQuantity prSkuQuantity =new SkuQuantity();
		
		for(com.mitali.planning.po.listener.domain.SkuQuantity skuQuantity:receiptEvent.getSkuQuantitties()) {
			prSkuQuantity.setQuantity(skuQuantity.getQuantity());
			Sku prSku = new Sku();
			prSku.setNumber(skuQuantity.getSku().getNumber());
			prSkuQuantity.setSku(prSku);
			proxySkuQuantities.add(prSkuQuantity);
		}
		
		return proxySkuQuantities;
		
		
		
		
	}
}
