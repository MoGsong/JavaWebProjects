package com.gxnu.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class lnformation implements Serializable{
	private int id;
	private String types;
	private String content;
	private String picture;
	private Timestamp time;
	private String yuliu;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTypes() {
		return types;
	}
	public void setTypes(String types) {
		this.types = types;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public String getYuliu() {
		return yuliu;
	}
	public void setYuliu(String yuliu) {
		this.yuliu = yuliu;
	}
	public lnformation(int id, String types, String content, String picture,Timestamp time, String yuliu) {
		super();
		this.id = id;
		this.types = types;
		this.content = content;
		this.picture = picture;
		this.time = time;
		this.yuliu = yuliu;
	}
	public lnformation(String types, String content, String picture, Timestamp time, String yuliu) {
		super();
		this.types = types;
		this.content = content;
		this.picture = picture;
		this.time = time;
		this.yuliu = yuliu;
	}
	public lnformation() {
		super();
	}
	@Override
	public String toString() {
		return "lnformation [id=" + id + ", types=" + types + ", content=" + content + ", picture=" + picture
				+ ", time=" + time + ", yuliu=" + yuliu + "]";
	}
	
	
	
	
}
