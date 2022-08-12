package com.gxnu.entity;


import java.io.Serializable;
import java.sql.Timestamp;




public class Rss implements Serializable{
    
	//属性：编号；标题；链接；内容；更新时间
	
	
	private int id;
	private String title;
	private String url;
	private String content;
	private String updatetime;
	
	
	
	
	
	
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

	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}
	//构造方法
	public Rss(int id, String title, String url, String content, String updatetime) {
		super();
		this.id = id;
		this.title = title;
		this.url = url;
		this.content = content;
		this.updatetime = updatetime;
	}
	public Rss(String title,String url,String content,String updatetime) {
		super();
		this.title = title;
		this.url = url;
		this.content = content;
		this.updatetime = updatetime;
	}
	public Rss() {
		super();
	}
	@Override
	public String toString() {
		return "Rss [id=" + id + ", title=" + title + ", url=" + url + ", content="
				+ content + ", updatetime=" + updatetime + "]";
	}
	
	
	
	

	
}
