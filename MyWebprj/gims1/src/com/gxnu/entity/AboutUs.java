package com.gxnu.entity;

import java.io.Serializable;


public class AboutUs implements Serializable {
	private int id;
	private String name;//公司名称
	private String address;//单位地址
	private String tel;//联系方式
	private String synopsis;//简介
	
	public AboutUs() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public AboutUs(String name, String address, String tel, String synopsis) {
		super();
		this.name = name;
		this.address = address;
		this.tel = tel;
		this.synopsis = synopsis;
	}

	public AboutUs(int id, String name, String address, String tel, String synopsis) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.tel = tel;
		this.synopsis = synopsis;
	}

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	@Override
	public String toString() {
		return "AboutUs [id=" + id + ", name=" + name + ", address=" + address + ", tel=" + tel + ", synopsis="
				+ synopsis + "]";
	}
	
	

}
