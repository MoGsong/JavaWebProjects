package com.gxnu.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 预约挂号表
 * @author 澜
 *
 */
public class Registration implements Serializable {
	private int id;
	private Doctor doctor;
	private Patient patient;
    private Timestamp reserve_time;
    private Timestamp pay_time;
    private String number;
    private String yuliu;
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
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public Timestamp getReserve_time() {
		return reserve_time;
	}
	public void setReserve_time(Timestamp reserve_time) {
		this.reserve_time = reserve_time;
	}
	public Timestamp getPay_time() {
		return pay_time;
	}
	public void setPay_time(Timestamp pay_time) {
		this.pay_time = pay_time;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getYuliu() {
		return yuliu;
	}
	public void setYuliu(String yuliu) {
		this.yuliu = yuliu;
	}
	@Override
	public String toString() {
		return "Registration [id=" + id + ", doctor=" + doctor + ", patient=" + patient + ", reserve_time="
				+ reserve_time + ", pay_time=" + pay_time + ", number=" + number + ", yuliu=" + yuliu + "]";
	}
	public Registration(int id, Doctor doctor, Patient patient, Timestamp reserve_time, Timestamp pay_time,
			String number, String yuliu) {
		super();
		this.id = id;
		this.doctor = doctor;
		this.patient = patient;
		this.reserve_time = reserve_time;
		this.pay_time = pay_time;
		this.number = number;
		this.yuliu = yuliu;
	}
	public Registration(Doctor doctor, Patient patient, Timestamp reserve_time, Timestamp pay_time, String number,
			String yuliu) {
		super();
		this.doctor = doctor;
		this.patient = patient;
		this.reserve_time = reserve_time;
		this.pay_time = pay_time;
		this.number = number;
		this.yuliu = yuliu;
	}
	public Registration() {
		super();
	}
    
	
    
}
