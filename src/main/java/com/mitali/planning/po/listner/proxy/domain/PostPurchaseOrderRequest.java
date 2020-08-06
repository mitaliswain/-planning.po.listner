package com.mitali.planning.po.listner.proxy.domain;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class PostPurchaseOrderRequest {
	
	private String agent;
	private String brandId;
	private String marketId;
	private String styleId;
	private String productHierarchyId;
	private String vendorId;
	private String warehouseId;
	private String SeasonId;
	private String ShipmentMethod;
	private String garmentType;
	private String ticketId;
	private String orderType;
	
	private String inWarehouseDate;
	
	private String bulkPackFactor;
	
	private String freightPaidBy;
	
	private String termOfSale;
	
	private String freightNames;
	
	private String orderComment;
	
	private String earliestShippingDate;
	
	private String latestShippingDate;
	
	private String earliestCancelDate;
	
	private String paymentTerms;
	
	private String plannedReceiptMonth;
	
	private String receiptWeek;
	
	private String transferPointCode;
	
	private String origin;

	private List<SkuQuantity> skuQuantitties;
	

	
	
	
	
}


