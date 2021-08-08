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
public class Order implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private String orderTitle;
	private String fname;
	private String lname;
	private String productName;
	private String noShipped;
	private String orderDate;
	private String orderByName;
	private int productId;
	private int orderBy;

}
