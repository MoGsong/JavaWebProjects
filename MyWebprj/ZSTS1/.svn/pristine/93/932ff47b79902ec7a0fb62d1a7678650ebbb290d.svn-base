package com.gxnu.entity;

import java.io.Serializable;

/**
 * 角色类
 * 实体类通常要实现“序列化接口”，这样可以在Java对象和字节序列之间进行转换
 */
public class Role implements Serializable{
    //编号，角色
    private int id;
    private String name;
    private String yuliu;
    
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
	public String getYuliu() {
		return yuliu;
	}
	public void setYuliu(String yuliu) {
		this.yuliu = yuliu;
	}
	
	//构造方法
	public Role(int id, String name, String yuliu) {
		
		this.id = id;
		this.name = name;
		this.yuliu = yuliu;
	}
	public Role(String name, String yuliu) {
		
		this.name = name;
		this.yuliu = yuliu;
	}
	public Role() {
		
	}
	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", yuliu=" + yuliu + "]";
	}
    
    
}
