package com.gxnu.service.imp;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gxnu.dao.Typical_caseDAO;
import com.gxnu.entity.Typical_case;
import com.gxnu.service.ITypical_caseService;

/**
 * Typical_case业务类
 * @author xx
 * 业务层通常调用持久层方法，完成具体业务功能
 * 把异常代码进行处理
 */

public class Typical_caseService implements ITypical_caseService{
	@Override
	public void add(Typical_case typical_case) {
		//创建Typical_case持久层对象 
		Typical_caseDAO typical_caseDAO = new Typical_caseDAO();
		try {
			typical_caseDAO.add(typical_case);
		} catch (ClassNotFoundException | SQLException e) {
			// 把异常轨迹进行打印显示
			e.printStackTrace();
		}
	}

	@Override
	public void remove(int id) {
		//创建Typical_case持久层对象
		Typical_caseDAO typical_caseDAO = new Typical_caseDAO();
		Typical_case typical_case = new Typical_case(); //{id=0}
		typical_case.setId(id);
		try {
			typical_caseDAO.delete(typical_case);
		} catch (ClassNotFoundException | SQLException e) {
			// 把异常轨迹进行打印显示
			e.printStackTrace();
		}
	}

	@Override
	public void update(Typical_case typical_case) {
		//创建Typical_case持久层对象 
		Typical_caseDAO typical_caseDAO = new Typical_caseDAO();
		try {
			typical_caseDAO.merge(typical_case);
		} catch (ClassNotFoundException | SQLException e) {
			// 把异常轨迹进行打印显示
			e.printStackTrace();
		}
	}

	@Override
	public Typical_case find(int id) {
		//创建Typical_case持久层对象 
		Typical_caseDAO typical_caseDAO = new Typical_caseDAO();
		Typical_case typical_case = new Typical_case(); //{id=0,name=null}
		try {
			typical_case = typical_caseDAO.findByPrimaryKey(id);
		} catch (ClassNotFoundException | SQLException e) {
			// 把异常轨迹进行打印显示
			e.printStackTrace();
		}
		return typical_case;
	}

	@Override
	public List<Typical_case> find() {
		//创建Typical_case持久层对象 
		Typical_caseDAO typical_caseDAO = new Typical_caseDAO();
		List<Typical_case> typical_cases = new ArrayList<Typical_case>();
		try {
			typical_cases =typical_caseDAO.findAll();
		} catch (ClassNotFoundException | SQLException e) {
			// 把异常轨迹进行打印显示
			e.printStackTrace();
		}
		return typical_cases;
	}
	
	@Override
	public List<Typical_case> find(int currentPage,int pageSize) {
		
		Typical_caseDAO typical_caseDAO = new Typical_caseDAO();
		List<Typical_case> typical_cases = new ArrayList<Typical_case>();
		try {
			typical_cases =typical_caseDAO.findAll(currentPage,pageSize);
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		return typical_cases;
	}

}
