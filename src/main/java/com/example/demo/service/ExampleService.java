package com.example.demo.service;

import com.example.demo.vo.TestVo;

import java.util.List;

/**
 * <p>Title: </p>
 * <p>
 * <p>Description:com.example.demo.service</p>
 * <p>
 * <p>
 * @author lucifer
 * @version 1.0
 * @date 2018/7/19 14:59
 */
public interface ExampleService {

	TestVo queryById(Integer id);

	List<TestVo> queryListById(Integer id);

	TestVo queryById_slave(Integer id);

	Integer queryCount(Integer id);
}
