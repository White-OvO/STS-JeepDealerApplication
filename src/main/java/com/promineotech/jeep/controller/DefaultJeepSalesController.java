package com.promineotech.jeep.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.jeep.entity.Jeep;
import com.promineotech.jeep.entity.JeepModel;
import com.promineotech.jeep.service.JeepSaleService;

import lombok.extern.slf4j.Slf4j;

//import lombok.extern.slf4j.Slf4j;
//STEP 19: Add the controller implementation class named DefaultJeepSalesController.  
//@RestController 
// a special controller to implements interfaces .
// making it a self controller tells sts its  CONTROLER that which looks for interfaces taht are attached to /jeep.
@Service   
@Slf4j 



public class DefaultJeepSalesController implements JeepSalesController { 
//@Override
	
	
@Autowired
private JeepSaleService jeepSaleService;

@Override
	public List <Jeep> fetchJeeps( JeepModel model, String trim) { 
	log.info("The fetchjeeps method was called with arguments: (model={}, trim = {}", model, trim);
	return jeepSaleService.fetchJeeps(model,trim);
	}
} 

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