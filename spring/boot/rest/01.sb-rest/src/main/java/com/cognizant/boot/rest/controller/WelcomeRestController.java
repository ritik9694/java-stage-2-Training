package com.cognizant.boot.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/*
@Controller
@ResponseBody
*/
@RestController
public class WelcomeRestController {

	@RequestMapping("/welcome")
	public String showWelcomeMessage() {
		return "welcome to cognizant";
	}
}
