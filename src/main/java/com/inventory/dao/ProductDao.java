package com.inventory.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.inventory.config.DataSourceConfig;
import com.inventory.dto.ProductDto;
import com.inventory.mapper.ProductRowMapper;
import com.inventory.model.Product;

@Repository
public class ProductDao implements AppDao<ProductDto> {

	@Autowired
	private DataSourceConfig dataSource;

	@Override
	public Integer create(ProductDto t) throws Exception {
		String sql = "insert into product(productName,productLabel,inventoryReceived,inventoryShipped,minimumRequired,barcode) values(?,?,?,?,?,?)";
		return dataSource.getJdbcTemplate().update(sql, new Object[] { t.getProductName(), t.getProductLabel(),
				t.getInventoryReceive(), t.getInventoryShipp(), t.getMinRequired(), t.getBarcode() });
	}

	@Override
	public Integer update(ProductDto t, int id) throws Exception {
		String sql = "update product set productName=?,productLabel=?,inventoryReceived=?,inventoryShipped=?,minimumRequired=?,barcode=? where id=?";
		return dataSource.getJdbcTemplate().update(sql, new Object[] { t.getProductName(), t.getProductLabel(),
				t.getInventoryReceive(), t.getInventoryShipp(), t.getMinRequired(), t.getBarcode(), id});
	}

	@Override
	public ProductDto getById(int id) throws Exception {
		String sql = "Select * from product where id=?";
		return (ProductDto) dataSource.getJdbcTemplate().queryForObject(sql, new Object[] { id },
				new ProductRowMapper());
	}

	@Override
	public List<ProductDto> getAll() throws Exception {
		String sql = "Select * from product";
		return dataSource.getJdbcTemplate().query(sql, new ProductRowMapper());
	}

	@Override
	public void addAll(List<ProductDto> t) throws Exception {
		// TODO Auto-generated method stub

	}

}
