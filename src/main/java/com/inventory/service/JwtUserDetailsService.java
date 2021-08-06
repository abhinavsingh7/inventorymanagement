package com.inventory.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.inventory.dao.UserDao;
import com.inventory.dto.UserDto;
import com.inventory.model.User;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDto user = null;

		try {
			user = userDao.findByUsername(username);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),new ArrayList<>());

	}

	public Integer save(User user) throws Exception {
		UserDto newUser = new UserDto();
		newUser.setUsername(user.getEmail());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		newUser.setPhone(user.getPhone());
		newUser.setFirstName(user.getFirstName());
		newUser.setLasttName(user.getLasttName());
		//default values to new user
		newUser.setIsAdmin("N");
		newUser.setUserRoleId(2);
		return userDao.create(newUser);
	}
}
