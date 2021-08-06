package com.inventory.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.inventory.model.UserRole;
import com.inventory.model.UserRolePermission;

@Service
public class UserRoleService implements AppService<UserRole>{

	@Override
	public Integer create(UserRole t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer update(UserRole t, int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserRole getById(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserRole> getAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addAll(List<UserRole> t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public List<UserRolePermission> getUserRolePermission(int id){
		return null;
	}
}
