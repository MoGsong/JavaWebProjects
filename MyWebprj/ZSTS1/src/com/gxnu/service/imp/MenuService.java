package com.gxnu.service.imp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gxnu.dao.MenuDAO;
import com.gxnu.entity.Menu;
import com.gxnu.service.IMenuService;


/**
 * 角色业务类
 * @author johny
 * 业务层通常调用持久层方法，完成具体业务功能
 * 把异常代码进行处理
 */
public class MenuService implements IMenuService {
	/**
	 * 查询添加对象
	 */
	@Override
	public void add(Menu menu) {
		//创建角色持久层对象 
		MenuDAO menuDAO = new MenuDAO();
		try {
			menuDAO.add(menu);
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
		MenuDAO menuDAO = new MenuDAO();
		Menu menu = new Menu(); //{id=0}
		menu.setId(id);
		try {
			menuDAO.delete(menu);
		} catch (ClassNotFoundException | SQLException e) {
			// 把异常轨迹进行打印显示
			e.printStackTrace();
		}
	}

	/**
	 * 查询修改对象
	 */
	@Override
	public void update(Menu menu) {
		//创建角色持久层对象 
		MenuDAO menuDAO = new MenuDAO();
		try {
			menuDAO.merge(menu);
		} catch (ClassNotFoundException | SQLException e) {
			// 把异常轨迹进行打印显示
			e.printStackTrace();
		}
	}

	/**
	 * 查询单个对象
	 */
	@Override
	public Menu find(int id) {
		//创建角色持久层对象 
		MenuDAO menuDAO = new MenuDAO();
		Menu menu = new Menu(); //{id=0,name=null}
		try {
			menu = menuDAO.findByPrimaryKey(id);
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		return menu;
	}

	/**
	 * 查询所有对象
	 */
	@Override
	public List<Menu> find() {
		//创建角色持久层对象 
		MenuDAO menuDAO = new MenuDAO();
		List<Menu> menus = new ArrayList<Menu>();
		try {
			menus=menuDAO.findAll();
		} catch (ClassNotFoundException | SQLException e) {
			// 把异常轨迹进行打印显示
			e.printStackTrace();
		}
		return menus;
	}
	
/**
 * 根据parent字段查询所有菜单信息
 *若parent=0,则查询得到所有父菜单，若parent=!=0,则查询的是所有父菜单的子菜单
 */
	public List<Menu>  findByParent(int parent) {
	
	
		//创建角色持久层对象 
		MenuDAO menuDAO = new MenuDAO();
		List<Menu> menus = new ArrayList<Menu>();
		try {
			menus=menuDAO.findAll(parent);	} 
		catch (ClassNotFoundException | SQLException e) {
			// 把异常轨迹进行打印显示
			e.printStackTrace();
		}
		return menus;
	}
	
	/**
	 * 	分页查询
	 */
	@Override
	public List<Menu> find(int currentPage,int pageSize) {
		// 创建邮件信息持久层对象
		MenuDAO menuDAO=new MenuDAO();
		List<Menu> menus=new ArrayList<Menu>();
		try {
			menus = menuDAO.findAll(currentPage,pageSize);
		} catch (ClassNotFoundException | SQLException e) {
			// 把异常轨迹进行打印显示
			e.printStackTrace();
		}
		return menus;
	}
}
