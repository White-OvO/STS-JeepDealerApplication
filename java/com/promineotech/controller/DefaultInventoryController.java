package com.promineotech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.EbayClient.entity.Inventory;
import com.promineotech.Service.InventoryService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j



public class DefaultInventoryController implements InventoryController{

	
	@Autowired
	
	private InventoryService inventoryService;

	
	@Override
	
	public List<Inventory> fetchAllInventory(){
		return inventoryService.fetchAllInventory();
	}
	
}
	
	

