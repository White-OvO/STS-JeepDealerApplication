package com.promineotech.EbayClient.entity;

import lombok.Builder;
import lombok.Data;





@Data

@Builder

public class Inventory {
private int inventoryId;  // categoryid is an enum
private Category categoryId;
private int itemNumber;
private String itemName;
private int amountAvaliable;
// private boolean IsAvaliable;
private String sellerName;
}
