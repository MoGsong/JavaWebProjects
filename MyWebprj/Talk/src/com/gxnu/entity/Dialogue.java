package com.gxnu.entity;

import java.io.Serializable;

public class Dialogue implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	private int host;
	private int guest;
	private String ip;
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
	public int getHost() {
		return host;
	}
	public void setHost(int host) {
		this.host = host;
	}
	public int getGuest() {
		return guest;
	}
	public void setGuest(int guest) {
		this.guest = guest;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	@Override
	public String toString() {
		return "Dialogue [id=" + id + ", name=" + name + ", host=" + host + ", guest=" + guest + ", ip=" + ip + "]";
	}
	public Dialogue(int id, String name, int host, int guest, String ip) {
		super();
		this.id = id;
		this.name = name;
		this.host = host;
		this.guest = guest;
		this.ip = ip;
	}
	public Dialogue(String name, int host, int guest, String ip) {
		super();
		this.name = name;
		this.host = host;
		this.guest = guest;
		this.ip = ip;
	}
	public Dialogue() {
		super();
	}
	
}
