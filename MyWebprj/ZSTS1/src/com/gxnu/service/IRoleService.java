package com.gxnu.service;

import java.util.List;

import com.gxnu.entity.Role;

/**
 * 业务层角色功能接口
 */
public interface IRoleService {
	 //角色添加
	public void add(Role role);
	//角色删除
	public void remove(int id);
	//角色修改
	public void update(Role role);
	//单个角色查询
	public Role find(int id);
	//查询角色
	public List<Role> find();
}
