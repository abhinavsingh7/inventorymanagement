package com.inventory.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

	private int id;
	private String productName;
	private String productLabel;
	private String inventoryReceive;
	private String inventoryShipp;
	private int minRequired;
	private String barcode;

}
