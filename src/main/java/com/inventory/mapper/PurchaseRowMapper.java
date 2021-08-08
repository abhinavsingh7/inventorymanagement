package com.inventory.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.inventory.dto.ProductDto;
import com.inventory.dto.PurchaseDto;

public class PurchaseRowMapper implements RowMapper<PurchaseDto> {

	@Override
	public PurchaseDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		PurchaseDto pdto = new PurchaseDto();
		pdto.setPurchaseId(rs.getInt("id"));
//		pdto.setSupplierId(rs.getInt("supplierId"));
//		pdto.setProductId(rs.getInt("productId"));
		pdto.setNoReceived(rs.getInt("numberReceived"));
		pdto.setPurchaseDate(rs.getString("purchaseDate"));
		pdto.setSupplierName(rs.getString("supplierName"));
		pdto.setProductName(rs.getString("productName"));
		return pdto;
	}

}
