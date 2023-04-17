package com.promineotech.jeep.dao;

import java.util.List;

import com.promineotech.jeep.entity.Jeep;
import com.promineotech.jeep.entity.JeepModel;


public interface JeepSalesDao {									//	step 2 week 15
List<Jeep>fetchJeeps(JeepModel model, String trim);				// Add a method in the DAO interface and implementation that returns a list of Jeep models (class Jeep) and takes the model and trim parameters

}
