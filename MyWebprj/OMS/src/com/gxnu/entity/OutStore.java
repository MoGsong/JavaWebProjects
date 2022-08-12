package com.gxnu.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class OutStore implements Serializable {
	private int id;
	private Operator operator;
	private Recipe recipe;
	private int tprice;
	private Timestamp time;
	private int status;
	private String yuliu;
	public OutStore(int id, Operator operator, Recipe recipe, int tprice, Timestamp time, int status, String yuliu) {
		super();
		this.id = id;
		this.operator = operator;
		this.recipe = recipe;
		this.tprice = tprice;
		this.time = time;
		this.status = status;
		this.yuliu = yuliu;
	}
	public OutStore(Operator operator, Recipe recipe, int tprice, Timestamp time, int status, String yuliu) {
		super();
		this.operator = operator;
		this.recipe = recipe;
		this.tprice = tprice;
		this.time = time;
		this.status = status;
		this.yuliu = yuliu;
	}
	public OutStore() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Operator getOperator() {
		return operator;
	}
	public void setOperator(Operator operator) {
		this.operator = operator;
	}
	public Recipe getRecipe() {
		return recipe;
	}
	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}
	public int getTprice() {
		return tprice;
	}
	public void setTprice(int tprice) {
		this.tprice = tprice;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getYuliu() {
		return yuliu;
	}
	public void setYuliu(String yuliu) {
		this.yuliu = yuliu;
	}
	@Override
	public String toString() {
		return "OutStore [id=" + id + ", operator=" + operator + ", recipe=" + recipe + ", tprice=" + tprice + ", time="
				+ time + ", status=" + status + ", yuliu=" + yuliu + "]";
	}

	
	

}
