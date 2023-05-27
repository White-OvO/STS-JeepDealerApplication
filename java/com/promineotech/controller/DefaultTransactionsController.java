package com.promineotech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.EbayClient.entity.Transactions;
import com.promineotech.Service.TransactionsService;

import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
public class DefaultTransactionsController implements transactionsController{
	
	@Autowired
	
	private TransactionsService transactionsService;
	
	
	@Override
	
	public List<Transactions> fetchAllTransactions(){
		return transactionsService.fetchAllTransactions();
	}

}
