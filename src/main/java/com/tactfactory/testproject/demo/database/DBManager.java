package com.tactfactory.testproject.demo.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBManager {

	public Integer dbDDLRequest(String request) {
		Integer result = null;
		Statement st = null;
		try {
			st = DBOpenHelper.getInstance().getConn().createStatement();
			result = st.executeUpdate(request);
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

	public void dbSelectRequest(String request) {
		Statement st = null;
		try {
			st = DBOpenHelper.getInstance().getConn().createStatement();
			ResultSet rs = st.executeQuery(request);
			while (rs.next()) {
				StringBuilder builder = new StringBuilder();
				builder.append(rs.getInt(rs.findColumn("id")));
				builder.append("|");
				builder.append(rs.getString(rs.findColumn("nom")));
				builder.append("|");
				builder.append(rs.getDate(rs.findColumn("age")));
				builder.append("|");
				builder.append(rs.getInt(rs.findColumn("article")));

				System.out.println(builder.toString());
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
	}

	public Long insertAutoIncrementRequest(String request) {
		Long result = null;
		Statement stmt = null;
		try {
			stmt = DBOpenHelper.getInstance().getConn().createStatement();
			stmt.executeUpdate(request, Statement.RETURN_GENERATED_KEYS);
			ResultSet rs = stmt.getGeneratedKeys();
			try {
				rs.next();
				result = rs.getLong(1);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
