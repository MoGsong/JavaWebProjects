package com.gxnu.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 可预约情况表实体层
 * @author hjj
 *
 */

public class ReserveCase implements Serializable {
     private int id;  //id
     private Doctor doctor; //外键，引用医生表id
     private Timestamp time; //预约时间
     private int al_reserve; //已预约人数
	public ReserveCase(int id, Doctor doctor, Timestamp time, int al_reserve) {
		super();
		this.id = id;
		this.doctor = doctor;
		this.time = time;
		this.al_reserve = al_reserve;
	}
	
	public ReserveCase(Doctor doctor, Timestamp time, int al_reserve) {
		super();
		this.doctor = doctor;
		this.time = time;
		this.al_reserve = al_reserve;
	}

	public ReserveCase() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}


	public int getAl_reserve() {
		return al_reserve;
	}

	public void setAl_reserve(int al_reserve) {
		this.al_reserve = al_reserve;
	}

	@Override
	public String toString() {
		return "ReserveCase [id=" + id + ", doctor=" + doctor + ", time=" + time 
				+ ", al_reserve=" + al_reserve + "]";
	}
     
     
     
}
