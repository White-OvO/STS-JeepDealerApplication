package com.promineotech.jeep.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import com.promineotech.jeep.entity.Jeep;
import com.promineotech.jeep.entity.JeepModel;

import lombok.extern.java.Log;
//STEP 19: Add the controller implementation class named DefaultJeepSalesController.  
@RestController 
// a special controller to implements interfaces .
// making it a self controller tells sts its  CONTROLER that which looks for interfaces taht are attached to /jeep.

//@slf4j
public class DefaultJeepSalesController implements JeepSalesController { 


@Override
	public List <Jeep> fetchJeeps( JeepModel model, String trim) { 
	
	return null;
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