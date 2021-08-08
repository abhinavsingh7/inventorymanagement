package com.inventory.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
public class PurchaseDto {
	private int purchaseId;
	@NonNull
	private int supplierId;
	@NonNull
	private int productId;
	@NonNull
	private int noReceived;
	private String purchaseDate;
	private String supplierName;
	private String productName;
}
