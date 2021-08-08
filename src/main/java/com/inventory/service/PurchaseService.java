package com.inventory.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.dao.PurchaseDao;
import com.inventory.dto.PurchaseDto;
import com.inventory.model.Purchase;

@Service
public class PurchaseService implements AppService<Purchase> {

	@Autowired
	PurchaseDao pdao;

	@Override
	public Integer create(Purchase t) throws Exception {
		PurchaseDto pdto = new PurchaseDto(t.getSupplierId(), t.getProductId(), t.getNoReceived());
		return pdao.create(pdto);
	}

	@Override
	public Purchase getById(int id) throws Exception {
		PurchaseDto pdto = pdao.getById(id);
		Purchase purchase = new Purchase(pdto.getPurchaseId(), pdto.getSupplierId(), pdto.getProductId(),
				pdto.getNoReceived(), pdto.getPurchaseDate(), pdto.getSupplierName(), pdto.getProductName());
		return purchase;
	}

	@Override
	public List<Purchase> getAll() throws Exception {
		List<PurchaseDto> pdtolist = pdao.getAll();
		List<Purchase> pList = pdtolist.stream()
				.map(pdto -> new Purchase(pdto.getPurchaseId(), pdto.getSupplierId(), pdto.getProductId(),
						pdto.getNoReceived(), pdto.getPurchaseDate(), pdto.getSupplierName(), pdto.getProductName()))
				.collect(Collectors.toList());
		return pList;
	}

	@Override
	public void addAll(List<Purchase> t) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public Integer update(Purchase t, int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
