package com.example.demo.dao.impl;

import com.example.demo.dao.ExampleDao;
import com.example.demo.dao.JdbcTemplateSupportDao;
import com.example.demo.vo.TestVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>Title: </p>
 * <p>
 * <p>Description:com.example.demo.dao.impl</p>
 * <p>
 * <p>
 * @author lucifer
 * @version 1.0
 * @date 2018/7/19 16:34
 */
@Repository
public class ExampleDaoImpl implements ExampleDao{

	@Autowired
	@Qualifier("masterJdbcTemplate")
	private JdbcTemplate masterJdbcTemplate;
	@Autowired
	@Qualifier("slaveJdbcTemplate")
	private JdbcTemplate slaveJdbcTemplate;

	@Override
	public TestVo queryById(Integer id) {
		return masterJdbcTemplate.queryForObject("select id,name from test_tb where id=?",new Object[]{1},new BeanPropertyRowMapper<>(TestVo.class));
	}

	@Override
	public List<TestVo> queryListById(Integer id) {
		return new JdbcTemplateSupportDao(masterJdbcTemplate).queryForVoList("select id,name from test_tb where id=?",new Object[]{1},TestVo.class);
	}

	@Override
	public TestVo queryById_slave(Integer id) {
		return new JdbcTemplateSupportDao(slaveJdbcTemplate).queryForVo("select id,name from area where id=?", TestVo.class, new Object[]{1});
	}

	@Override
	public Integer queryCount(Integer id) {
		return new JdbcTemplateSupportDao(slaveJdbcTemplate).queryForObject("select count(1) from area where id=?", Integer.class, new Object[]{1});
	}
}
