package com.promineotech.jeep.service;
// STEP 3: Add a service layer in your application as shown in the videos:
//Add a package named com.promineotech.jeep.service.
//In the new package, create an interface named JeepSalesService.
//In the same package (service), create a class named DefaultJeepSalesService
//that implements the JeepSalesService interface. Add the class-level annotation, @Service.

//import java.awt.Image;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.promineotech.jeep.entity.Image;
//import com.promineotech.jeep.entity.Image;
//import com.fasterxml.jackson.annotation.JacksonInject;
//import com.promineotech.jeep.dao.JeepSalesDao;
import com.promineotech.jeep.entity.Jeep;
import com.promineotech.jeep.entity.JeepModel;


public interface JeepSalesService {
	
	List<Jeep>fetchJeeps(JeepModel model, String trim);

	String uploadImage(MultipartFile image, Long jeepPK);

	
	
	
	Image retrieveImage(String imageId);
			
			
			
			
}