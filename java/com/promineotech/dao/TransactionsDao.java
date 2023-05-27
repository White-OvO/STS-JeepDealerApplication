package com.promineotech.dao;

import java.util.List;

import com.promineotech.EbayClient.entity.Transactions;

public interface TransactionsDao {

	
	
// CRUD read for transcations;
	public  List<Transactions> fetchAllTransactions();
	
}
