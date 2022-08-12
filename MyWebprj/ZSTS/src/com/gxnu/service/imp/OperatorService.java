package com.gxnu.service.imp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gxnu.dao.OperatorDAO;
import com.gxnu.entity.Operator;
import com.gxnu.service.IOperatorService;
/**
 * 操作员业务类
 * @author xx
 * 业务层通常调用持久层方法，完成具体业务功能
 * 把异常代码进行处理
 */
public class OperatorService implements IOperatorService{
	@Override
	public void add(Operator operator) {
		//创建操作员持久层对象 
		OperatorDAO operatorDAO = new OperatorDAO();
		try {
			operatorDAO.add(operator);
		} catch (ClassNotFoundException | SQLException e) {
			// 把异常轨迹进行打印显示
			e.printStackTrace();
		}
	}
	@Override
	public void remove(int id) {
		//操作员 
		OperatorDAO operatorDAO = new OperatorDAO();
		Operator operator = new Operator(); //{id=0}
		operator.setId(id);
		try {
			operatorDAO.delete(operator);
		} catch (ClassNotFoundException | SQLException e) {
			// 把异常轨迹进行打印显示
			e.printStackTrace();
		}
	}
	@Override
	public void update(Operator operator) {
		//创建操作员持久层对象
		OperatorDAO operatorDAO = new OperatorDAO();
		try {
			operatorDAO.merge(operator);
		} catch (ClassNotFoundException | SQLException e) {
			// 把异常轨迹进行打印显示
			e.printStackTrace();
		}
	}
	@Override
	public Operator find(int id) {
		//创建操作员持久层对象 
		OperatorDAO operatorDAO = new OperatorDAO();
		Operator operator = new Operator(); //{id=0,name=null}
		try {
			operator = operatorDAO.findByPrimaryKey(id);
		} catch (ClassNotFoundException | SQLException e) {
			// 把异常轨迹进行打印显示
			e.printStackTrace();
		}
		return operator;
	}
	@Override
	public List<Operator> find() {
		//创建操作员持久层对象 
		OperatorDAO operatorDAO = new OperatorDAO();
		List<Operator> operators = new ArrayList<Operator>();
		try {
			operators =operatorDAO.findAll();
		} catch (ClassNotFoundException | SQLException e) {
			// 把异常轨迹进行打印显示
			e.printStackTrace();
		}
		return operators;
	}
	/**
	 * 形参username 和 password 表示待验证的用户
	 * 若用户在操作员表中存在，则返回op中的id属性必然 > 0
	 * 若用户在操作员表中不存在，则返回op中的id属性必然 = 0
	 */
	@Override
	public Operator find(String username,String password) {
		//调用持久层方法，完成验证֤
		OperatorDAO operatorDAO = new OperatorDAO();
		List<Operator> operators = new ArrayList<Operator>();//数组初始化
		Operator op = new Operator(); //{id = 0 , username = null , password = null...}
		try {
			operators = operatorDAO.findAll();
			//遍历数组，foreach循环，每一轮循环，都会去除数组中的一个元素，赋值operator对象
			for(Operator operator : operators) {
				//用户名比较可以不区分大小写
				if(operator.getUsername().equalsIgnoreCase(username) && operator.getPassword().equals(password)) {
					op = operator;//{id>0 , username = xx , password=xx...}
					break;
				}
			}
//			for(int i = 0 ; i < operators.length ; i++) {
//				operators[i];
//			}
		} catch (ClassNotFoundException | SQLException e) {
			//打印异常轨迹
			e.printStackTrace();
		}
		return op;
	}
	
	@Override
	public Operator findrole(String username, String email) {
		
		OperatorDAO operatorDAO = new OperatorDAO();
		List<Operator> operators = new ArrayList<Operator>();//数组初始化
		Operator op = new Operator(); //{id = 0 , username = null , password = null...}
		try {
			operators = operatorDAO.findAll();
			//遍历数组，foreach循环，每一轮循环，都会去除数组中的一个元素，赋值operator对象
			for(Operator operator : operators) {
				//用户名比较可以不区分大小写
				if(operator.getUsername().equalsIgnoreCase(username) && operator.getEmail().equals(email)) {
					op = operator;//{id>0 , username = xx , password=xx...}
					break;
				}
			}

		} catch (ClassNotFoundException | SQLException e) {
			//打印异常轨迹
			e.printStackTrace();
		}
		return op;
	}
}
