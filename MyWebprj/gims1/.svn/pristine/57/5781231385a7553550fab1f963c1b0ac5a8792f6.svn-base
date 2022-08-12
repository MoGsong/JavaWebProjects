package com.gxnu.service;
import java.util.List;

import com.gxnu.entity.Authorization;
/**
 * 	权限操作对应的业务接口
 * @author johny
 *  业务接口
 */
public interface IAuthorizationService {
	//添加权限
	public void add(Authorization authorization);
	//删除权限
	public void remove(int id);
	//修改权限
	public void update(Authorization authorization);
	//查询单个权限
	public Authorization find(int id);
	//查询所有权限
	public List<Authorization> find();
	
	//根据角色，查询权限
	public List<Authorization> findByRole(int roleid);
}