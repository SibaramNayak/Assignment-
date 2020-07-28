package com.test.entity;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.test.constants.TestConstants;
@Component
@Scope(TestConstants.SCOPE_PROTOTYPE)
public class Price implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty
	private Long product_id;

	@JsonProperty
	private String range;
    
	@JsonProperty
	private double min;
    
	@JsonProperty
	private int max;

	public String getRange() {
		return range;
	}

	public void setRange(String range) {
		this.range = range;
	}

	public double getMin() {
		return min;
	}

	public void setMin(double min) {
		this.min = min;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public Long getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}
	
	

}
