package com.inventory.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.inventory.dto.OrderDto;

public class OrderRowMapper implements RowMapper<OrderDto> {

	@Override
	public OrderDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		OrderDto odto = new OrderDto();
		odto.setId(rs.getInt("orderId"));
		odto.setOrderTitle(rs.getString("title"));
		odto.setFname(rs.getString("first"));
		odto.setLname(rs.getString("last"));
//		odto.setProductId(rs.getInt("productId"));
		odto.setNoShipped(rs.getString("numberShipped"));
//		odto.setOrderBy(rs.getInt("orderBy"));
		odto.setOrderDate(rs.getString("orderDate"));
		odto.setProductName(rs.getString("productName"));
		odto.setOrderByName(rs.getString("orderByName"));
		return odto;
	}

}
