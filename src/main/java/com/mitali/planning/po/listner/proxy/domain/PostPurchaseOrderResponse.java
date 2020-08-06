package com.mitali.planning.po.listner.proxy.domain;

import lombok.ToString;

@ToString
public class PostPurchaseOrderResponse {
	
	private String httpStatus;
	private String link;
	
	public String getHttpStatus() {
		return httpStatus;
	}
	public void setHttpStatus(String httpStatus) {
		this.httpStatus = httpStatus;
		
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
}
