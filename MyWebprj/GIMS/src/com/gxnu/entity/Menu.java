package com.gxnu.entity;

import java.io.Serializable;

public class Menu implements Serializable {

    private int id;
    private String name;
    private int parent;
    private String url;
    private String img;
	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Menu(int id, String name, int parent, String url, String img) {
		super();
		this.id = id;
		this.name = name;
		this.parent = parent;
		this.url = url;
		this.img = img;
	}
	public Menu( String name, int parent, String url, String img) {
		super();
		this.name = name;
		this.parent = parent;
		this.url = url;
		this.img = img;
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
	public int getParent() {
		return parent;
	}
	public void setParent(int parent) {
		this.parent = parent;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
    
}
