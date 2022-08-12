package com.gxnu.entity;

import java.io.Serializable;

/**
 * 引导图片类
 * 实体类通常要实现“序列化接口”，这样可以在Java对象和字节序列之间进行转换
 */
public class Guide implements Serializable{
	//编号，图片名称，图片链接
	 private int id;
	 private String name;
	 private String URL;
	
	 //get/set方法
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}

	//构造函数
	public Guide(int id, String name, String uRL) {
		super();
		this.id = id;
		this.name = name;
		URL = uRL;
	}

	public Guide(String name, String uRL) {
		super();
		this.name = name;
		URL = uRL;
	}

	public Guide() {
		super();
	}

	public String toString() {
		return "Guide [id=" + id + ", name=" + name + ", URL=" + URL + "]";
	}
	 
	
	
	 
}
