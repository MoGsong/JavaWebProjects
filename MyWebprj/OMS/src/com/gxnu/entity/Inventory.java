package com.gxnu.entity;

import java.io.Serializable;

public class Inventory implements Serializable{
 
	private int id;
	private DrugInfo drugInfo;
	private Measure measur;
	private int xprice;
	private int num;
	private String yuliu;
	
	public Inventory(int id, DrugInfo drugInfo, Measure measur, int xprice, int num, String yuliu) {
		super();
		this.id = id;
		this.drugInfo = drugInfo;
		this.measur = measur;
		this.xprice = xprice;
		this.num = num;
		this.yuliu = yuliu;
	}

	public Inventory(DrugInfo drugInfo, Measure measur, int xprice, int num, String yuliu) {
		super();
		this.drugInfo = drugInfo;
		this.measur = measur;
		this.xprice = xprice;
		this.num = num;
		this.yuliu = yuliu;
	}

	public Inventory(DrugInfo drugInfo, Measure measur, int xprice, int num) {
		super();
		this.drugInfo = drugInfo;
		this.measur = measur;
		this.xprice = xprice;
		this.num = num;
	}
	
	

	public Inventory(int id, DrugInfo drugInfo, Measure measur, int xprice, int num) {
		super();
		this.id = id;
		this.drugInfo = drugInfo;
		this.measur = measur;
		this.xprice = xprice;
		this.num = num;
	}

	public Inventory() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public DrugInfo getDrugInfo() {
		return drugInfo;
	}

	public void setDrugInfo(DrugInfo drugInfo) {
		this.drugInfo = drugInfo;
	}

	public Measure getMeasur() {
		return measur;
	}

	public void setMeasur(Measure measur) {
		this.measur = measur;
	}

	public int getXprice() {
		return xprice;
	}

	public void setXprice(int xprice) {
		this.xprice = xprice;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getYuliu() {
		return yuliu;
	}

	public void setYuliu(String yuliu) {
		this.yuliu = yuliu;
	}

	@Override
	public String toString() {
		return "Inventory [id=" + id + ", drugInfo=" + drugInfo + ", measur=" + measur + ", xprice=" + xprice + ", num="
				+ num + ", yuliu=" + yuliu + "]";
	}
	
	
	
	
}
