package com.inventory.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.inventory.config.DataSourceConfig;
import com.inventory.dto.PurchaseDto;
import com.inventory.mapper.PurchaseRowMapper;

@Repository
public class PurchaseDao implements AppDao<PurchaseDto> {

	@Autowired
	private DataSourceConfig dataSource;

	@Override
	public Integer create(PurchaseDto t) throws Exception {
		String sql = "insert into purchase(supplierId,productId,numberReceived) values(?,?,?)";
		return dataSource.getJdbcTemplate().update(sql,
				new Object[] { t.getSupplierId(), t.getProductId(), t.getNoReceived() });
	}

	@Override
	public PurchaseDto getById(int id) throws Exception {
		String sql = "select pu.id,pu.numberReceived,pu.purchaseDate,pr.productName as productName,su.suppierName as supplierName from purchase as pu "
				+ "inner join product pr on pr.id=pu.productId " 
				+ "inner join supplier su on su.id=pu.supplierId "
				+ "where pu.id=?";
		return dataSource.getJdbcTemplate().queryForObject(sql, new Object[] { id }, new PurchaseRowMapper());
	}

	@Override
	public List<PurchaseDto> getAll() throws Exception {
		String sql = "select pu.id,pu.numberReceived,pu.purchaseDate,pr.productName as productName,su.suppierName as supplierName from purchase pu "
				+ "inner join product pr on pr.id=pu.productId "
				+ "inner join supplier su on su.id=pu.supplierId";
		return dataSource.getJdbcTemplate().query(sql, new PurchaseRowMapper());
	}

	@Override
	public void addAll(List<PurchaseDto> t) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public Integer update(PurchaseDto t, int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
