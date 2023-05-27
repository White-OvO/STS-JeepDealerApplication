package com.promineotech.EbayClient.entity;
import lombok.Builder;
import lombok.Data;
//import lombok.Getter;
//import lombok.Setter;

@Data
@Builder



public class Customer {
	private int customerId;
	private String EbayUsername;

}
