package com.gxnu.entity;

import java.io.Serializable;

/**
 * 关于医院模块
 * @author 胖子不露小酒窝
 *实体类
 */
public class About implements Serializable{
	//属性：编号、名称、地址、电话、图片、邮编、预留
	private int id;
	private String name;
	private String address;
	private String synopsis;
	private String tel;
	private String pic;
	private String postcode;
	private String yuliu;
	
	/**
	 * set/get方法
	 * @param id
	 */
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
	
	public String getSynopsis() {
		return synopsis;
	}
	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
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
	
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	
	public String getYuliu() {
		return yuliu;
	}
	public void setYuliu(String yuliu) {
		this.yuliu = yuliu;
	}
	
	/**
	 * 构造方法（id）
	 * @param id
	 * @param name
	 * @param address
	 * @param synopsis
	 * @param tel
	 * @param pic
	 * @param postcode
	 * @param yuliu
	 */
	public About(int id, String name, String address, String synopsis, String tel, String pic, String postcode,
			String yuliu) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.synopsis = synopsis;
		this.tel = tel;
		this.pic = pic;
		this.postcode = postcode;
		this.yuliu = yuliu;
	}
	
	/**
	 * 构造方法
	 * @param name
	 * @param address
	 * @param synopsis
	 * @param tel
	 * @param pic
	 * @param postcode
	 * @param yuliu
	 */
	public About(String name, String address, String synopsis, String tel, String pic, String postcode, String yuliu) {
		super();
		this.name = name;
		this.address = address;
		this.synopsis = synopsis;
		this.tel = tel;
		this.pic = pic;
		this.postcode = postcode;
		this.yuliu = yuliu;
	}
	
	/**
	 * 构造空方法
	 */
	public About() {
		super();
	}

	/**
	 * toString方法
	 */
	@Override
	public String toString() {
		return "About [id=" + id + ", name=" + name + ", address=" + address + ", synopsis=" + synopsis + ", tel=" + tel
				+ ", pic=" + pic + ", postcode=" + postcode + ", yuliu=" + yuliu + "]";
	}
	
	
}