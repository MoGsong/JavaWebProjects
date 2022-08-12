package com.gxnu.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import com.gxnu.entity.Doctor;


public class InStore implements Serializable{

	private int id;
	private Operator operator ;
	private Timestamp time;
	private String yuliu;
	
	/**
	 * 无参构造方法
	 */
	public InStore() {
		super();
	}



	/**
	 * 无id，构造方法
	 * @param unit
	 * @param doctor
	 * @param period
	 * @param week
	 * @param day
	 * @param yuliu
	 */
	public InStore(Operator operator, Timestamp time, String yuliu) {
		super();
		this.operator = operator;
		this.time = time;
		this.yuliu = yuliu;
	}





	/**
	 * 有id，构造方法
	 * @param id
	 * @param unit
	 * @param doctor
	 * @param period
	 * @param week
	 * @param day
	 * @param yuliu
	 */

	public InStore(int id, Operator operator, Timestamp time, String yuliu) {
		super();
		this.id = id;
		this.operator = operator;
		this.time = time;
		this.yuliu = yuliu;
	}

	/**
	 * 无id 无预留
	 * @param operator
	 * @param time
	 */


	public InStore(Operator operator, Timestamp time) {
		super();
		this.operator = operator;
		this.time = time;
	}

/**
 * 无预留
 * @param id
 * @param operator
 * @param time
 */

	public InStore(int id, Operator operator, Timestamp time) {
		super();
		this.id = id;
		this.operator = operator;
		this.time = time;
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



	public Timestamp getTime() {
		return time;
	}



	public void setTime(Timestamp time) {
		this.time = time;
	}



	public String getYuliu() {
		return yuliu;
	}



	public void setYuliu(String yuliu) {
		this.yuliu = yuliu;
	}



	@Override
	public String toString() {
		return "InStore [id=" + id + ", operator=" + operator + ", time=" + time + ", yuliu=" + yuliu + "]";
	}

	



	
}
