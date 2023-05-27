package com.promineotech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.EbayClient.entity.Transactions;

//import com.promineo.
//import javax.transaction.Transaction;
//import com.promineo.repository.TransactionsRepository;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;




@Validated
@RequestMapping("/Transactions")
@OpenAPIDefinition(info = @Info(title = "Transactions List"), servers = {
		@Server(url = "http://localhost:8080", description = "Local server.")})

public interface transactionsController {
	
	@Operation(
		summary = "Create an invoice for a Transaction",
		description = "Retruns the created Transaction",
		responses = {
			@ApiResponse(
				responseCode = "200",
				description = "The created Transaction is returned",
				content = @Content (
						mediaType = "application/json",
						schema = @Schema(implementation = Transactions.class))),
			@ApiResponse(
					responseCode = "400",
					description = "A Transaction component was not found with the input criteria",
					content = @Content (mediaType = "application/json")),
			
			////////////// do i need code 404?????????????????????????????????????
			@ApiResponse(
				
					responseCode = "500",
					description = "An unplanned error occured.",
					content = @Content (mediaType = "application/json")),

		}
)	
	
	@GetMapping//("/ebay_client")
	@ResponseStatus(code = HttpStatus.OK)
	List<Transactions> fetchAllTransactions(
			);
}
			  
			

