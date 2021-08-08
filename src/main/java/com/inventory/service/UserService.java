package com.inventory.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.dao.UserDao;
import com.inventory.dto.UserDto;
import com.inventory.model.User;

@Service
public class UserService implements AppService<User> {
	// in service we are doing mapping from model<->dto
	@Autowired
	private UserDao userDao;

	@Override
	public Integer create(User t) throws Exception {
		return 1;
	}

	@Override
	public Integer update(User t, int id) throws Exception {
		UserDto udto = new UserDto(t.getFirstName(), t.getLasttName(), t.getEmail(), t.getPhone(), t.getIsAdmin(),
				t.getUserRoleId());
		return userDao.update(udto, id);
	}

	@Override
	public User getById(int id) throws Exception {
		UserDto udto = userDao.getById(id);
		User user = new User(udto.getUserId(), udto.getFirstName(), udto.getLasttName(), udto.getUsername(),
				udto.getPhone(), udto.getPassword(), udto.getIsAdmin(), udto.getUserRoleId());
		return user;
	}

	@Override
	public List<User> getAll() throws Exception {
		List<UserDto> udtoList = userDao.getAll();
		return udtoList.stream()
				.map(udto -> new User(udto.getUserId(), udto.getFirstName(), udto.getLasttName(), udto.getUsername(),
						udto.getPhone(), udto.getPassword(), udto.getIsAdmin(), udto.getUserRoleId()))
				.collect(Collectors.toList());
	}

	@Override
	public void addAll(List<User> t) throws Exception {
		// TODO Auto-generated method stub

	}

}
