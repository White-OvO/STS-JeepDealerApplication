package com.promineotech.dao;

//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;


import com.promineotech.EbayClient.entity.Category;
import com.promineotech.EbayClient.entity.Inventory;

import lombok.extern.slf4j.Slf4j;


@Component
@Slf4j

public class DefaultInventoryDao implements InventoryDao{
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	
	
	
	@Override

	
	public List<Inventory> fetchAllInventory() {
		
		
		
		
		log.info("In inventory dao layer, fetch all inventory");
		
		String sql = ""
				+ "SELECT * "
				+ "FROM inventory";
		
		
		Map<String, Object> params = new HashMap<> ();
		return  jdbcTemplate.query(sql,  params, new RowMapper<Inventory>() {
			@Override
			public Inventory mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				return Inventory.builder()
						.inventoryId(rs.getInt("inventory_id"))
						.categoryId(Category.valueOf(rs.getString("category_id")))
						.itemNumber(rs.getInt("item_number"))
						.itemName(rs.getString("item_name"))
						.amountAvaliable(rs.getInt("amount_avaliable"))
						.sellerName(rs.getString("seller_name"))
						.build();
		
	}});
	
	

}

	
	
}