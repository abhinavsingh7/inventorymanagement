package com.inventory.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.dao.AppDao;
import com.inventory.dao.OrderDao;
import com.inventory.dto.OrderDto;
import com.inventory.model.Order;

@Service
public class OrderService implements AppService<Order> {

	@Autowired
	private OrderDao odao;

	@Override
	public Integer create(Order t) throws Exception {
		OrderDto odto = new OrderDto(t.getOrderTitle(), t.getFname(), t.getLname(), t.getProductId(), t.getNoShipped(),
				t.getOrderBy());
		return odao.create(odto);
	}

	@Override
	public Order getById(int id) throws Exception {
		OrderDto odto = odao.getById(id);
		Order order = new Order(odto.getId(), odto.getOrderTitle(), odto.getFname(), odto.getLname(),
				odto.getProductName(), odto.getNoShipped(), odto.getOrderDate(), odto.getOrderByName(),
				odto.getProductId(), odto.getOrderBy());
		return order;
	}

	@Override
	public List<Order> getAll() throws Exception {
		List<OrderDto> odtoList = odao.getAll();
		List<Order> oList = odtoList.stream()
				.map(odto -> new Order(odto.getId(), odto.getOrderTitle(), odto.getFname(), odto.getLname(),
						odto.getProductName(), odto.getNoShipped(), odto.getOrderDate(), odto.getOrderByName(),
						odto.getProductId(), odto.getOrderBy()))
				.collect(Collectors.toList());
		return oList;
	}

	@Override
	public void addAll(List<Order> t) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public Integer update(Order t, int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
