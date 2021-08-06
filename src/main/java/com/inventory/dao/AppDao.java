package com.inventory.dao;

import java.util.List;

import org.springframework.stereotype.Service;


public interface AppDao<T> {

	public Integer create(T t) throws Exception;

	public Integer update(T t, int id) throws Exception;

	public T getById(int id) throws Exception;

	public List<T> getAll() throws Exception;

	public void addAll(List<T> t) throws Exception;
	
}
