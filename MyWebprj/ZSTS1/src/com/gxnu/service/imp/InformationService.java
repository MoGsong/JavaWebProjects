package com.gxnu.service.imp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gxnu.dao.lnformationDAO;
import com.gxnu.entity.lnformation;
import com.gxnu.service.IInformationService;
/**
 * 邮件信息业务类
 * @author johny
 * 业务层通常调用持久层方法，完成具体业务功能
 * 把异常代码进行处理
 */
public class InformationService implements IInformationService {
	@Override
	public void add(lnformation information) {
		//创建邮件信息持久层对象 
		lnformationDAO informationDAO = new lnformationDAO();
		try {
			informationDAO.add(information);
		} catch (ClassNotFoundException | SQLException e) {
			// 把异常轨迹进行打印显示
			e.printStackTrace();
		}
	}

	@Override
	public void remove(int id) {
		//创建邮件信息持久层对象 
		lnformationDAO informationDAO = new lnformationDAO();
		lnformation information = new lnformation(); //{id=0}
		information.setId(id);
		try {
			informationDAO.delete(information);
		} catch (ClassNotFoundException | SQLException e) {
			// 把异常轨迹进行打印显示
			e.printStackTrace();
		}
	}

	@Override
	public void update(lnformation information) {
		//创建邮件信息持久层对象 
		lnformationDAO informationDAO = new lnformationDAO();
		try {
			informationDAO.merge(information);
		} catch (ClassNotFoundException | SQLException e) {
			// 把异常轨迹进行打印显示
			e.printStackTrace();
		}
	}

	@Override
	public lnformation find(int id) {
		//创建邮件信息持久层对象 
		lnformationDAO informationDAO = new lnformationDAO();
		lnformation information = new lnformation(); //{id=0,name=null}
		try {
			information = informationDAO.findByPrimaryKey(id);
		} catch (ClassNotFoundException | SQLException e) {
			// 把异常轨迹进行打印显示
			e.printStackTrace();
		}
		return information;
	}

	@Override
	public List<lnformation> find() {
		//创建邮件信息持久层对象 
		lnformationDAO informationDAO = new lnformationDAO();
		List<lnformation> informations = new ArrayList<lnformation>();
		try {
			informations =informationDAO.findAll();
		} catch (ClassNotFoundException | SQLException e) {
			// 把异常轨迹进行打印显示
			e.printStackTrace();
		}
		return informations;
	}

	@Override
	public List<lnformation> find(int currentPage, int pageSize) {
		//创建邮件信息持久层对象 
		lnformationDAO informationDAO = new lnformationDAO();
		List<lnformation> informations = new ArrayList<lnformation>();
		try {
			informations =informationDAO.findAll();
		} catch (ClassNotFoundException | SQLException e) {
			// 把异常轨迹进行打印显示
			e.printStackTrace();
		}
		return informations;
	}

}
