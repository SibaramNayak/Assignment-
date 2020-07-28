package com.test.service;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.test.constants.TestConstants;
import com.test.entity.ErrorInfo;
import com.test.entity.Product;
import com.test.entity.ProductResponse;
import com.test.entity.BussinessException;


@Component
@Scope(TestConstants.SCOPE_PROTOTYPE)
public class ProductService {
	private static Logger logger = Logger.getLogger(ProductService.class);
	
	@Autowired
	private ProductResponse productResponse;
	@Autowired
	private ProductRequestDelegatorService delegator;
	@Autowired
	ErrorInfo errorInfo;
	@Autowired
	Product productData;
	
	/**
	 * This method is create Product Entry
	 * @param productDetails
	 * @return
	 */
	
	@POST
	@Path(TestConstants.PRODUCT_PATH)
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response createProductEntry(@Valid @RequestBody final Product productDetails) {
		logger.info("Entering  createProductEntry -->");	
		
		Response response = null;		
	
		// Checking sellerId,title and manufacturer are mandatory for product entry
	
		try {
			if (isNullOrEmpty(productDetails.getSellerId()) || isNullOrEmpty(productDetails.getTitle())
					|| isNullOrEmpty(productDetails.getManufacturer())) {
				logger.error("INPUT_DATA: Mandtory are missing in input request");
				productResponse.setFound(TestConstants.NUM_ZERO);
				productResponse.setStatusMessage("Mandatory fileds are null or empty or missing");
				errorInfo.setErrorMessage("Mandatory fileds are null or empty or missing");
				errorInfo.setErrorCode(TestConstants.NUM_ZERO);
				errorInfo.setHttpStatus(TestConstants.STATUS_NOT_FOUND);
				productResponse.setErrorInfo(errorInfo);
				response = Response.status(Status.BAD_REQUEST).entity(productResponse).build();
			} else {
				logger.error("Valid INPUT_DATA: Mandtory are valid in input request");
				response = delegator.createEntryInProduct(productDetails);				
				logger.info("response: " + response);
			}
		} catch (BussinessException exception) {
			logger.error("BussinessException:" + TestConstants.EMPTY_SPACE + exception.getMessage());
			productResponse.setFound(TestConstants.NUM_ZERO);
			errorInfo.setHttpStatus(TestConstants.STATUS_NOT_FOUND);
			errorInfo.setErrorCode(TestConstants.NUM_ONE);
			errorInfo.setErrorMessage("Exception occured while connecting to a database" + TestConstants.EMPTY_SPACE + exception.getMessage());
			productResponse.setErrorInfo(errorInfo);
			response = Response.status(Status.OK).entity(productResponse).build();
		} catch (Exception exception) {
			logger.error("BussinessException:" + TestConstants.EMPTY_SPACE + exception.getMessage());
			productResponse.setFound(TestConstants.NUM_ZERO);
			errorInfo.setHttpStatus(String.valueOf(TestConstants.NUM_500));
			errorInfo.setErrorCode(TestConstants.NUM_FOUR);
			errorInfo.setErrorMessage("Exception:" + TestConstants.EMPTY_SPACE + exception.getMessage());
			productResponse.setErrorInfo(errorInfo);
			response = Response.status(Status.OK).entity(productResponse).build();
		}
		logger.info("Ending createProductEntry -->");
		return response;
	}
	
	/**
	 * This method is for update the product
	 * @param productDetails
	 * @param product_id
	 * @return
	 */
	
