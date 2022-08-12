package com.gxnu.entity;

import java.io.Serializable;

/**
 * @author johny
 *操作员类
 */
public class Operator implements Serializable{
	//属性，编号、用户名、密码、联系方式、头相、角色、预留
	//外键对应的属性通常使用实体类类型（复合、引用数据类型），不使用基本类型和String
	private int id;
	private String username;
	private String password;
	private String tel;
	private String pic;
	private String yuliu;
	private Role role;   //{1 ， 超级管理员}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getYuliu() {
		return yuliu;
	}
	public void setYuliu(String yuliu) {
		this.yuliu = yuliu;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Operator(int id, String username, String password, String tel, String pic, String yuliu, Role role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.tel = tel;
		this.pic = pic;
		this.yuliu = yuliu;
		this.role = role;
	}
	public Operator(String username, String password, String tel, String pic, String yuliu, Role role) {
		super();
		this.username = username;
		this.password = password;
		this.tel = tel;
		this.pic = pic;
		this.yuliu = yuliu;
		this.role = role;
	}
	public Operator() {
		super();
	}
	@Override
	public String toString() {
		return "Operator [id=" + id + ", username=" + username + ", password=" + password + ", tel=" + tel + ", pic="
				+ pic + ", yuliu=" + yuliu + ", role=" + role + "]";
	}

	
}
