package com.gxnu.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 病例表
 * @author MoHX
 *
 */
public class Record implements Serializable{
	private int id;
	private Patient patient;//患者，外键
	private Doctor doctor;//医生，外键
	private String disease;//症状
	private Timestamp time;//填写病例表时间
	private String result;//诊断结果
	private String yuliu;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public String getDisease() {
		return disease;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getYuliu() {
		return yuliu;
	}
	public void setYuliu(String yuliu) {
		this.yuliu = yuliu;
	}
	public Record(int id, Patient patient, Doctor doctor, String disease, Timestamp time, String result, String yuliu) {
		super();
		this.id = id;
		this.patient = patient;
		this.doctor = doctor;
		this.disease = disease;
		this.time = time;
		this.result = result;
		this.yuliu = yuliu;
	}
	public Record(Patient patient, Doctor doctor, String disease, Timestamp time, String result, String yuliu) {
		super();
		this.patient = patient;
		this.doctor = doctor;
		this.disease = disease;
		this.time = time;
		this.result = result;
		this.yuliu = yuliu;
	}
	public Record() {
		super();
	}
	@Override
	public String toString() {
		return "Record [id=" + id + ", patient=" + patient + ", doctor=" + doctor + ", disease=" + disease + ", time="
				+ time + ", result=" + result + ", yuliu=" + yuliu + "]";
	}
	
	
}
