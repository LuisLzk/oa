package com.bwf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("roster")
public class rosterController {

	@GetMapping("show")
	public String show(){
		return "roster/show";
	}
}
