package com.promineotech.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.promineotech.EbayClient.entity.SoldInventory;
import com.promineotech.EbayClient.entity.Transactions;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;


@Validated
@RequestMapping("/SoldInventory")
@OpenAPIDefinition(info = @Info(title = "Sold inventory List"), servers = {
		@Server(url = "http://localhost:8080", description = "Local server.")})

public interface SoldInventoryController {
	
	@Operation(
		summary = "Create an invoice",
		description = "Retruns the created sold list",
		responses = {
			@ApiResponse(
				responseCode = "200",
				description = "The created sold inventory is returned",
				content = @Content (
						mediaType = "application/json",
						schema = @Schema(implementation = Transactions.class))),
			@ApiResponse(
					responseCode = "400",
					description = "A sold invoice component was not found with the input criteria",
					content = @Content (mediaType = "application/json")),
			
			////////////// do i need code 404?????????????????????????????????????
			@ApiResponse(
				
					responseCode = "500",
					description = "An unplanned error occured.",
					content = @Content (mediaType = "application/json")),

		}
)	
	
//	@GetMapping("/ebay_client")
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	List<SoldInventory> fetchAllSoldInventory(
			);
}
			  
