package com.test.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreatedAt implements Serializable {
	
   private static final long serialVersionUID = 1L;
   @JsonProperty	
   private String $date;
   
   public String get$date() {
	return $date;
}

	public void set$date(String $date) {
		this.$date = $date;
	}
   
   

}
