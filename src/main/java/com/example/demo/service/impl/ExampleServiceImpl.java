package com.example.demo.service.impl;

import com.example.demo.dao.ExampleDao;
import com.example.demo.service.ExampleService;
import com.example.demo.vo.TestVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>Title: </p>
 * <p>
 * <p>Description:com.example.demo.service.impl</p>
 * <p>
 * <p>
 * @author lucifer
 * @version 1.0
 * @date 2018/7/19 15:00
 */
@Service
public class ExampleServiceImpl implements ExampleService{

	@Autowired
	private ExampleDao exampleDao;

	@Override
	public TestVo queryById(Integer id) {
		return exampleDao.queryById(id);
	}

	@Override
	public List<TestVo> queryListById(Integer id) {
		return exampleDao.queryListById(id);
	}

	@Override
	public TestVo queryById_slave(Integer id) {
		return exampleDao.queryById_slave(id);
	}

	@Override
	public Integer queryCount(Integer id) {
		return exampleDao.queryCount(id);
	}
}
