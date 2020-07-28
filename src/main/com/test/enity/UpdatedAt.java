package com.test.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdatedAt implements Serializable {
	
   private static final long serialVersionUID = 1L;
   @JsonProperty	
   private String $date;

}
