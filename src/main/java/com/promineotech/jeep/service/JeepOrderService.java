package com.promineotech.jeep.service;

import org.springframework.stereotype.Service;
import com.promineotech.jeep.entity.Order;

import com.promineotech.jeep.entity.OrderRequest;

@Service										//WEEK16 STEP 16
public interface JeepOrderService  {     //In the jeep.service sub-package, create the empty (no methods yet) order service interface (named JeepOrderService) and implementation (named DefaultJeepOrderService). 
	Order createOrder(OrderRequest orderRequest);										//Inject the interface into the order controller implementation class.
										//Add the @Service annotation to the service implementation class.
									//Create the createOrder method in the interface and implementing service. The method signature

}
