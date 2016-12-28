package com.dcloud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dcloud.model.User;

@Controller
public class HomeController {

	private Logger logger = LoggerFactory.getLogger("HomeController");

	@RequestMapping(value = "/say/{name}")
	public String index(@PathVariable String name, Model model) {
		logger.info("index here...");
		model.addAttribute("name", name);
		return "hello";
	}

	@RequestMapping(value = "/hello")
	@ResponseBody
	public String hello() {
		logger.info("hello");
		return "hello from here ... ";
	}

	@RequestMapping(value = "/user/{id}")
	public User getUser(@PathVariable int id) {
		logger.info("get user for {}", id);

		//
		User user = new User();

		user.setUserId(String.valueOf(id));
		user.setUserName("userName");
		user.setEmail("email");

		return user;
	}

	@RequestMapping(value = "/user1/{id}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public User getUserExt(@PathVariable int id) {
		logger.info("get user for {}", id);

		//
		User user = new User();

		user.setUserId(String.valueOf(id));
		user.setUserName("userName3");
		user.setEmail("email3");

		return user;
	}

}
