package com.test.service;

import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.test.entity.Price;
import com.test.entity.Product;

public class ProductRequestDelegatorService {
	
	private static Logger logger = Logger.getLogger(ProductRequestDelegatorService.class);
	
	public Response createEntryInProduct(Product productDetails) throws Exception {
		logger.info("createEntryInProduct starts");
		Response response = null;
		
		// Operation DAO 
		// Insert the record into Product and Price table
		// Get insert response and prepare proper JSON response
		
		//response = generateProductResponse(dto);
		logger.info("createEntryInProduct ends");
		return response;
	}
	
	public Response updateProduct(Product productDetails) throws Exception {
		logger.info("updateProduct starts");
		Response response = null;		
		
		       // Operation DAO 
				// Insert the record into Product and Price table
				// Get insert response and prepare proper JSON response
		//response = generateProductResponse(dto);		
		logger.info("updateProduct ends");
		return response;
	}
	
	public Response getProductByID(Product productDetails) throws Exception {
		logger.info("getProductByID starts");
		Response response = null;		
		
		// Operation DAO 
				// Insert the record into Product and Price table
				// Get insert response and prepare proper JSON response
		//response = generateProductResponse(dto);
				
		logger.info("getProductByID ends");
		return response;
	}
	
	public Response createEntryInPrice(Price priceDetails) throws Exception {
		logger.info("createEntryInPrice starts");
		Response response = null;
		
		// Operation DAO 
		// Insert the record into Product and Price table
		// Get insert response and prepare proper JSON response
		
		//response = generateProductResponse(dto);
		logger.info("createEntryInPrice ends");
		return response;
	}
	
	public Response updatePrice(Price priceDetails) throws Exception {
		logger.info("updatePrice starts");
		Response response = null;		
		
		       // Operation DAO 
				// Insert the record into Product and Price table
				// Get insert response and prepare proper JSON response
		//response = generateProductResponse(dto);		
		logger.info("updatePrice ends");
		return response;
	}
	
	public Response getPriceByPID(Price priceDetails) throws Exception {
		logger.info("getPriceByPID starts");
		Response response = null;		
		
		// Operation DAO 
				// Insert the record into Product and Price table
				// Get insert response and prepare proper JSON response
		//response = generateProductResponse(dto);
				
		logger.info("getPriceByPID ends");
		return response;
	}
	
	
	/*private Response generateProductResponse(Product dto, String errorMessage)
			throws Exception {
		logger.info("inside generateProductResponse >>> ");
		Response response = null;
		
        
        response = Response.status(Status.OK).entity(productResponse).build();		
		return response;

	}*/


}
