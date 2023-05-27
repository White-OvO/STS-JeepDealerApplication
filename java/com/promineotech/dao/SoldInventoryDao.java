package com.promineotech.dao;

import java.util.List;

import com.promineotech.EbayClient.entity.SoldInventory;

public interface SoldInventoryDao {

	
	
	// CRUD reads sold inventory
	public List<SoldInventory> fetchAllSoldInventory();
}
