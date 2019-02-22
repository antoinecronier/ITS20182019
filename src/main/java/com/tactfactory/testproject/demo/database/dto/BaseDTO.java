package com.tactfactory.testproject.demo.database.dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.tactfactory.testproject.demo.entities.base.BaseEntity;

public interface BaseDTO<T extends BaseEntity> {

	T parseIn(ResultSet rs) throws SQLException;
	String parseOut(T item);
}
