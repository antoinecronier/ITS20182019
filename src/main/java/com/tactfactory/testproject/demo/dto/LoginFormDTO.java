package com.tactfactory.testproject.demo.dto;

import com.tactfactory.testproject.demo.entities.User;

public class LoginFormDTO {

	private User user;
	private Long roleId;
	private String description;

	public User getUser() {
		return user;
	}

	public Long getRoleId() {
		return roleId;
	}

	public String getDescription() {
		return description;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
