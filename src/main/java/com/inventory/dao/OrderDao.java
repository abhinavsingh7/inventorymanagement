package com.inventory.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.inventory.config.DataSourceConfig;
import com.inventory.dto.OrderDto;
import com.inventory.mapper.OrderRowMapper;
import com.inventory.mapper.PurchaseRowMapper;

@Repository
public class OrderDao implements AppDao<OrderDto> {

	@Autowired
	private DataSourceConfig dataSource;

	@Override
	public Integer create(OrderDto t) throws Exception {
		String sql = "insert into orders(title,first,last,productId,numberShipped,orderBy) values(?,?,?,?,?,?)";
		return dataSource.getJdbcTemplate().update(sql, new Object[] { t.getOrderTitle(), t.getFname(), t.getLname(),
				t.getProductId(), t.getNoShipped(), t.getOrderBy() });
	}

	@Override
	public OrderDto getById(int id) throws Exception {
		String sql = "select o.orderId,o.title,o.first,o.last,o.numberShipped,o.orderDate,p.productName as productName,au.firstname as orderByName from orders o "
				+ "inner join product p on o.productId=p.id " + "inner join app_user au on o.orderBy=au.userId "
				+ "where o.orderId=?";
		return dataSource.getJdbcTemplate().queryForObject(sql, new OrderRowMapper(), id);
	}

	@Override
	public List<OrderDto> getAll() throws Exception {
		String sql = "select od.orderId, od.title, od.first, od.last, od.numberShipped, od.orderDate, pd.productName as productName, au.firstname as orderByName from orders od "
				+ "inner join product pd on pd.id=od.productId " + "inner join app_user au on au.userId=od.orderBy";
		return dataSource.getJdbcTemplate().query(sql, new OrderRowMapper());
	}

	@Override
	public void addAll(List<OrderDto> t) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public Integer update(OrderDto t, int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
