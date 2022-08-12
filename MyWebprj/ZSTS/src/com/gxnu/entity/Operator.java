package com.gxnu.entity;

public class Operator {
	private int id;
	private String username;
	private String password;
	private String tel;
	private String pic;
	private Role role;
	private String yuliu;
	private String email;
	private int status;
	private int falsetime;
	
	

	
	
	public Operator() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Operator(int id, String username, String password, String tel, String pic, Role role, String yuliu,
			String email, int status, int falsetime) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.tel = tel;
		this.pic = pic;
		this.role = role;
		this.yuliu = yuliu;
		this.email = email;
		this.status = status;
		this.falsetime = falsetime;
	}

	public Operator( String username, String password, String tel, String pic, Role role, String yuliu,
			String email, int status, int falsetime) {
		super();
	
		this.username = username;
		this.password = password;
		this.tel = tel;
		this.pic = pic;
		this.role = role;
		this.yuliu = yuliu;
		this.email = email;
		this.status = status;
		this.falsetime = falsetime;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getYuliu() {
		return yuliu;
	}

	public void setYuliu(String yuliu) {
		this.yuliu = yuliu;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getFalsetime() {
		return falsetime;
	}

	public void setFalsetime(int falsetime) {
		this.falsetime = falsetime;
	}

	@Override
	public String toString() {
		return "Operator [id=" + id + ", username=" + username + ", password=" + password + ", tel=" + tel + ", pic="
				+ pic + ", role=" + role + ", yuliu=" + yuliu + ", email=" + email + ", status=" + status
				+ ", falsetime=" + falsetime + "]";
	}

	
}
