package com.test.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Workflow implements Serializable {

	private static final long serialVersionUID = 1L;
	@JsonProperty
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
