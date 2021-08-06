package com.inventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.dao.AppDao;
import com.inventory.dao.OrderDao;
import com.inventory.model.Order;
@Service
public class OrderService implements AppService<Order> {

	@Autowired
	OrderDao inventoryDao;

	@Override
	public Integer create(Order t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer update(Order t, int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order getById(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> getAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addAll(List<Order> t) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
