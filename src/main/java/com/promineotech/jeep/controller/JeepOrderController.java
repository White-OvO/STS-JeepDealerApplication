package com.promineotech.jeep.controller;


import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.promineotech.jeep.entity.Jeep;
import com.promineotech.jeep.entity.Order;
import com.promineotech.jeep.entity.OrderRequest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
@Validated
@RequestMapping("/orders")
public interface JeepOrderController {
																//week 16 step 11 : Create a method in the interface to create an order (createOrder).
	@Operation (
			summary = "Create an order for a jeep",
			description = "Returns the created Jeep",
			responses = { 
					@ApiResponse(responseCode = "201",
							description = "The created Jeep is returned",
							content = @Content (mediaType = "application/json",
							schema = @Schema(implementation = Jeep.class))),
					
					@ApiResponse(responseCode = "400",   
					//to not be found
							description = "The requested parametes are invalid",
							content = @Content (mediaType = "application/json")),
					@ApiResponse(responseCode = "404",
							description = "A Jeep component was not found with the input criteria",
							content = @Content(mediaType = "application/json")),
					@ApiResponse(responseCode = "500",          
							description = "An unplanned error occurred",
							content = @Content(mediaType = "application/json")),
			
			},
			parameters = {                                
					@Parameter(name = "orderRequest",
							required = true,
							description = "The order as JSON"),
			}
		)
		@PostMapping
		@ResponseStatus(code = HttpStatus.CREATED)
	Order createOrder(@Valid @RequestBody OrderRequest orderRequest);           //week  step: 14 add class-level annotation @Validated to the JeepOrderController interface
			//request para throwing a request to the body
	//binding it to orderRequest
			
			
			
																		//It should return an object of type Order (see below). It should accept a single 
																	  //parameter of type OrderRequest as described in the video. Make sure it accepts an 
																	//HTTP POST request and returns a status code of 201 (created). 
																//Add the @RequestBody annotation to the orderRequest parameter. Make sure to add the RequestBody annotation from the org.springframework.web.bind.annotation package.

}

