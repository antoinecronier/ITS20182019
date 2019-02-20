package com.tactfactory.testproject.demo.database;

import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class DBOpenHelper {
	/** Constructeur privé */
	private DBOpenHelper() {
		MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setUser("antoine.cronier");
		dataSource.setPassword("root");
		dataSource.setServerName("localhost");
		dataSource.setDatabaseName("its20182019");
		try {
			dataSource.setServerTimezone("UTC");
			this.conn = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/** Instance unique non préinitialisée */
	private static DBOpenHelper INSTANCE = null;

	/** Point d'accès pour l'instance unique du DBOpenHelper */
	public static DBOpenHelper getInstance() {
		if (INSTANCE == null) {
			synchronized (DBOpenHelper.class) {
				if (INSTANCE == null) {
					INSTANCE = new DBOpenHelper();
				}
			}
		}
		return INSTANCE;
	}

	private Connection conn;

	public Connection getConn() {
		return conn;
	}


}