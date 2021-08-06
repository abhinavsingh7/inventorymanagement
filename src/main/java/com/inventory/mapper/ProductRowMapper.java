package com.inventory.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.inventory.dto.ProductDto;
import com.inventory.model.Product;

public class ProductRowMapper implements RowMapper<ProductDto>{

	@Override
	public ProductDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProductDto prodDto=new ProductDto();
		prodDto.setId(rs.getInt("id"));
		prodDto.setProductName(rs.getString("productName"));
		prodDto.setInventoryReceive(rs.getString("inventoryReceived"));
		prodDto.setProductLabel(rs.getString("productLabel"));
		prodDto.setMinRequired(rs.getInt("minimumRequired"));
		prodDto.setBarcode(rs.getString("barcode"));
		return prodDto;
	}

}
