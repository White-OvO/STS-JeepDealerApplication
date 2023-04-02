package com.promineotech.jeep.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import com.promineotech.jeep.entity.Jeep;
import com.promineotech.jeep.entity.JeepModel;
//STEP 19: Add the controller implementation class named DefaultJeepSalesController.  
@RestController 
// a special controller to implements interfaces .
// making it a self controller tells sts its  CONTROLER that which looks for interfaces taht are attached to /jeep.
public class DefaultJeepSalesController implements JeepSalesController { 


@Override
	public List <Jeep> fetchJeeps( JeepModel model, String trim) { 
		return null;
	}
} 
