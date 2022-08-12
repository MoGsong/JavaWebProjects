package com.gxnu.service.imp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gxnu.dao.MenuDAO;
import com.gxnu.entity.Menu;
import com.gxnu.service.IMenuService;

public class MenuService implements IMenuService {
	public void add(Menu menu) {
		//创建菜单持久层对象
		MenuDAO menuDAO=new MenuDAO();
		try {
			menuDAO.add(menu);
		} catch (ClassNotFoundException | SQLException e) {
			// 把异常轨迹进行打印显示
			e.printStackTrace();
		}
	}

	public void remove(int id) {
		// 创建菜单持久层对象
		MenuDAO menuDAO=new MenuDAO();
		Menu menu=new Menu();
		menu.setId(id);
		try {
			menuDAO.delete(menu);
		} catch (ClassNotFoundException | SQLException e) {
			// 把异常轨迹进行打印显示
			e.printStackTrace();
		}
		
	}

	public void update(Menu menu) {
		// 创建菜单持久层对象
				MenuDAO menuDAO=new MenuDAO();
				try {
					menuDAO.merge(menu);
				} catch (ClassNotFoundException | SQLException e) {
					// 把异常轨迹进行打印显示
					e.printStackTrace();
				}
		
	}

	public Menu find(int id) {
		// 创建菜单持久层对象
				MenuDAO menuDAO=new MenuDAO();
				Menu menu=new Menu();
				try {
					menu=menuDAO.findByPrimaryKey(id);
				} catch (ClassNotFoundException | SQLException e) {
					//把异常轨迹进行打印显示
					e.printStackTrace();
				}
		return menu;
	}

	public List<Menu> find() {
		// 创建菜单持久层对象
		MenuDAO menuDAO=new MenuDAO();
		List<Menu> menus = new ArrayList<Menu>();
		try {
			menus=menuDAO.findAll();
		} catch (ClassNotFoundException | SQLException e) {
			// 把异常轨迹进行打印显示
			e.printStackTrace();
		}
		return menus;
	}

	@Override
	public List<Menu> findByParent(int parent) {
		// 创建菜单持久层对象
				MenuDAO menuDAO = new MenuDAO();
				List<Menu> menus = new ArrayList<Menu>();
				try {
					menus = menuDAO.findAll(parent);
				} catch (ClassNotFoundException | SQLException e) {
					// 把异常轨迹进行打印显示
					e.printStackTrace();
				}
				return menus;
	}

	@Override
	public List<Menu> find(int currentPage, int pageSize) {
		MenuDAO menuDAO = new MenuDAO();
		List<Menu> menus = new ArrayList<Menu>();
		try {
			menus = menuDAO.findAll();
		} catch (ClassNotFoundException | SQLException e) {
			// 把异常轨迹进行打印显示
			e.printStackTrace();
		}
		return menus;
	}
}