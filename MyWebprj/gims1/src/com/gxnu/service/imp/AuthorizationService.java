package com.gxnu.service.imp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gxnu.dao.AuthorizationDAO;
import com.gxnu.entity.Authorization;
import com.gxnu.service.IAuthorizationService;
/**
 * 权限操作对应的业务类
 * @author johny
 * 业务层须合理调用持久层方法，完成具体业务功能
 * 处理异常
 */
public class AuthorizationService implements IAuthorizationService{
	@Override
	public void add(Authorization authorization) {
		//创建持久层类对象
		AuthorizationDAO authorizationDAO = new AuthorizationDAO();
		try {
			authorizationDAO.add(authorization);
		} catch (ClassNotFoundException | SQLException e) {
			//处理异常，打印异常的轨迹
			e.printStackTrace();
		}
	}

	@Override
	public void remove(int id) {
		//创建持久层类对象
		AuthorizationDAO authorizationDAO = new AuthorizationDAO();
		Authorization authorization = new Authorization(); //id=0
		authorization.setId(id);
		try {
			authorizationDAO.delete(authorization);
		} catch (ClassNotFoundException | SQLException e) {
			//处理异常，打印异常的轨迹
			e.printStackTrace();
		}
	}

	@Override
	public void update(Authorization authorization) {
		//创建持久层类对象
		AuthorizationDAO authorizationDAO = new AuthorizationDAO();
		try {
			authorizationDAO.merge(authorization);
		} catch (ClassNotFoundException | SQLException e) {
			//处理异常，打印异常的轨迹
			e.printStackTrace();
		}
	}

	@Override
	public Authorization find(int id) {
		//创建持久层类对象
		AuthorizationDAO authorizationDAO = new AuthorizationDAO();
		Authorization authorization = new Authorization();
		try {
			authorization = authorizationDAO.findByPrimaryKey(id);
		} catch (ClassNotFoundException | SQLException e) {
			//处理异常，打印异常的轨迹
			e.printStackTrace();
		}
		return authorization;
	}

	@Override
	public List<Authorization> find() {
		//创建持久层类对象
		AuthorizationDAO authorizationDAO = new AuthorizationDAO();
		List<Authorization> authorizations = new ArrayList<Authorization>();
		try {
			authorizations = authorizationDAO.findAll();
		} catch (ClassNotFoundException | SQLException e) {
			//处理异常，打印异常的轨迹
			e.printStackTrace();
		}
		return authorizations;
	}

	@Override
	public List<Authorization> findByRole(int roleid) {
		//创建持久层类对象
		AuthorizationDAO authorizationDAO = new AuthorizationDAO();
		List<Authorization> authorizations = new ArrayList<Authorization>();
		try {
			authorizations = authorizationDAO.findAll(roleid);
		} catch (ClassNotFoundException | SQLException e) {
			//处理异常，打印异常的轨迹
			e.printStackTrace();
		}
		return authorizations;
	}
}