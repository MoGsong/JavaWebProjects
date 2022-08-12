package com.gxnu.entity;

import java.io.Serializable;

/**
 * 
 * @author 胖子不露小酒窝
 *菜单类
 */
public class Menu implements Serializable{
	//属性：编号、名称、父菜单、URL
	private int id;
	private String name;
	private int parent;
	private String URL;
	private String yuliu;
	
	/**
	 * set|get方法
	 * @return
	 */
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
	
	public int getParent() {
		return parent;
	}
	public void setParent(int parent) {
		this.parent = parent;
	}
	
	public String getURL() {
		return URL;
	}
	public void setURL(String URL) {
		this.URL = URL;
	}
	
	public String getYuliu() {
		return yuliu;
	}
	public void setYuliu(String yuliu) {
		this.yuliu = yuliu;
	}
	
	/**
	 * 构造方法
	 * @param id
	 * @param name
	 * @param parent
	 * @param URL
	 */
	public Menu(int id, String name, int parent, String URL,String yuliu) {
		super();
		this.id=id;
		this.name = name;
		this.parent = parent;
		this.URL = URL;
		this.yuliu = yuliu;
	}
	
	public Menu(String name, int parent, String URL,String yuliu) {
		super();
		this.name = name;
		this.parent = parent;
		this.URL = URL;
		this.yuliu = yuliu;
	}
	
	//构造空方法
	public Menu() {
		super();
	}
	
	/**
	 * toString方法
	 */
	@Override
	public String toString() {
		return "Menu [id=" + id + ", name=" + name + ", parent=" + parent + ", URL=" + URL + ", yuliu=" + yuliu + "]";
	}
	
}