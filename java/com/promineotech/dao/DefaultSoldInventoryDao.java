package com.promineotech.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.promineotech.EbayClient.entity.SoldInventory;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultSoldInventoryDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//@Override         // method overrides the base class method. For two reasons, the @Override annotation is useful. If the annotated method does not
						//actually override anything, the compiler issues a warning. It can help to make the source code more readable.
	public List<SoldInventory> fetchAllSoldInventory() {
		log.info("In all of sold inventoy dao. fetch all sold  inventory:");
		
		
		String sql = " "
				+ "SELECT * "
				+ "FROM sold_inventory";
		
		Map<String, Object> params = new HashMap<>();
		
		
		//should my directory be caps ?????
		return jdbcTemplate.query(sql, params, new RowMapper<SoldInventory>() {
			@Override
			
			// list ALL sold inventory
		public SoldInventory mapRow(ResultSet rs, int rowNum) throws SQLException {
				return SoldInventory.builder()
						.orderId(rs.getInt("order_id"))
						.EbayOrderNumber(rs.getInt("Ebay_order_number"))
						.transactionId(rs.getInt("transaction_id"))
						.itemNumber(rs.getInt("item_number"))
						.build();
			}
			
			
			
		});
	}
	
	
}
