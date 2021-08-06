package com.inventory.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.dao.ProductDao;
import com.inventory.dto.ProductDto;
import com.inventory.model.Product;

@Service
public class ProductService implements AppService<Product> {

	@Autowired
	ProductDao prodDao;

	@Override
	public Integer create(Product p) throws Exception {
		ProductDto pdto = new ProductDto(p.getId(), p.getProductName(), p.getProductLabel(), p.getInventoryReceive(),
				p.getInventoryShipp(), p.getMinRequired(), p.getBarcode());
		return prodDao.create(pdto);
	}

	@Override
	public Integer update(Product p, int id) throws Exception {
		ProductDto pdto = new ProductDto(p.getId(), p.getProductName(), p.getProductLabel(), p.getInventoryReceive(),
				p.getInventoryShipp(), p.getMinRequired(), p.getBarcode());
		return prodDao.update(pdto, id);
	}

	@Override
	public Product getById(int id) throws Exception {
		ProductDto pdto = prodDao.getById(id);
		return new Product(pdto.getId(), pdto.getProductName(), pdto.getProductLabel(), pdto.getInventoryReceive(),
				pdto.getInventoryShipp(), pdto.getMinRequired(), pdto.getBarcode());
	}

	@Override
	public List<Product> getAll() throws Exception {
		List<Product> pList = prodDao
				.getAll().stream().map(p -> new Product(p.getId(), p.getProductName(), p.getProductLabel(),
						p.getInventoryReceive(), p.getInventoryShipp(), p.getMinRequired(), p.getBarcode()))
				.collect(Collectors.toList());
		return pList;
	}

	@Override
	public void addAll(List<Product> t) throws Exception {
		// TODO Auto-generated method stub

	}
}
