package com.tactfactory.testproject.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tactfactory.testproject.demo.database.DBManager;
import com.tactfactory.testproject.demo.database.DBOpenHelper;
import com.tactfactory.testproject.demo.database.contracts.RoleContract;
import com.tactfactory.testproject.demo.entities.Role;

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
			builder.append("UPDATE " + RoleContract.TABLE_NAME + " SET ");
			builder.append(RoleContract.COL_NAME + " = " +  "'" + item.getName() + "'");
			builder.append(" WHERE " + RoleContract.COL_ID + " = " + item.getId());

			manager.dbDDLRequest(builder.toString());
		}

		role = item;

		return role;
	}

	@Override
	public Role getById(Long id) {
		Role role = new Role();

		StringBuilder builder = new StringBuilder();
		builder.append("SELECT ");
		for (String columnName : RoleContract.COLS_SELECT) {
			builder.append(columnName);
			builder.append(",");
		}
		builder.setLength(builder.length() - 1);

		builder.append(" FROM ");
		builder.append(RoleContract.TABLE_NAME);
		builder.append(" WHERE ");
		builder.append(RoleContract.COL_ID);
		builder.append(" = ");
		builder.append(id);

		Statement st = null;
		try {
			st = DBOpenHelper.getInstance().getConn().createStatement();
			ResultSet rs = st.executeQuery(builder.toString());
			while (rs.next()) {
				role.setId(rs.getLong(rs.findColumn(RoleContract.ALIASED_COL_ID)));
				role.setName(rs.getString(rs.findColumn(RoleContract.ALIASED_COL_NAME)));
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

		return role;
	}

	@Override
	public Boolean delete(Role item) {
		Boolean result = false;

		StringBuilder builder = new StringBuilder();
		builder.append("DELETE ");
		builder.append(" FROM ");
		builder.append(RoleContract.TABLE_NAME);
		builder.append(" WHERE ");
		builder.append(RoleContract.COL_ID);
		builder.append(" = ");
		builder.append(item.getId());

		Integer changedLine = manager.dbDDLRequest(builder.toString());

		if (changedLine != null) {
			if (changedLine == 1) {
				result = true;
			}
		}

		return result;
	}

	@Override
	public void createTable() {
		manager.dbDDLRequest(RoleContract.SCHEME_CREATE);
	}

	@Override
	public void deleteTable() {
		manager.dbDDLRequest(RoleContract.DROP_TABLE);
	}

	@Override
	public List<Role> save(List<Role> items) {
		List<Role> result = new ArrayList<Role>();

		for (Role role : items) {
			result.add(save(role));
		}

		return result;
	}

	@Override
	public List<Role> get() {
		List<Role> result = new ArrayList<Role>();

		StringBuilder builder = new StringBuilder();
		builder.append("SELECT ");
		for (String columnName : RoleContract.COLS_SELECT) {
			builder.append(columnName);
			builder.append(",");
		}
		builder.setLength(builder.length() - 1);

		builder.append(" FROM ");
		builder.append(RoleContract.TABLE_NAME);

		Statement st = null;
		try {
			st = DBOpenHelper.getInstance().getConn().createStatement();
			ResultSet rs = st.executeQuery(builder.toString());
			while (rs.next()) {
				Role role = new Role();
				role.setId(rs.getLong(rs.findColumn(RoleContract.ALIASED_COL_ID)));
				role.setName(rs.getString(rs.findColumn(RoleContract.ALIASED_COL_NAME)));
				result.add(role);
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

	@Override
	public Boolean delete(List<Role> items) {
		Boolean result = true;

		for (Role role : items) {
			if (!delete(role)) {
				result = false;
			}
		}

		return result;
	}
}
