package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Title: </p>
 * <p>
 * <p>Description:com.example.demo.controller</p>
 * <p>
 * <p>
 * @author zwq
 * @version 1.0
 * @date 2018/7/17 15:46
 */
@RestController
@RequestMapping("/hello")
public class HelloWorldController {

	@RequestMapping("/index")
	public String index() {
		return "Hello World";
	}


}
