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
//to exclude fields from constructor use @RequiredArgsConstructor and 	@NonNull
public class UserDto {

	private int userId;
	@NonNull
	private String firstName;
	@NonNull
	private String lasttName;
	@NonNull
	private String username;
	@NonNull
	private String phone;
	private String password;
	@NonNull
	private String isAdmin;
	@NonNull
	private int userRoleId;
	
}
