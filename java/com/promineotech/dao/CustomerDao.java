package com.promineotech.dao;

import java.util.List;

import com.promineotech.EbayClient.entity.Customer;

public interface CustomerDao {

	
	///////////////////////////////////// should this line have fetchallcustomers or no s?????????????????????????????????????????????????????????
	List<Customer> fetchAllCustomer();
//create a new customer	
	Customer createCustomer(String EbayUsername);
	
// Update to an existing customer	
	Customer updateCustomer(int customerId,String updatedCustomer);
	
// will allows to delete customer from table	
//	void deleteCustomer(int customerId);
	void deleteCustomer(int customerId);
	
}
