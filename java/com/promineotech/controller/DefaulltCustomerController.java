package com.promineotech.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.EbayClient.entity.Customer;
import com.promineotech.Service.CustomerService;

import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j

public class DefaulltCustomerController implements CustomerController {
	@Autowired
	private CustomerService customerService;
	
	//READ (GET)

	@Override
	public List<Customer> fetchAllCustomers() {
		return customerService.fetchAllCustomer();
	}

	//CREATE (POST)
	@Override
	public Customer createCustomer(String EbayUsername) {
		return customerService.createCustomer(EbayUsername);
	}

	//UPDATE (PUT)

	@Override
	public Customer updateCustomer(int customerId, String updatedCustomer) {
		return customerService.updateCustomer(customerId, updatedCustomer);

	}

	//DELETE
	@Override
	public void deleteCustomer(int customerId) {
		log.debug("customerId={}", customerId);
		customerService.deleteCustomer(customerId);

	}

}

