package com.test.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MetaFields implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty
	private String key;
	@JsonProperty
	private String manufacturer;
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	
	

}
