package com.gxnu.service;

import java.util.List;

import com.gxnu.entity.User;


public interface IUserService {
	public void add(User user);
	//用户删除
	public void remove(int id);
	//用户修改
	public void update(User user);
	//单个用户查询
	public User findById(int id);
	//查询用户
	public List<User> find();
}
