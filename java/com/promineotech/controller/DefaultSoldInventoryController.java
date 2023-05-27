package com.promineotech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.EbayClient.entity.SoldInventory;
import com.promineotech.Service.SoldInventoryService;

@RestController

public class DefaultSoldInventoryController implements SoldInventoryController{
	@Autowired
	
	private SoldInventoryService soldInventoryService;
	
	
	@Override
	public List<SoldInventory> fetchAllSoldInventory() { 
		return soldInventoryService.fetchAllSoldInventory();
		
	}
	
	
	

}