	@PUT
	@Path(TestConstants.PRODUCT_PATH)
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response updateProductEntry(@Valid @RequestBody final Product productDetails,@QueryParam(TestConstants.PRODUCT_ID) String product_id) {
		logger.info("Entering  updateProductEntry -->");	
		
		Response response = null;
		
		
		// Checking product_id are mandatory for product entry
		 
		try {
			if (isNullOrEmpty(product_id)) {
				logger.error("product_id is missing in input request");
				productResponse.setFound(TestConstants.NUM_ZERO);
				productResponse.setStatusMessage("Mandatory fileds are null or empty or missing");
				errorInfo.setErrorMessage("Mandatory fileds are null or empty or missing");
				errorInfo.setErrorCode(TestConstants.NUM_ZERO);
				errorInfo.setHttpStatus(TestConstants.STATUS_NOT_FOUND);
				productResponse.setErrorInfo(errorInfo);
				response = Response.status(Status.BAD_REQUEST).entity(productResponse).build();
			} else {
				logger.error("Valid INPUT_DATA: Mandtory are valid in input request");
				response = delegator.createEntryInProduct(productDetails);				
				logger.info("response: " + response);
				
				productDetails.setProduct_id(Long.valueOf(product_id));
				logger.info("product_id" + ": " + productDetails.getProduct_id());
				response = delegator.updateProduct(productDetails);
				logger.info("response: " + response);
			}
		} catch (BussinessException exception) {
			logger.error("BussinessException:" + TestConstants.EMPTY_SPACE + exception.getMessage());
			productResponse.setFound(TestConstants.NUM_ZERO);
			errorInfo.setHttpStatus(TestConstants.STATUS_NOT_FOUND);
			errorInfo.setErrorCode(TestConstants.NUM_ONE);
			errorInfo.setErrorMessage("Exception occured while connecting to a database" + TestConstants.EMPTY_SPACE + exception.getMessage());
			productResponse.setErrorInfo(errorInfo);
			response = Response.status(Status.OK).entity(productResponse).build();
		} catch (Exception exception) {
			logger.error("BussinessException:" + TestConstants.EMPTY_SPACE + exception.getMessage());
			productResponse.setFound(TestConstants.NUM_ZERO);
			errorInfo.setHttpStatus(String.valueOf(TestConstants.NUM_500));
			errorInfo.setErrorCode(TestConstants.NUM_FOUR);
			errorInfo.setErrorMessage("Exception:" + TestConstants.EMPTY_SPACE + exception.getMessage());
			productResponse.setErrorInfo(errorInfo);
			response = Response.status(Status.OK).entity(productResponse).build();
		}
		logger.info("Ending updateProductEntry -->");
		return response;
	}
	/**
	 * This method used for get the Product details  through Product_id
	 * @param product_id
	 * @return
	 */
	
	@GET
	@Path(TestConstants.PRODUCT_PATH)
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getProductDetails(@QueryParam(TestConstants.PRODUCT_ID) String product_id) {
		logger.info("Entering getProductDetails -->");
		logger.info(TestConstants.PRODUCT_ID +" : " +product_id);
		Response response = null;
		try {

			if (isNullOrEmpty(product_id)) {
				logger.error("product_id is missing in input request");
				productResponse.setFound(TestConstants.NUM_ZERO);
				productResponse.setStatusMessage("Mandatory fileds are null or empty or missing");
				errorInfo.setErrorMessage("Mandatory fileds are null or empty or missing");
				errorInfo.setErrorCode(TestConstants.NUM_ZERO);
				errorInfo.setHttpStatus(TestConstants.STATUS_NOT_FOUND);
				productResponse.setErrorInfo(errorInfo);
				response = Response.status(Status.BAD_REQUEST).entity(productResponse).build();
			}

			else {
				product_id = product_id.trim();				
				productResponse.setProduct_id(Long.valueOf(product_id));
				response = delegator.getProductByID(productData);
				logger.info(productData);
				}

		} catch (NGCCBussinessException exception) {
			logger.error("BussinessException:" + TestConstants.EMPTY_SPACE + exception.getMessage());
			productResponse.setFound(TestConstants.NUM_ZERO);
			errorInfo.setHttpStatus(TestConstants.STATUS_NOT_FOUND);
			errorInfo.setErrorCode(TestConstants.NUM_ONE);
			errorInfo.setErrorMessage("Exception occured while connecting to a database" + TestConstants.EMPTY_SPACE + exception.getMessage());
			productResponse.setErrorInfo(errorInfo);
			response = Response.status(Status.OK).entity(productResponse).build();
		} catch (Exception exception) {
			logger.error("BussinessException:" + TestConstants.EMPTY_SPACE + exception.getMessage());
			productResponse.setFound(TestConstants.NUM_ZERO);
			errorInfo.setHttpStatus(String.valueOf(TestConstants.NUM_500));
			errorInfo.setErrorCode(TestConstants.NUM_FOUR);
			errorInfo.setErrorMessage("Exception:" + TestConstants.EMPTY_SPACE + exception.getMessage());
			productResponse.setErrorInfo(errorInfo);
			response = Response.status(Status.OK).entity(productResponse).build();
		}
		logger.info("Ending getProductDetails -->");
		return response;
	}
	
	public static boolean isNullOrEmpty(String str) {
		boolean isEmpty = true;
		if (str != null && !str.trim().isEmpty()) {
			isEmpty = false;
		}
		return isEmpty;
	}

}
