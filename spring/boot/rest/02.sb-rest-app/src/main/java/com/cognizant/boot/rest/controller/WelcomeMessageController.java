package com.cognizant.boot.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class WelcomeMessageController {

	@GetMapping("/welcome")
	public String ShowWelcomeMessage1() {
		return "welcome to cognizant -- GET";
	}
	@PostMapping("/welcome")
	public String ShowWelcomeMessage2() {
		return "welcome to cognizant -- post";
	}
	@PutMapping("/welcome")
	public String ShowWelcomeMessage3() {
		return "welcome to cognizant -- put";
	}
	@PatchMapping("welcome")
	public String ShowWelcomeMessage() {
		return "welcome to cognizant -- patch";
	}
}
