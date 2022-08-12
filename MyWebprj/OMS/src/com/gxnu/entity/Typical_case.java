package com.gxnu.entity;


import java.io.Serializable;
import java.sql.Timestamp;




public class Typical_case implements Serializable{
    
	//属性：标题，内容，图片，作者，时间，预留
	
	
	private int id;
	private String title;
	private String pic;
	private String content;
	private Timestamp date;
	
	
	//get/set方法
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	
	
	//构造方法
	
	public Typical_case(int id, String title, String pic, String content, Timestamp date) {
		super();
		this.id = id;
		this.title = title;
		this.pic = pic;
		this.content = content;
		this.date = date;
	
	}
	
	public Typical_case(String title, String pic, String content, Timestamp date) {
		super();
		this.title = title;
		this.pic = pic;
		this.content = content;
		this.date = date;
	
	}
	
	public Typical_case() {
		super();
		
	}
	
	@Override
	public String toString() {
		return "Typical_case [id=" + id + ", title=" + title + ", pic=" + pic + ", content=" + content + ", date="
				+ date +  "]";
	}
	

}
