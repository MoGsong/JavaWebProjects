package com.gxnu.entity;

import java.io.Serializable;
//ʵ����ͨ��Ҫʵ�֡����л��ӿڡ�������������java������ֽ�����֮���ת��
public class Doctor implements Serializable{
//���ԣ�id���������Ա����䡢�˺š����롢���ҡ�ְλ���Һš�ͷ�񡢵绰
	//  �ʼ���Ԥ��
	private  int id;  
	private   String name;
	private   String sex;
	private   int age;
	private   String username;
	private   String password;
	private   Unit   unit;
	private   Post   post;
	private    String pic;
	private   String tel;
	private   String email;
	private   String yuliu;
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
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
	public Unit getUnit() {
		return unit;
	}
	public void setUnit(Unit unit) {
		this.unit = unit;
	}
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getYuliu() {
		return yuliu;
	}
	public void setYuliu(String yuliu) {
		this.yuliu = yuliu;
	}
	
	public Doctor(int id, String name, String sex, int age, String username, String password, Unit unit, Post post,
			String pic, String tel, String email, String yuliu) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.username = username;
		this.password = password;
		this.unit = unit;
		this.post = post;
		this.pic = pic;
		this.tel = tel;
		this.email = email;
		this.yuliu = yuliu;
	}
	public Doctor(String name, String sex, int age, String username, String password, Unit unit, Post post, String pic,
			String tel, String email, String yuliu) {
		super();
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.username = username;
		this.password = password;
		this.unit = unit;
		this.post = post;
		this.pic = pic;
		this.tel = tel;
		this.email = email;
		this.yuliu = yuliu;
	}
	public Doctor() {
		super();
	}
	
	@Override
	public String toString() {
		return "Doctor [id=" + id + ", name=" + name + ", sex=" + sex + ", age=" + age + ", username=" + username
				+ ", password=" + password + ", unit=" + unit + ", post=" + post + ", pic=" + pic + ", tel=" + tel
				+ ", email=" + email + ", yuliu=" + yuliu + "]";
	}
	
	
	

	
}
