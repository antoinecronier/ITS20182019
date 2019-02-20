package com.tactfactory.testproject.demo.dao;

import com.tactfactory.testproject.demo.database.DBManager;
import com.tactfactory.testproject.demo.database.contracts.UserContract;
import com.tactfactory.testproject.demo.entities.User;

public class UserDAOImp extends BaseEntityDAOImp<User> {

	private DBManager manager = new DBManager();

	@Override
	public User save(User item) {
		User user = new User();

		if (item.getId() == null) {
			StringBuilder builder = new StringBuilder();

			builder.append("INSERT INTO " + UserContract.TABLE_NAME + " (");
			for (String columnName : UserContract.COLS_INSERT_ALL) {
				builder.append(columnName);
				builder.append(",");
			}
			builder.setLength(builder.length() - 1);
			builder.append(")");
			builder.append(" VALUES (");

			builder.append(item.getFirstname());
			builder.append(",");
			builder.append(item.getLastname());
			builder.append(",");
			builder.append(item.getLogin());
			builder.append(",");
			builder.append(item.getPassword());
			builder.append(",");

			if (item.getRole() != null) {
				if (item.getRole().getId() == null) {
					//TODO: use RoleDAOImp
				}else {
					builder.append(item.getRole().getId());
				}
			}else {
				builder.append("null");
			}

			item.setId(manager.insertAutoIncrementRequest(builder.toString()));
		}else {
			StringBuilder builder = new StringBuilder();
//			UPDATE nom_table
//			SET col_name1 = expression1,
//			col_name2 = expression2
//					WHERE condition
			builder.append("UPDATE " + UserContract.TABLE_NAME + " SET ");
			builder.append(UserContract.COL_FIRSTNAME + " = " + item.getFirstname());
			builder.append(",");
			builder.append(UserContract.COL_LASTNAME + " = " + item.getLastname());
			builder.append(",");
			builder.append(UserContract.COL_LOGIN + " = " + item.getLogin());
			builder.append(",");
			builder.append(UserContract.COL_PASSWORD + " = " + item.getPassword());
			builder.append(",");
			builder.append(UserContract.FK_COL_ROLE_ID + " = ");

			if (item.getRole() != null) {
				if (item.getRole().getId() == null) {
					//TODO: use RoleDAOImp
				}else {
					builder.append(item.getRole().getId());
				}
			}else {
				builder.append("null");
			}

			builder.append(" WHERE " + UserContract.COL_ID + " = " + item.getId());

			manager.dbDDLRequest(builder.toString());
		}

		user = item;

		return user;
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
