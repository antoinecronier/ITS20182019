package com.tactfactory.testproject.demo.dao;

import com.tactfactory.testproject.demo.database.DBManager;
import com.tactfactory.testproject.demo.database.contracts.RoleContract;
import com.tactfactory.testproject.demo.database.contracts.UserContract;
import com.tactfactory.testproject.demo.entities.Role;
import com.tactfactory.testproject.demo.entities.User;

public class RoleDAOImp extends BaseEntityDAOImp<Role> {

	private DBManager manager = new DBManager();

	@Override
	public Role save(Role item) {
		Role role = new Role();

		if (item.getId() == null) {
			StringBuilder builder = new StringBuilder();

			builder.append("INSERT INTO " + RoleContract.TABLE_NAME + " (");
			for (String columnName : RoleContract.COLS_INSERT_ALL) {
				builder.append(columnName);
				builder.append(",");
			}
			builder.setLength(builder.length() - 1);
			builder.append(")");
			builder.append(" VALUES (");

			builder.append("'" + item.getName() + "'");

			builder.append(");");

			item.setId(manager.insertAutoIncrementRequest(builder.toString()));
		}else {
			StringBuilder builder = new StringBuilder();
			builder.append("UPDATE " + UserContract.TABLE_NAME + " SET ");
			builder.append(RoleContract.COL_NAME + " = " +  "'" + item.getName() + "'");
			builder.append(" WHERE " + UserContract.COL_ID + " = " + item.getId());

			manager.dbDDLRequest(builder.toString());
		}

		role = item;

		return role;
	}

	@Override
	public Role getById(Long id) {
		return null;
	}

	@Override
	public Boolean delete(Role item) {
		return null;
	}

	@Override
	public void createTable() {
		manager.dbDDLRequest(RoleContract.SCHEME_CREATE);
	}

	@Override
	public void deleteTable() {
		manager.dbDDLRequest(RoleContract.DROP_TABLE);
	}
}
