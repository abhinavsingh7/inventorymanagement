package com.inventory.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Purchase {

	private int purchaseId;
	private int supplierId;
	private int productId;
	private int noReceived;
	private String purchaseDate;
	
}
