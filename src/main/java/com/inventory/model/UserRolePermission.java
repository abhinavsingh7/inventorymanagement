package com.inventory.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserRolePermission {

	private int urpid;
	private int userRoleId;
	private int ampId;
	private String hasPermission;
}
