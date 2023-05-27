package com.promineotech.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.promineotech.EbayClient.entity.Inventory;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;
@Validated
@RequestMapping("/inventory")
@OpenAPIDefinition(info = @Info(title = "Inventory List"), servers = {
		@Server(url = "http://localhost:8080", description = "Local server.")})
public interface InventoryController {

	
	@Operation(
			summary = "Returns the list table for Inventory",
			description = "Retruns Your inventory",
			responses = {
				@ApiResponse(
					responseCode = "200",
					description = "The created Inventory is returned",
					content = @Content (
							mediaType = "application/json",
							schema = @Schema(implementation = Inventory.class))),
				@ApiResponse(
						responseCode = "400",
						description = "A Inventory component was not found with the input criteria",
						content = @Content (mediaType = "application/json")),
				
	
	
				@ApiResponse(
						
						responseCode = "500",
						description = "An unplanned error occured.",
						content = @Content (mediaType = "application/json")),

			}
	)	
	
	
	
	@GetMapping
	//@GetMapping("inventory_id") = to get by inventory id
	
	@ResponseStatus(code = HttpStatus.OK)
	List<Inventory> fetchAllInventory();
}
	
	// default controllers needs annotation rest controller
	//@controller is also in jpa
	
	
	
	
	
