package com.promineotech.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import io.swagger.v3.oas.annotations.Parameter;

import io.swagger.v3.oas.annotations.info.Info;


import com.promineotech.EbayClient.entity.Customer;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated 
	@RequestMapping("/customer")
	@OpenAPIDefinition(info = @Info(title = "Ebay client"), servers = {
			@Server(url = "http://localhost:8080", description = "Local server.")})


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//							returns a list of customers
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public interface CustomerController {
	@Operation (
			summary = "Returns a list of customers",
			description = "Returns a full list of customers",
			responses = {
				@ApiResponse(
					responseCode = "200",
					description = "A list of Customers is returned",
					content = @Content(
						mediaType = "application/json",
						schema = @Schema(implementation = Customer.class))),
				@ApiResponse(
						responseCode = "400",
						description = "The request parameters are invalid",
						content = @Content(mediaType = "application/json")),
				@ApiResponse(
						responseCode = "404",
						description = "No customers were found.",
						content = @Content(mediaType = "application/json")),
				
				@ApiResponse(
						responseCode = "500",
						description = "An unplanned error occured.",
						content = @Content(mediaType = "application/json")),
			}
		)
		
		@GetMapping//("/allcustomers")
		@ResponseStatus(code = HttpStatus.OK)
		List<Customer> fetchAllCustomers(
				);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
					//	creates a new customer
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	
	@Operation(
			summary = "Creates a new Customer",
			description = "Returns the newly created customer",
			responses = {
					@ApiResponse(
							responseCode = "201",
							description = "A new customers has been created",
							content = @Content(
									mediaType = "application/json",
									schema = @Schema(implementation = Customer.class))),
					@ApiResponse(
							responseCode = "400",
							description = "The request parameters are invalid",
							content = @Content(mediaType = "application/json")),
					@ApiResponse(
							responseCode = "404",
							description = "No customers were found.",
							content = @Content(mediaType = "application/json")),
		
					@ApiResponse(
							responseCode = "500",
							description = "An unplanned error occured.",
							content = @Content(mediaType = "application/json")),
			},
			
			parameters = {
					@Parameter(name = "EbayUser",
							allowEmptyValue = false,
							required = false,
							description = "The customers local Ebay-name"),
									}
		)
	@PostMapping("/createcustomer")
	@ResponseStatus(code = HttpStatus.CREATED)
	Customer createCustomer(String EbayUser);
//////////////////////////////////////////////////////////////////////////////////////////////////////////	
	// updates an existing customer
//////////////////////////////////////////////////////////////////////////////////////////////////////////
@Operation(
		summary = "Updates an existing customer",
		description = "Returns updated existing customer",
		responses = {
				@ApiResponse(
						responseCode = "200",
						description = "Returns updated existing customer",
						content = @Content(
								mediaType = "application/json",
								schema = @Schema(implementation = Customer.class))),
				@ApiResponse(
						responseCode = "400",
						description = "The request parameters are invalid",
						content = @Content(mediaType = "application/json")),
				@ApiResponse(
						responseCode = "404",
						description = "No customers were found.",
						content = @Content(mediaType = "application/json")),
	
				@ApiResponse(
						responseCode = "500",
						description = "An unplanned error occured.",
						content = @Content(mediaType = "application/json")),

		},
		parameters = {
				@Parameter(name = "customer_id",
						allowEmptyValue = false,
						required = false,
						description = "The customer's ID within the EbayUsers database"),

		}
		)
//////////////////////////////////////////////////////////////////////////////////////////////////////////
//                                 update customer table
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

                                     @PutMapping("/updatecustomer")
//updating customer
                                     @ResponseStatus(code = HttpStatus.OK)
                                     Customer updateCustomer (int customerId, String updatedCustomer);

@Operation(
		summary = "Deletes an existing customer",
		description = "Deletes an existing customer",
		responses = {
				@ApiResponse(
						responseCode = "200",
						description = "Customer record was deleted",
						content = @Content(
								mediaType = "application/json",
								schema = @Schema(implementation = Customer.class))),
				@ApiResponse(
						responseCode = "400",
						description = "The request parameters are invalid",
						content = @Content(mediaType = "application/json")),
				@ApiResponse(
						responseCode = "404",
						description = "No customers were found.",
						content = @Content(mediaType = "application/json")),
	
				@ApiResponse(
						responseCode = "500",
						description = "An unplanned error occured.",
						content = @Content(mediaType = "application/json")),

		},
		parameters = {
				@Parameter(name = "customerId",
						allowEmptyValue = false,
						required = false,
						description = "customerId (i.e., 2)"),
		}
		)


@DeleteMapping("/deletecustomer")
@ResponseStatus(code = HttpStatus.OK)
void deleteCustomer (int customerId);		
}


