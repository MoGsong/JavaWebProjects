package com.gxnu.entity;

import java.io.Serializable;
/**
 * 处方表
 * @author MoHX
 *
 */
public class Recipe implements Serializable{
	private int id;
	private String time;//处方日期
	private int proof;//取药码
	private Patient patient;//患者
	private Doctor doctor;//医生
	private String yuliu;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getProof() {
		return proof;
	}
	public void setProof(int proof) {
		this.proof = proof;
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
	public String getYuliu() {
		return yuliu;
	}
	public void setYuliu(String yuliu) {
		this.yuliu = yuliu;
	}
	public Recipe(int id, String time, int proof, Patient patient, Doctor doctor, String yuliu) {
		super();
		this.id = id;
		this.time = time;
		this.proof = proof;
		this.patient = patient;
		this.doctor = doctor;
		this.yuliu = yuliu;
	}
	public Recipe(String time, int proof, Patient patient, Doctor doctor, String yuliu) {
		super();
		this.time = time;
		this.proof = proof;
		this.patient = patient;
		this.doctor = doctor;
		this.yuliu = yuliu;
	}
	public Recipe() {
		super();
	}
	@Override
	public String toString() {
		return "Recipe [id=" + id + ", time=" + time + ", proof=" + proof + ", patient=" + patient + ", doctor="
				+ doctor + ", yuliu=" + yuliu + "]";
	}
	
	
}
