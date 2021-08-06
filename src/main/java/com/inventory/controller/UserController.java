package com.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.model.User;
import com.inventory.model.UserRole;
import com.inventory.model.UserRolePermission;
import com.inventory.service.UserRoleService;
import com.inventory.service.UserService;

@RestController
@RequestMapping(value = "/inventory/api")
public class UserController {

	@Autowired
	UserService userService;
	@Autowired
	UserRoleService userRoleService;

	@GetMapping("/user")
	public List<User> getAllUsers() throws Exception {
		
		return userService.getAll();
	}

	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable("id") int userId) throws Exception {
		return userService.getById(userId);
	}

	@PostMapping("/user")
	public int createUser(@RequestBody User user) throws Exception {
		return userService.create(user);
	}

	@PutMapping("/user/{id}")
	public int updateUser(@RequestBody User user, @PathVariable("id") int userId) throws Exception {
		return userService.update(user, userId);
	}

	@GetMapping("/userRole")
	public List<UserRole> getAllUserRoles() throws Exception {
		return userRoleService.getAll();
	}

	@GetMapping("/userRole/{id}")
	public UserRole getUserRoleById(@PathVariable("id") int userRoleId) throws Exception {
		return userRoleService.getById(userRoleId);
	}

	@PostMapping("/userRole")
	public int createUserRole(@RequestBody UserRole userRole) throws Exception {
		return userRoleService.create(userRole);
	}

	@PutMapping("/userRole/{id}")
	public int updateUserRole(@RequestBody UserRole userRole, @PathVariable("id") int userRoleId) throws Exception {
		return userRoleService.update(userRole, userRoleId);
	}

	@GetMapping("/userRolePermission/{id}")
	public List<UserRolePermission> getAllUserRolePermission(@PathVariable("id") int userId) throws Exception {
		return userRoleService.getUserRolePermission(userId);
	}

}
