package com.promineotech.jeep.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.jeep.entity.OrderRequest;
import com.promineotech.jeep.service.JeepOrderService;
import com.promineotech.jeep.entity.Order;

import lombok.extern.slf4j.Slf4j;

//week 16 step 12 :Create a class that implements JeepOrderController named  DefaultJeepOrderController.
		//Add @RestController as a class-level annotation.Add a log line to the implementing controller 
			//method showing the input request body (orderRequest)
@RestController
@Slf4j

public class DefaultJeepOrderController implements JeepOrderController {
			//	public List<Jeep> fetchJeeps()	{													//  log line  implementing controller
@Autowired	
private JeepOrderService jeepOrderService;
//log.info("model = {},Trim ={}", model, trim);	
	public Order createOrder(OrderRequest orderRequest) {
	log.info("Order = {}",orderRequest);
		return jeepOrderService.createOrder(orderRequest);
		
	}
}