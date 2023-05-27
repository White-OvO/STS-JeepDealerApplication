package com.promineotech.EbayClient.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SoldInventory {
private int orderId;
private int EbayOrderNumber;
private int transactionId;
private int itemNumber;

}
