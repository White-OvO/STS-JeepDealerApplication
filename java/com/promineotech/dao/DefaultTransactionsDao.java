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

import com.promineotech.EbayClient.entity.Transactions;

import lombok.extern.slf4j.Slf4j;



@Component
@Slf4j


public class DefaultTransactionsDao implements TransactionsDao{

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	
	@Override
	// list of all transacations
	
	public List<Transactions> fetchAllTransactions() {
		log.info("In transactions dao layer, fetch all transactions: ");
		
		
		String sql = ""
				+"SELECT * "
				+"FROM transactions";
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////  need help filing this final request
		
		
		
		
		Map<String, Object> params = new HashMap<>();
		return jdbcTemplate.query(sql,  params, new RowMapper<Transactions>() {
			@Override
			public Transactions mapRow(ResultSet rs, int rowNum) throws SQLException {
				return Transactions.builder()
						.transaction_id(rs.getInt("transaction_id"))
						.customer_id(rs.getInt("customer_id"))
						.date_sold(rs.getDate("date_sold"))
						.buyer_paid(rs.getBigDecimal("buyer_paid"))
						.taxes_per_transaction(rs.getBigDecimal("taxes_per_transaction"))
						.shipping_cost(rs.getBigDecimal("shipping_cost"))
						.seller_fee(rs.getBigDecimal("seller_fee"))
						.build();
			}
	});
	
}

}