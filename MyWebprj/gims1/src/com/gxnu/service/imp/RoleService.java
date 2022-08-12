package com.gxnu.service.imp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gxnu.dao.RoleDAO;

import com.gxnu.entity.Role;
import com.gxnu.service.IRoleService;

/**
 * 角色业务类
 * @author 胖子不露小酒窝
 *业务层通常调用持久层方法，完成具体业务功能
 */
public class RoleService implements IRoleService{
	@Override
	public void add(Role role) {
		//创建角色持久层对象
		RoleDAO roleDAO=new RoleDAO();
		try {
			roleDAO.add(role);
		} catch (ClassNotFoundException | SQLException e) {
			// 把异常轨迹进行打印显示
			e.printStackTrace();
		}
	}

	@Override
	public void remove(int id) {
		// 创建角色持久层对象
		RoleDAO roleDAO=new RoleDAO();
		Role role=new Role();
		role.setId(id);
		try {
			roleDAO.delete(role);
		} catch (ClassNotFoundException | SQLException e) {
			// 把异常轨迹进行打印显示
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Role role) {
		// 创建角色持久层对象
				RoleDAO roleDAO=new RoleDAO();
				try {
					roleDAO.merge(role);
				} catch (ClassNotFoundException | SQLException e) {
					// 把异常轨迹进行打印显示
					e.printStackTrace();
				}
		
	}

	@Override
	public Role find(int id) {
		// 创建角色持久层对象
				RoleDAO roleDAO=new RoleDAO();
				Role role=new Role();
				try {
					role=roleDAO.findByPrimaryKey(id);
				} catch (ClassNotFoundException | SQLException e) {
					//把异常轨迹进行打印显示
					e.printStackTrace();
				}
		return role;
	}

	@Override
	public List<Role> find() {
		// 创建角色持久层对象
		RoleDAO roleDAO=new RoleDAO();
		List<Role> roles=new ArrayList<Role>();
		try {
			roles=roleDAO.findAll();
		} catch (ClassNotFoundException | SQLException e) {
			// 把异常轨迹进行打印显示
			e.printStackTrace();
		}
		return roles;
	}

}
