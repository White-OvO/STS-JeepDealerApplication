package com.promineotech.jeep.service;
// STEP 3: Add a service layer in your application as shown in the videos:
//Add a package named com.promineotech.jeep.service.
//In the new package, create an interface named JeepSalesService.
//In the same package (service), create a class named DefaultJeepSalesService
//that implements the JeepSalesService interface. Add the class-level annotation, @Service.

import java.util.List;

//import com.fasterxml.jackson.annotation.JacksonInject;
//import com.promineotech.jeep.dao.JeepSalesDao;
import com.promineotech.jeep.entity.Jeep;
import com.promineotech.jeep.entity.JeepModel;


public interface JeepSaleService {
	
	List<Jeep>fetchJeeps(JeepModel model, String trim);
			
			
			
			
}