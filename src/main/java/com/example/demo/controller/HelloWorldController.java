package com.example.demo.controller;

import com.example.demo.service.ExampleService;
import com.example.demo.vo.TestVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Title: </p>
 * <p>
 * <p>Description:com.example.demo.controller</p>
 * <p>
 * @author lucifer
 * @version 1.0
 * @date 2018/7/17 15:46
 */
@RestController
@RequestMapping("/hello")
public class HelloWorldController {

	@Autowired
	private ExampleService exampleService;

	@RequestMapping("/index")
	public String index() {
		return "Hello World";
	}

	@RequestMapping("/getjson")
	public TestVo getJson(){
		TestVo vo = new TestVo();
		vo.setId(1);
		vo.setName("name");
		return vo;
	}

	@RequestMapping("/getdbjson")
	public Map getDbJson(){
		Map map = new HashMap();
		TestVo vo_master = exampleService.queryById(1);
		List<TestVo> list = exampleService.queryListById(102050);
		TestVo vo_slave = exampleService.queryById_slave(1);
		Integer count = exampleService.queryCount(1);
		map.put("vo_master",vo_master);
		map.put("vo_slave",vo_slave);
		map.put("vo_list",list);
		map.put("count",count);
		return map;
	}
}
