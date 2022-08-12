package com.gxnu.entity;

public class Config {
	int id;
	int port;
	String ip;
	String version;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	
	public Config() {
		super();
	}
	public Config(int id, int port, String ip, String version) {
		super();
		this.id = id;
		this.port = port;
		this.ip = ip;
		this.version = version;
	}
	public Config(int port,String ip, String version ) {
		super();
		this.port = port;
		this.ip = ip;
		this.version = version;
		
	}
	@Override
	public String toString() {
		return "ServerConfig [id=" + id + ", port=" + port + ", ip=" + ip + ", version=" + version + "]";
	}
	
	
	
}
