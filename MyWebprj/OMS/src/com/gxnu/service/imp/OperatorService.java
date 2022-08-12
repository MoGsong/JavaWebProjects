package com.gxnu.service.imp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gxnu.dao.OperatorDAO;
import com.gxnu.entity.Operator;
import com.gxnu.service.IOperatorService;
/**
 * 操作员操作对应的业务类
 * @author johny
 * 业务层须合理调用持久层方法，完成具体业务功能
 * 处理异常
 */
public class OperatorService implements IOperatorService{
	@Override
	public void add(Operator operator) {
		//创建持久层类对象
		OperatorDAO operatorDAO = new OperatorDAO();
		try {
			operatorDAO.add(operator);
		} catch (ClassNotFoundException | SQLException e) {
			//处理异常，打印异常的轨迹
			e.printStackTrace();
		}
	}
	@Override
	public void remove(int id) {
		//创建持久层类对象
		OperatorDAO operatorDAO = new OperatorDAO();
		Operator operator = new Operator(); //id=0
		operator.setId(id);
		try {
			operatorDAO.delete(operator);
		} catch (ClassNotFoundException | SQLException e) {
			//处理异常，打印异常的轨迹
			e.printStackTrace();
		}
	}
	@Override
	public void update(Operator operator) {
		//创建持久层类对象
		OperatorDAO operatorDAO = new OperatorDAO();
		try {
			operatorDAO.merge(operator);
		} catch (ClassNotFoundException | SQLException e) {
			//处理异常，打印异常的轨迹
			e.printStackTrace();
		}
	}
	@Override
	public Operator find(int id) {
		//创建持久层类对象
		OperatorDAO operatorDAO = new OperatorDAO();
		Operator operator = new Operator();
		try {
			operator = operatorDAO.findByPrimaryKey(id);
		} catch (ClassNotFoundException | SQLException e) {
			//处理异常，打印异常的轨迹
			e.printStackTrace();
		}
		return operator;
	}
	@Override
	public List<Operator> find() {
		//创建持久层类对象
		OperatorDAO operatorDAO = new OperatorDAO();
		List<Operator> operators = new ArrayList<Operator>();
		try {
			operators = operatorDAO.findAll();
		} catch (ClassNotFoundException | SQLException e) {
			//处理异常，打印异常的轨迹
			e.printStackTrace();
		}
		return operators;
	}
	@Override
	/**
	 * 表中的操作员id均大于0,若返回的op的id=0，表示该用户名和密码的操作员在表中不存在，该 用户不合法
	 */
	public Operator find(String username, String password) {
		// 遍历所有操作员，若存在对应用户名和密码的操作员，则说明该用户合法，返回
		OperatorDAO operatorDAO = new OperatorDAO();
		List<Operator> operators = new ArrayList<Operator>();
		Operator op = new Operator(); //{id=0,username=null,password=null...}
		try {
			operators = operatorDAO.findAll(); //表中所有操作员
			for (Operator operator : operators) {
				if(operator.getUsername().equalsIgnoreCase(username) &&
				operator.getPassword().equals(password)) {
					op = operator;
					break;
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			//处理异常，打印异常的轨迹
			e.printStackTrace();
		}
		return op;
	}
}
