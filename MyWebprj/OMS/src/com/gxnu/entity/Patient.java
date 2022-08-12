package com.gxnu.entity;

import java.io.Serializable;

//ʵ����ͨ��Ҫʵ�֡����л��ӿڡ�������������java������ֽ�����֮���ת��
public class Patient implements Serializable{
//����;id���������Ա����䡢�˺š����롢���֤��ͷ�񡢵绰�����䡢Ԥ��
	private int id;
	private String name;
	private String sex;
	private int age;
	private String username;
	private String password;
	private String idcard;
	private String pic;
	private String tel;
	private String email;
	private String yuliu;
	
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
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
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
	
	public Patient(int id, String name, String sex, int age, String username, String password, String idcard,
			String pic, String tel, String email, String yuliu) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.username = username;
		this.password = password;
		this.idcard = idcard;
		this.pic = pic;
		this.tel = tel;
		this.email = email;
		this.yuliu = yuliu;
	}
	public Patient(String name, String sex, int age, String username, String password, String idcard, String pic,
			String tel, String email, String yuliu) {
		super();
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.username = username;
		this.password = password;
		this.idcard = idcard;
		this.pic = pic;
		this.tel = tel;
		this.email = email;
		this.yuliu = yuliu;
	}
	
	public Patient(String name, String sex, int age, String username, String password, String idcard, String tel,
			String email) {
		super();
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.username = username;
		this.password = password;
		this.idcard = idcard;
		this.tel = tel;
		this.email = email;
	}
	
	public Patient(String name, String sex, int age, String username, String password, String idcard, String pic,
			String tel, String email) {
		super();
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.username = username;
		this.password = password;
		this.idcard = idcard;
		this.pic = pic;
		this.tel = tel;
		this.email = email;
	}
	public Patient() {
		super();
	}
	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", sex=" + sex + ", age=" + age + ", username=" + username
				+ ", password=" + password + ", idcard=" + idcard + ", pic=" + pic + ", tel=" + tel + ", email=" + email
				+ ", yuliu=" + yuliu + "]";
	}
	
	
}
