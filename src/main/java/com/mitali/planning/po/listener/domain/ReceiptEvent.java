package com.mitali.planning.po.listener.domain;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class ReceiptEvent implements Serializable{

	private String id;
	private String brandId;
	private String marketId;
	private String productHierarchyId;
	private String vendorId;
	private String warehouseId;
	private String SeasonId;
	private String ShipmentMethod;
	private String garmentType;
	private String ticketId;
	private String styleId;
	
	
	private String agent;
	
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
	
	private  List<SkuQuantity> skuQuantitties;
	
}
