package com.tactfactory.testproject.demo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tactfactory.testproject.demo.dao.UserDAOImp;
import com.tactfactory.testproject.demo.database.DBOpenHelper;
import com.tactfactory.testproject.demo.database.contracts.RoleContract;
import com.tactfactory.testproject.demo.database.contracts.UserContract;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		UserDAOImp userDAO = new UserDAOImp();
		userDAO.createTable();

		dbDDLRequest(UserContract.DROP_TABLE);
		dbDDLRequest(RoleContract.DROP_TABLE);

		dbDDLRequest(RoleContract.SCHEME_CREATE);
		dbDDLRequest(UserContract.SCHEME_CREATE);

		for (String constrainte : UserContract.CONSTRAINTS) {
			dbDDLRequest(constrainte);
		}

		SpringApplication.run(DemoApplication.class, args);
	}


}
