package com.example.demo.vo;

import java.io.Serializable;

/**
 * <p>Title: </p>
 * <p>
 * @author lucifer
 * @version 1.0
 * @date 2018/7/18 16:34
 */
public class TestVo implements Serializable {

	/**
	 * 序列值
	 */
	private static final long serialVersionUID = -213450775245826021L;

	private Integer id;
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
