package com.tactfactory.testproject.demo.entities;

import com.tactfactory.testproject.demo.entities.base.BaseEntity;

public class Role extends BaseEntity {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Role() {
		super();
	}

	public Role(String name) {
		super();
		this.name = name;
	}
}
