package com.inventory.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.inventory.dto.OrderDto;

@Repository
public class OrderDao implements AppDao<OrderDto>{

	@Override
	public Integer create(OrderDto t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer update(OrderDto t, int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderDto getById(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderDto> getAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addAll(List<OrderDto> t) throws Exception {
		// TODO Auto-generated method stub
		
	}



}
