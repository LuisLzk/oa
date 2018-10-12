package com.bwf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 权限不够，错误控制器
 * @author admin
 *
 */
@Controller
@RequestMapping("error")
public class errorController {

	@GetMapping("error")
	public String error(){
		return "error/error";
	}
}
