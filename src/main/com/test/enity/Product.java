package com.test.entity;

import java.io.Serializable;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.test.TestConstants;

@Component
@Scope(TestConstants.SCOPE_PROTOTYPE)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty
	private Long product_id;
	@JsonProperty
	private String sellerId;
	@JsonProperty
	private String title;
	@JsonProperty
	private String manufacturer;
	@JsonProperty
	private boolean isLowQuantity;
	@JsonProperty
	private boolean isSoldOut;
	@JsonProperty
	private boolean isBackorder;
	@JsonProperty
	private List<MetaFields> metafields;
	@JsonProperty
	private boolean requiresShipping;
	@JsonProperty
	private boolean isVisible;
	@JsonProperty
	private PublishedAt publishedAt;
	@JsonProperty
	private CreatedAt createdAt;
	@JsonProperty
	private UpdatedAt updatedAt;
	@JsonProperty
	private Workflow workflow;

	public Long getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public boolean isLowQuantity() {
		return isLowQuantity;
	}

	public void setLowQuantity(boolean isLowQuantity) {
		this.isLowQuantity = isLowQuantity;
	}

	public boolean isSoldOut() {
		return isSoldOut;
	}

	public void setSoldOut(boolean isSoldOut) {
		this.isSoldOut = isSoldOut;
	}

	public boolean isBackorder() {
		return isBackorder;
	}

	public void setBackorder(boolean isBackorder) {
		this.isBackorder = isBackorder;
	}

	public List<MetaFields> getMetafields() {
		return metafields;
	}

	public void setMetafields(List<MetaFields> metafields) {
		this.metafields = metafields;
	}

	public boolean isRequiresShipping() {
		return requiresShipping;
	}

	public void setRequiresShipping(boolean requiresShipping) {
		this.requiresShipping = requiresShipping;
	}

	public boolean isVisible() {
		return isVisible;
	}

	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}

	public PublishedAt getPublishedAt() {
		return publishedAt;
	}

	public void setPublishedAt(PublishedAt publishedAt) {
		this.publishedAt = publishedAt;
	}

	public CreatedAt getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(CreatedAt createdAt) {
		this.createdAt = createdAt;
	}

	public UpdatedAt getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(UpdatedAt updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Workflow getWorkflow() {
		return workflow;
	}

	public void setWorkflow(Workflow workflow) {
		this.workflow = workflow;
	}

}
