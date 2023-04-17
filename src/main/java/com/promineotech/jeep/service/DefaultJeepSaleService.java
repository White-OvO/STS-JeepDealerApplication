package com.promineotech.jeep.service;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.jeep.dao.JeepSalesDao;

// week14
//Step 3 Add a service layer in your application as shown in the videos:
//         Add a package named com.promineotech.jeep.service.
//         In the new package, create an interface named JeepSalesService.
//         In the same package (service), create a class named DefaultJeepSalesService 
//         that implements the JeepSalesService interface. Add the class-level annotation, 
//         @Service.
//////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////
// week 14 step 6
//	Add a Lombok info-level log statement in the service implementation 
//	showing that the service was called	

import com.promineotech.jeep.entity.Jeep;
import com.promineotech.jeep.entity.JeepModel;

import lombok.extern.slf4j.Slf4j;


// starts the connection
//@RestController
@Service
@Slf4j
public class DefaultJeepSaleService implements JeepSaleService {// week14: step 5
//	Define the fetchJeeps method in the interface. Implement the method in the service class.
//	Call the method from the controller (make sure the controller returns the list of Jeeps
//	returned by the service method). The method signature looks like this:

	@Autowired
	private JeepSalesDao jeepSalesDao ; 

@Transactional(readOnly = true)
	@Override
	 public List<Jeep> fetchJeeps(JeepModel model, String trim){
	
			   log.info("The fetchJeeps method was called with arguments: (model= {}, trim=  {})", model , trim);
			 List<Jeep> jeeps = jeepSalesDao.fetchJeeps(model,  trim);
			 	if(jeeps.isEmpty()) {
			 			String msg = String.format("No jeeps found model=%s and trim=%s", model, trim);
			 			  throw new NoSuchElementException(msg); 
			 	
			 	}
	
	Collections.sort(jeeps);
	return jeeps;
	}
	
}
