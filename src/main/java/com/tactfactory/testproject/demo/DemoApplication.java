package com.tactfactory.testproject.demo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tactfactory.testproject.demo.database.DBOpenHelper;
import com.tactfactory.testproject.demo.database.contracts.RoleContract;
import com.tactfactory.testproject.demo.database.contracts.UserContract;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		dbDDLRequest(UserContract.DROP_TABLE);
		dbDDLRequest(RoleContract.DROP_TABLE);

		dbDDLRequest(RoleContract.SCHEME_CREATE);
		dbDDLRequest(UserContract.SCHEME_CREATE);

		for (String constrainte : UserContract.CONSTRAINTS) {
			dbDDLRequest(constrainte);
		}

		SpringApplication.run(DemoApplication.class, args);
	}

	private static void dbDDLRequest(String request) {
		Statement st = null;
		try {
			st = DBOpenHelper.getInstance().getConn().createStatement();
			st.executeUpdate(request);
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

	private static void dbSelectRequest(String request) {
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
}
