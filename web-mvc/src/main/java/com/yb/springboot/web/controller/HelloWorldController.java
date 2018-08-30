package com.yb.springboot.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: yangb
 * @Description:
 */
@Controller
public class HelloWorldController {

	@RequestMapping("")
	public String index() {
		return "index";
	}
}
