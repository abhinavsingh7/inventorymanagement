package com.inventory.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
public class Purchase implements Serializable {

	private static final long serialVersionUID = 1L;

	private int purchaseId;
	private int supplierId;
	private int productId;
	private int noReceived;
	private String purchaseDate;
	private String supplierName;
	private String productName;

}
