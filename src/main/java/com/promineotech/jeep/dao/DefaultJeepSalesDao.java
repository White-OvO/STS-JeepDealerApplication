package com.promineotech.jeep.dao;
//step 1 week 15: 
//In the application you've been building add a DAO layer:
//Add the package, com.promineotech.jeep.dao.
//In the new package, create an interface named JeepSalesDao.
//In the same package, create a class named DefaultJeepSalesDao that implements JeepSalesDao.

import java.util.List;
import java.util.Map;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.mysql.cj.protocol.Resultset;
import com.promineotech.jeep.entity.Jeep;
import com.promineotech.jeep.entity.JeepModel;

import lombok.extern.slf4j.Slf4j;

   
@Service												// week 15 step 4
@Component
@Slf4j
public class DefaultJeepSalesDao implements JeepSalesDao {

@Autowired
private NamedParameterJdbcTemplate jdbcTemplate;        // week 15 step 5: In DefaultJeepSalesDao, inject an instance variable of type NamedParameterJdbcTemplate.
	
	
	
@Override
// 	Week 15: step 3 In the Jeep sales service implementation class, inject the DAO interface as an instance variable. 
//	The instance variable should be private and should be named jeepSalesDao. Call the DAO method from the service method and store the returned value in a local variable named jeeps

		 public List<Jeep> fetchJeeps(JeepModel model, String trim){		// week 15 step 4 
			log.debug("DAO: model={}, trim = {}", model, trim);           /// does calls to the DAO when we run the test Add a log statement in DefaultJeepSalesDao.fetchJeeps() that logs the model and trim level. Run the integration test. In your video, show the DAO implementation class and the log line in the IDE's console 
			
			//@formatter:off
		String sql = "" + "SELECT * "                                     // 
						+ "FROM models "                    
						+ "WHERE model_id = :model_id AND trim_level = :trim_level";    // week 15 step 5 Write SQL to return a list of Jeep models based on the parameters: model and trim. Be sure to utilize the SQL Injection prevention mechanism 
		
			//@formatter: on
		// map passed in parameter jdbc 
//	week 15 step 6  	Add the parameters to a parameter map as shown in the video. Don't forget to convert the JeepModel enum value to a String 
	Map<String, Object>params = new HashMap<>();
	params.put("model_id",model.toString());
	params.put("trim_level", trim);
	
	
	return jdbcTemplate.query(sql, params,
			new RowMapper<>(){
		@Override															// step 7: Call the query method on the NamedParameterJdbcTemplate instance variable to return a list of Jeep model objects. Use a RowMapper to map each row of the result set. Remember to convert modelId to a JeepModel. See the video for details. 
			public Jeep mapRow (ResultSet rs, int rowNum) throws SQLException{ 
			
			
			// @formatter:off
				return Jeep.builder() // missing trim level and wheel size
						.basePrice(new BigDecimal(rs.getString("base_price")))
						.modelId(JeepModel.valueOf(rs.getString("model_id")))
						.modelPk(rs.getLong("model_pk"))
						.numDoors(rs.getInt("trim_level"))
						.trimLevel(rs.getString("trim_level"))
						.wheelSize(rs.getInt("wheel_size"))
						.build();
		// formatter: on				
						
						
			
			
			}
			});
	 }
}

