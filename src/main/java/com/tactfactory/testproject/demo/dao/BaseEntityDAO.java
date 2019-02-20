package com.tactfactory.testproject.demo.dao;

import com.tactfactory.testproject.demo.entities.base.BaseEntity;

public interface BaseEntityDAO <T extends BaseEntity>{

	T save(T item);
	T getById(Long id);
	Boolean delete(T item);

	void createTable();
	void deleteTable();
}
