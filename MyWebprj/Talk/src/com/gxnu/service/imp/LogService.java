package com.gxnu.service.imp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gxnu.dao.LogDAO;
import com.gxnu.entity.Log;
import com.gxnu.service.ILogService;

public class LogService implements ILogService{
	/**
	 * 查询添加对象
	 */
	@Override
	public void add(Log log) {
		//创建角色持久层对象 
		LogDAO logDAO = new LogDAO();
		try {
			logDAO.add(log);
		} catch (ClassNotFoundException | SQLException e) {
			//创建角色持久层对象 
			e.printStackTrace();
		}
	}

	/**
	 * 查询删除对象
	 */
	@Override
	public void remove(int id) {
		//创建角色持久层对象 
		LogDAO logDAO = new LogDAO();
		Log log = new Log(); //{id=0}
		log.setId(id);
		try {
			logDAO.delete(log);
		} catch (ClassNotFoundException | SQLException e) {
			// 把异常轨迹进行打印显示
			e.printStackTrace();
		}
	}


	/**
	 * 查询单个对象
	 */
	@Override
	public Log findById(int id) {
		//创建角色持久层对象 
		LogDAO logDAO = new LogDAO();
		Log log = new Log(); //{id=0,name=null}
		try {
			log = logDAO.findById(id);
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		return log;
	}

	/**
	 * 查询所有对象
	 */
	@Override
	public List<Log> find() {
		//创建角色持久层对象 
		LogDAO logDAO = new LogDAO();
		List<Log> logs = new ArrayList<Log>();
		try {
			logs=logDAO.findAll();
		} catch (ClassNotFoundException | SQLException e) {
			// 把异常轨迹进行打印显示
			e.printStackTrace();
		}
		return logs;
	}
	
	@Override
	public List<Log>  findAll(String name, int id) {
		//创建角色持久层对象 
		LogDAO logDAO = new LogDAO();
		List<Log> logs = new ArrayList<Log>();
		try {
			logs=logDAO.findAll(name,id);	} 
		catch (ClassNotFoundException | SQLException e) {
			// 把异常轨迹进行打印显示
			e.printStackTrace();
		}
		return logs;
	}


}
