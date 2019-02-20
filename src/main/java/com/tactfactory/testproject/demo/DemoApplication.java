package com.tactfactory.testproject.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tactfactory.testproject.demo.dao.RoleDAOImp;
import com.tactfactory.testproject.demo.dao.UserDAOImp;
import com.tactfactory.testproject.demo.entities.Role;
import com.tactfactory.testproject.demo.entities.User;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		RoleDAOImp roleDAO = new RoleDAOImp();
		roleDAO.deleteTable();
		roleDAO.createTable();

		UserDAOImp userDAO = new UserDAOImp();
		userDAO.deleteTable();
		userDAO.createTable();

		User user = userDAO.save(new User("firstname", "lastname", "login", "password", new Role("mon role 1")));

		System.out.println(user.getId());

		Role role = roleDAO.getById(1L);

		User newUser = userDAO.getById(1L);

		for (int i = 0; i < 2000; i++) {
			userDAO.save(new User("firstname"+i, "lastname"+i, "login", "password", null));
		}

		SpringApplication.run(DemoApplication.class, args);
	}


}
