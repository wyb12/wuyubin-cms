package com.wuyubin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 
 * @author zhuzg
 *
 */

@Controller
@RequestMapping("admin")
public class AdminController {
	
	@RequestMapping("index")
	public String index() {
		return "amdin/index";
	}
	
	@RequestMapping("articles")
	public String articles() {
		return "amdin/article/list";
	}
	
	@RequestMapping("users")
	public String users(@RequestParam(defaultValue="") String name) {
		return "amdin/user/list";
	}

}
