package com.promineotech.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import com.promineotech.EbayClient.entity.Customer;

import lombok.extern.slf4j.Slf4j;

@Component


@Slf4j

public class DefaultCustomerDao implements CustomerDao{

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	// crud Read the entire list of customers
	
	
	@Override
	public List<Customer> fetchAllCustomer() {
	
		String sql = "" 
				+"SELECT *"
				+"FROM customer";
		
		Map<String, Object> params = new HashMap<>();
		

		
		return jdbcTemplate.query(sql, params, new RowMapper<>() {
	
		
			
			@Override
			// maps the columns name to the variable in the customer table
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	///////                 does my sql connection need to be the same as the database??????????????????????????????????
			public Customer mapRow(ResultSet rs, int rowNum)throws SQLException {
				return Customer.builder() 
						.customerId(rs.getInt("customer_id"))
						.EbayUsername(rs.getString("ebay_username"))
						.build();
				
			}});
		
	}
	//////////////// creates a new method
	@Override
public Customer createCustomer(String Ebay_username) {
		SqlParams params = new SqlParams();
		KeyHolder keyHolder = new GeneratedKeyHolder();
		params.sql = ""
			+ "INSERT into customer"
			+ "(customer_Id, Ebay_username)"
		    + "VALUES (:customer_id, :Ebay_username)"; 
	   params.source.addValue("Ebay_username", Ebay_username);
	   
	   jdbcTemplate.update(params.sql, params.source, keyHolder);
		return Customer.builder()
				//.customerId(KeyHolder.getKey().intValue())
				.customerId(keyHolder.getKey().intValue())
				.EbayUsername(Ebay_username)
				.build();
	
	}
	
	class SqlParams {
		
		String sql;
		MapSqlParameterSource source = new MapSqlParameterSource();
	}
	
	@Override
	// update existing customer @ database
	
	public Customer updateCustomer(int customerId, String updatedCustomer) {
		String sql = ""
				+ "UDPATE customer"
				+"SET "
				+"customer_id = :customer_id,"
				+"Ebay_username = :Ebay_username"
				+"WHERE customer_id = :customer_id; ";
		
		
		// is my Ebay_username correct ????????????????????????????????????????????????????
		Map<String, Object> params = new HashMap<>();
		params.put("Ebay_username", updatedCustomer);
		params.put("customer_id", customerId);
		////////////////////////
		//////     is my sql string Ebay corrct?????????????????????????????????????????????????????????????????????
		
		if (jdbcTemplate.update(sql,params) == 0) {
			throw new NoSuchElementException("failed to update customer");
		}
		return Customer.builder()	
				.customerId(customerId)
				.EbayUsername(updatedCustomer)
				.build();
	}
	
	
	@Override
	public void deleteCustomer(int deleteId) {
		String sql = ""
				+ "DELETE FROM customers "
				+ "WHERE customer_id = :customer_id;";
			
			Map<String, Object> params = new HashMap<>();
			
			params.put("customer_id", deleteId);
			if (jdbcTemplate.update(sql, params) == 0) throw new NoSuchElementException();
	
	}
	
	

}


