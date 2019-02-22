package com.tactfactory.testproject.demo.database.dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.tactfactory.testproject.demo.dao.RoleDAOImp;
import com.tactfactory.testproject.demo.database.contracts.UserContract;
import com.tactfactory.testproject.demo.entities.User;

public class UserDTO implements BaseDTO<User> {

	@Override
	public User parseIn(ResultSet rs) throws SQLException {
		User user = new User();

		user.setId(rs.getLong(rs.findColumn(UserContract.ALIASED_COL_ID)));
		user.setFirstname(rs.getString(rs.findColumn(UserContract.ALIASED_COL_FIRSTNAME)));
		user.setLastname(rs.getString(rs.findColumn(UserContract.ALIASED_COL_LASTNAME)));
		user.setLogin(rs.getString(rs.findColumn(UserContract.ALIASED_COL_LOGIN)));
		user.setPassword(rs.getString(rs.findColumn(UserContract.ALIASED_COL_PASSWORD)));

		Long fkRole = rs.getLong(rs.findColumn(UserContract.ALIASED_FK_COL_ROLE_ID));
		if (fkRole != null) {
			RoleDAOImp roleDAO = new RoleDAOImp();
			user.setRole(roleDAO.getById(fkRole));
		}

		return user;
	}

	@Override
	public String parseOut(User item) {
		return null;
	}

}
