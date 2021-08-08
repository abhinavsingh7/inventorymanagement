package com.inventory.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
public class OrderDto {

	private int id;
	@NonNull
	private String orderTitle;
	@NonNull
	private String fname;
	@NonNull
	private String lname;
	@NonNull
	private int productId;
	@NonNull
	private String noShipped;
	@NonNull
	private int orderBy;
	private String orderByName;
	private String productName;
	private String orderDate;
}
