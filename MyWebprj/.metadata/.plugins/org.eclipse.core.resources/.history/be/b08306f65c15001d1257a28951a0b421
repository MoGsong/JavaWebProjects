package com.gxnu.service;

import java.util.List;

import com.gxnu.entity.Operator;

/**
 * 业务接口
 * @author 胖子不露小酒窝
 *业务层通常调用持久层方法，完成具体的业务功能
 */
public interface IOperatorService {
	//添加操作员
	public void add(Operator operator);
	//删除操作员
	public void remove(int id);
	//修改操作员
	public void update(Operator operator);
	//查询操作员，单个
	public Operator find(int id);
	//查询操作员，所有
	public List<Operator> find();
	//查询某个用户名和密码的操作员
	public Operator find(String username,String password);
}