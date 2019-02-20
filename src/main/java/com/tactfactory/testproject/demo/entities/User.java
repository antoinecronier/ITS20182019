package com.tactfactory.testproject.demo.entities;

import com.tactfactory.testproject.demo.entities.base.BaseEntity;

public class User extends BaseEntity {

	private String firstname;
	private String lastname;
	private String login;
	private String password;
	private Role role;

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public User() {
		super();
	}

	public User(String firstname, String lastname, String login, String password, Role role) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.login = login;
		this.password = password;
		this.role = role;
	}
}
