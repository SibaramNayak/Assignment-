package com.test.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.test.enity.ErrorInfo;

public class ProductResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	@JsonProperty
	private Long product_id;
	@JsonProperty
	private String found;
	@JsonProperty
	private String errorStatus;
	@JsonProperty
	private String statusMessage;
	@JsonProperty
	private String statusCode;
	@JsonProperty
	private ErrorInfo errorInfo;
	
	@JsonProperty
	private Price price;

	public Long getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}

	public String getFound() {
		return found;
	}

	public void setFound(String found) {
		this.found = found;
	}

	public String getErrorStatus() {
		return errorStatus;
	}

	public void setErrorStatus(String errorStatus) {
		this.errorStatus = errorStatus;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public ErrorInfo getErrorInfo() {
		return errorInfo;
	}

	public void setErrorInfo(ErrorInfo errorInfo) {
		this.errorInfo = errorInfo;
	}

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

}
