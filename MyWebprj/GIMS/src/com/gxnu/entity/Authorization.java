package com.gxnu.entity;

import java.io.Serializable;

/**
 * 
 * @author johny
 * 权限类
 */
public class Authorization implements Serializable{
	//属性,编号、角色、菜单
	private int id;
	private Role role;
	private Menu menu;
	//get/set
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Menu getMenu() {
		return menu;
	}
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	//构造方法
	public Authorization(int id, Role role, Menu menu) {
		super();
		this.id = id;
		this.role = role;
		this.menu = menu;
	}
	public Authorization(Role role, Menu menu) {
		super();
		this.role = role;
		this.menu = menu;
	}
	public Authorization() {
		super();
	}
	@Override
	public String toString() {
		return "Authorization [id=" + id + ", role=" + role + ", menu=" + menu + "]";
	}
	
}
