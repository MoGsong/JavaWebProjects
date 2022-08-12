package com.gxnu.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import com.gxnu.entity.Doctor;


public class InDetail implements Serializable{

	private int id;
	private InStore inStore ;
	private Inventory inventory;
	private int price;
	private int num;
	private String yuliu;
	
	/**
	 * 无参构造方法
	 */
	public InDetail() {
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

	public InDetail(InStore inStore, Inventory inventory, int price, int num, String yuliu) {
		super();
		this.inStore = inStore;
		this.inventory = inventory;
		this.price = price;
		this.num = num;
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

	public InDetail(int id, InStore inStore, Inventory inventory, int price, int num, String yuliu) {
		super();
		this.id = id;
		this.inStore = inStore;
		this.inventory = inventory;
		this.price = price;
		this.num = num;
		this.yuliu = yuliu;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public InStore getInStore() {
		return inStore;
	}

	public void setInStore(InStore inStore) {
		this.inStore = inStore;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
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
		return "InDetail [id=" + id + ", inStore=" + inStore + ", inventory=" + inventory + ", price=" + price
				+ ", num=" + num + ", yuliu=" + yuliu + "]";
	}



	
	
}
