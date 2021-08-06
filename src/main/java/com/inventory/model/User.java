package com.inventory.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class User {
	private int id;
	private String firstName;
	private String lasttName;
	private String email;
	private String phone;
	private String password;
	private String isAdmin;
	private int userRoleId;

}
