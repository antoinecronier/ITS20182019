package com.tactfactory.testproject.demo.dao;

import com.tactfactory.testproject.demo.database.DBManager;
import com.tactfactory.testproject.demo.database.contracts.UserContract;
import com.tactfactory.testproject.demo.entities.*;

public class UserDAOImp extends BaseEntityDAOImp<User> {

	private DBManager manager = new DBManager();

	@Override
	public User save(User item) {
		return null;
	}

	@Override
	public User getById(Long id) {
		return null;
	}

	@Override
	public Boolean delete(User item) {
		return null;
	}

	@Override
	public void createTable() {
		manager.dbDDLRequest(UserContract.SCHEME_CREATE);
	}

	@Override
	public void deleteTable() {
		manager.dbDDLRequest(UserContract.DROP_TABLE);
	}

}
