package com.tactfactory.testproject.demo.controllers;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tactfactory.testproject.demo.database.contracts.UserContract;
import com.tactfactory.testproject.demo.entities.Role;
import com.tactfactory.testproject.demo.entities.User;

@Controller
public class HomeController {

	@RequestMapping(value = {"/","/index","/home"}, method = {RequestMethod.GET})
	public String index(Model model) {

		model.addAttribute("key1","coucou");
		model.addAttribute("key2",10);
		model.addAttribute("key3",false);
		model.addAttribute("key4",
				new User("jean","michel","jeanmi","jeanjean",new Role("eljeanmi")));

		model.addAttribute("key5",Date.from(Instant.now()));
		model.addAttribute("key6",UserContract.COLS_SELECT);

		List<Role> roles = new ArrayList<Role>();
		for (int i = 0; i < 20; i++) {
			roles.add(new Role("role"+i));
		}
		model.addAttribute("key7", roles);

		return "/home/index";
	}

	@RequestMapping(value = {"/index"}, method = {RequestMethod.POST})
	public String getIndexInfo(@ModelAttribute Role role) {

		System.out.println(role.getName());

		return "redirect:/index";
	}

	@RequestMapping(value = {"/index/{id}"}, method = {RequestMethod.GET})
	public String navigate(@PathVariable Integer id) {

		id++;

		return "redirect:/index/"+id;
	}
}












