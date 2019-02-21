package com.tactfactory.testproject.demo.dao;

import java.util.List;

import com.tactfactory.testproject.demo.entities.base.BaseEntity;

public interface BaseEntityDAO <T extends BaseEntity>{

	T save(T item);
	List<T> save(List<T> items);

	T getById(Long id);
	List<T> get();

	Boolean delete(T item);
	Boolean delete(List<T> items);

	void createTable();
	void deleteTable();
}
