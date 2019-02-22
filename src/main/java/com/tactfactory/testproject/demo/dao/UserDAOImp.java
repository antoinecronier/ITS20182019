package com.tactfactory.testproject.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tactfactory.testproject.demo.database.DBOpenHelper;
import com.tactfactory.testproject.demo.database.contracts.UserContract;
import com.tactfactory.testproject.demo.database.dto.UserDTO;
import com.tactfactory.testproject.demo.entities.User;

public class UserDAOImp extends BaseEntityDAOImp<User> {

	public UserDAOImp() {
		super(new UserContract());
	}

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

			builder.append("'" + item.getFirstname() + "'");
			builder.append(",");
			builder.append("'" + item.getLastname() + "'");
			builder.append(",");
			builder.append("'" + item.getLogin() + "'");
			builder.append(",");
			builder.append("'" + item.getPassword() + "'");
			builder.append(",");

			if (item.getRole() != null) {
				if (item.getRole().getId() == null) {
					RoleDAOImp roleDAO = new RoleDAOImp();
					item.setRole(roleDAO.save(item.getRole()));
				}
				builder.append(item.getRole().getId());
			}else {
				builder.append("null");
			}

			builder.append(");");

			item.setId(manager.insertAutoIncrementRequest(builder.toString()));
		}else {
			StringBuilder builder = new StringBuilder();
			builder.append("UPDATE " + UserContract.TABLE_NAME + " SET ");
			builder.append(UserContract.COL_FIRSTNAME + " = " + "'" + item.getFirstname() + "'");
			builder.append(",");
			builder.append(UserContract.COL_LASTNAME + " = " + "'" + item.getLastname() + "'");
			builder.append(",");
			builder.append(UserContract.COL_LOGIN + " = " + "'" + item.getLogin() + "'");
			builder.append(",");
			builder.append(UserContract.COL_PASSWORD + " = "  + "'" + item.getPassword() + "'");
			builder.append(",");
			builder.append(UserContract.FK_COL_ROLE_ID + " = ");

			if (item.getRole() != null) {
				if (item.getRole().getId() == null) {
					RoleDAOImp roleDAO = new RoleDAOImp();
					item.setRole(roleDAO.save(item.getRole()));
				}
				builder.append(item.getRole().getId());
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
		User user = new User();

		StringBuilder builder = new StringBuilder();
		builder.append("SELECT ");
		for (String columnName : UserContract.COLS_SELECT) {
			builder.append(columnName);
			builder.append(",");
		}
		builder.setLength(builder.length() - 1);

		builder.append(" FROM ");
		builder.append(UserContract.TABLE_NAME);
		builder.append(" WHERE ");
		builder.append(UserContract.COL_ID);
		builder.append(" = ");
		builder.append(id);

		Statement st = null;
		try {
			st = DBOpenHelper.getInstance().getConn().createStatement();
			ResultSet rs = st.executeQuery(builder.toString());
			while (rs.next()) {
				UserDTO userDto = new UserDTO();
				while (rs.next()) {
					user = userDto.parseIn(rs);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return user;
	}

	@Override
	public List<User> save(List<User> items) {
		List<User> result = new ArrayList<User>();

		for (User user : items) {
			result.add(save(user));
		}

		return result;
	}

	@Override
	public List<User> get() {
		List<User> result = new ArrayList<User>();

		StringBuilder builder = new StringBuilder();
		builder.append("SELECT ");
		for (String columnName : UserContract.COLS_SELECT) {
			builder.append(columnName);
			builder.append(",");
		}
		builder.setLength(builder.length() - 1);

		builder.append(" FROM ");
		builder.append(UserContract.TABLE_NAME);

		Statement st = null;
		try {
			st = DBOpenHelper.getInstance().getConn().createStatement();
			ResultSet rs = st.executeQuery(builder.toString());
			UserDTO userDto = new UserDTO();
			while (rs.next()) {
				result.add(userDto.parseIn(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	public User getByLoginAndPassword(String login, String password) {
		User user = new User();

		StringBuilder builder = new StringBuilder();
		builder.append("SELECT ");
		for (String columnName : UserContract.COLS_SELECT) {
			builder.append(columnName);
			builder.append(",");
		}
		builder.setLength(builder.length() - 1);

		builder.append(" FROM ");
		builder.append(UserContract.TABLE_NAME);
		builder.append(" WHERE ");
		builder.append(UserContract.COL_LOGIN);
		builder.append(" = ");
		builder.append("'" + login + "'");
		builder.append(" AND ");
		builder.append(UserContract.COL_PASSWORD);
		builder.append(" = ");
		builder.append("'" + password + "'");

		Statement st = null;
		try {
			st = DBOpenHelper.getInstance().getConn().createStatement();
			ResultSet rs = st.executeQuery(builder.toString());
			while (rs.next()) {
				UserDTO userDto = new UserDTO();
				while (rs.next()) {
					user = userDto.parseIn(rs);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return user;
	}

}
