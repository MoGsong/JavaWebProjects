package com.gxnu.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class Log implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	private int source;
	private int target;
	private Timestamp time;
	private String content;
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
	public int getSource() {
		return source;
	}
	public void setSource(int source) {
		this.source = source;
	}
	public int getTarget() {
		return target;
	}
	public void setTarget(int target) {
		this.target = target;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public Log(int id, String name, int source, int target, Timestamp time, String content) {
		super();
		this.id = id;
		this.name = name;
		this.source = source;
		this.target = target;
		this.time = time;
		this.content = content;
	}
	public Log(String name, int source, int target, Timestamp time, String content) {
		super();
		this.name = name;
		this.source = source;
		this.target = target;
		this.time = time;
		this.content = content;
	}
	public Log() {
		super();
	}
	
	@Override
	public String toString() {
		return "Log [id=" + id + ", name=" + name + ", source=" + source + ", target=" + target + ", time=" + time
				+ ", content=" + content + "]";
	}
	
}
