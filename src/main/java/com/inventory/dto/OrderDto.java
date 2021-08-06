package com.inventory.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderDto {

	private int id;
	private String orderTitle;
	private String fname;
	private String lname;
	private String productName;
	private int noShipped;
	private int orderBy;
}
