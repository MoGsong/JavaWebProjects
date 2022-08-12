package com.gxnu.entity;

import java.io.Serializable;

/**
 * 权限类
 */
public class Authorization implements Serializable {
	private int id;
	private Role role;
	private Menu menu;
	private String yuliu;

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

	public String getYuliu() {
		return yuliu;
	}

	public void setYuliu(String yuliu) {
		this.yuliu = yuliu;
	}

	public Authorization(int id, Role role, Menu menu, String yuliu) {
		this.id = id;
		this.role = role;
		this.menu = menu;
		this.yuliu = yuliu;
	}

	public Authorization(Role role, Menu menu, String yuliu) {
		super();
		this.role = role;
		this.menu = menu;
		this.yuliu = yuliu;
	}
//toString方法

	public Authorization() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Authorization [id=" + id + ", role=" + role + ", menu=" + menu + ", yuliu=" + yuliu + "]";
	}

}
