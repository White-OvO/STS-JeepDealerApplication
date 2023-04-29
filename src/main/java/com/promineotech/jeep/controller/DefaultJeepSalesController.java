package com.promineotech.jeep.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mysql.cj.log.Log;
import com.promineotech.jeep.entity.Jeep;
import com.promineotech.jeep.entity.JeepModel;
import com.promineotech.jeep.service.JeepSalesService;

import lombok.extern.slf4j.Slf4j;

//import lombok.extern.slf4j.Slf4j;
//STEP 19: Add the controller implementation class named DefaultJeepSalesController.  
//@RestController 
// a special controller to implements interfaces .
// making it a self controller tells sts its  CONTROLER that which looks for interfaces taht are attached to /jeep.
@RestController


@Slf4j 
public class DefaultJeepSalesController implements JeepSalesController { 
//@Override
	
	
	@Autowired
	private JeepSalesService jeepSalesService;

	@Override
	public List<Jeep> fetchJeeps(JeepModel model, String trim) {
		log.info("Model = {}, Trim = {}", model, trim);

		return jeepSalesService.fetchJeeps(model, trim);

	}

	@Override
	public String uploadImag(MultipartFile image, Long jeepPK) {
		log.debug("image={}, jeepPK={}", image, jeepPK);
		//return 
		String imageId = jeepSalesService.uploadImage(image, jeepPK);
        String json = "{\"imageId\":\"" + imageId + "\"}";
      
        
        return json;
	
	
	}

//	@Override
//	public String uploadImage(MultipartFile image, Long jeepPK) {
//log.debug("image={}, jeepPK={}", image, jeepPK);
//		return "success!";
//		
    }
//}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//		@slf4j can take any log in; 
// 		login from spring boot is then implemented in log
//		an appplicatipon sets loggers to log at the info level
//		but not every log.() is the same. if for instance we choose 
//		log.debugger wont get logged if the logging. is set to info
//		inside of the log.() it can represent a string of any type we
//		used mode in trim in line 19 and made an open input for them with 
//		the curly brackets. followed by the type strings

// 		Log.info("model ={}, trim={},", model, trim);
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////