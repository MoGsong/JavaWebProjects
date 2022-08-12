package com.gxnu.service.imp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gxnu.dao.InventoryDAO;
import com.gxnu.entity.Inventory;
import com.gxnu.service.IInventoryService;

public class InventoryService implements IInventoryService{

	@Override
	public void add(Inventory inventory) {
		// TODO Auto-generated method stub
		InventoryDAO it = new InventoryDAO();
		try {
			it.add(inventory);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void remove(int id) {
		// TODO Auto-generated method stub
		InventoryDAO it = new InventoryDAO();
		try {
			it.delete(id);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Inventory inventory) {
		// TODO Auto-generated method stub
		InventoryDAO it = new InventoryDAO();
		try {
			it.merge(inventory);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Inventory find(int id) {
		// TODO Auto-generated method stub
		InventoryDAO it = new InventoryDAO();
		Inventory inventory = new Inventory();
		try {
		   inventory = it.findById(id);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return inventory;
	}

	@Override
	public List<Inventory> find() {
		// TODO Auto-generated method stub
		InventoryDAO it = new InventoryDAO();
		List<Inventory> inventories = new ArrayList<Inventory>();
		try {
			inventories =  it.findAll();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return inventories;
	}

	@Override
	public List<Inventory> find(int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		InventoryDAO it = new InventoryDAO();
		List<Inventory> inventories = new ArrayList<Inventory>();
		try {
			inventories =  it.findAll(currentPage, pageSize);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return inventories;
	}

}
