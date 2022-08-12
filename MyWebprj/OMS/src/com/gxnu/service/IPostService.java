package com.gxnu.service;
import java.util.List;

import com.gxnu.entity.Post;
/**
 * 	权限操作对应的业务接口
 * @author johny
 *  业务接口
 */
public interface IPostService {
	//添加权限
	public void add(Post post);
	//删除权限
	public void remove(int id);
	//修改权限
	public void update(Post post);
	
	//查询单个权限
	public Post find(int id);
	//查询所有权限
	public List<Post> find();
	
	//根据角色，查询权限
	public List<Post> findByRole(int roleid);
}
