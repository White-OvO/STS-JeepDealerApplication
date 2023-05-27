package com.promineotech.EbayClient.entity;

import java.math.BigDecimal;
import java.sql.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

//@Id
//@GeneratedValue(strategy = GenerationType.IDENTITY)
public class Transactions {
	//@Id                                         //JPA entity must have a primary key that uniquely identifies it. The @Id annotation defines the primary key.
	//@GeneratedValue(strategy = GenerationType.IDENTITY)         //(Optional) The primary key generation strategy that the persistence provider must use to generate the annotated entity primary key.
private int	transaction_id;
private int customer_id;
private Date date_sold;
private BigDecimal buyer_paid;           ///???????????????????????? big decimal or int? check default transaction line 53 also change to schema line 50
private BigDecimal taxes_per_transaction;			/// ????????? do i chaneg this to big decinal as well? refrence: default transactions DAO
private BigDecimal shipping_cost;
private BigDecimal seller_fee;
//
//	private Long transactionId;
//
//		@Column(name = "customer_id")
//	private int customer_id;
//		@Column(name = "date_sold")
//	private String date_sold;	
//		@Column(name = "buyer_paid")
//	private int buyer_paid;	
//		@Column(name = "taxes_per_transaction")
//	private int taxes_per_transaction; 	
//		@Column(name = "Seller_fee")
//	private int seller_fee;
//		public Long getTransactionId() {
//			return transactionId;
//		}
//		public void setTransactionId(Long transactionId) {
//			this.transactionId = transactionId;
//		}
//		public int getCustomer_id() {
//			return customer_id;
//		}
//		public void setCustomer_id(int customer_id) {
//			this.customer_id = customer_id;
//		}
//		public String getDate_sold() {
//			return date_sold;
//		}
//		public void setDate_sold(String date_sold) {
//			this.date_sold = date_sold;
//		}
//		public int getBuyer_paid() {
//			return buyer_paid;
//		}
//		public void setBuyer_paid(int buyer_paid) {
//			this.buyer_paid = buyer_paid;
//		}
//		public int getTaxes_per_transaction() {
//			return taxes_per_transaction;
//		}
//		public void setTaxes_per_transaction(int taxes_per_transaction) {
//			this.taxes_per_transaction = taxes_per_transaction;
//		}
//		public int getSeller_fee() {
//			return seller_fee;
//		}
//		public void setSeller_fee(int seller_fee) {
//			this.seller_fee = seller_fee;
//		}
//		public Transactions(Long transactionId, int customer_id, String date_sold, int buyer_paid,
//				int taxes_per_transaction, int seller_fee) {
//			super();
//			this.transactionId = transactionId;
//			this.customer_id = customer_id;
//			this.date_sold = date_sold;
//			this.buyer_paid = buyer_paid;
//			this.taxes_per_transaction = taxes_per_transaction;
//			this.seller_fee = seller_fee;
//		}
//		@Override
//		public String toString() {
//			return "Transactions [transactionId=" + transactionId + ", customer_id=" + customer_id + ", date_sold="
//					+ date_sold + ", buyer_paid=" + buyer_paid + ", taxes_per_transaction=" + taxes_per_transaction
//					+ ", seller_fee=" + seller_fee + "]";
//		}	
//		
//		

}
