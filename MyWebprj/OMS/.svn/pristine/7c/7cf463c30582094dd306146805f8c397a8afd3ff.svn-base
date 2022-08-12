package com.gxnu.service.imp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gxnu.dao.DrugInfoDAO;
import com.gxnu.entity.DrugInfo;
import com.gxnu.service.IDrugInfoService;

public class DrugInfoService implements IDrugInfoService {

	@Override
	public void add(DrugInfo drugInfo) {
		DrugInfoDAO di = new DrugInfoDAO();
		try {
			di.add(drugInfo);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void remove(int id) {
		DrugInfoDAO di = new DrugInfoDAO();
		try {
			di.delete(id);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(DrugInfo drugInfo) {
		DrugInfoDAO di = new DrugInfoDAO();
		try {
			di.merge(drugInfo);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public DrugInfo find(int id) {
		DrugInfoDAO di = new DrugInfoDAO();
		DrugInfo drugInfo = new DrugInfo();
		try {
			drugInfo = di.findById(id);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return drugInfo;
	}

	@Override
	public List<DrugInfo> findAll() {
		DrugInfoDAO di = new DrugInfoDAO();
		List<DrugInfo> drugInfos = new ArrayList<DrugInfo>();
		try {
			drugInfos = di.findAll();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return drugInfos;
	}

	@Override
	public List<DrugInfo> find(int currentPage, int pageSize) {
		DrugInfoDAO di = new DrugInfoDAO();
		List<DrugInfo> drugInfos = new ArrayList<DrugInfo>();
		try {
			drugInfos = di.findAll(currentPage, pageSize);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return drugInfos;	}

}
