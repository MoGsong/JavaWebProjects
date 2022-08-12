package com.gxnu.service.imp;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.gxnu.dao.AboutDAO;
import com.gxnu.entity.About;
import com.gxnu.service.IAboutService;


/**
 * 关于医院业务类
 * @author johny
 * 业务层通常调用持久层方法，完成具体业务功能
 * 把异常代码进行处理
 */
public class AboutService implements IAboutService {
	/**
	 * 查询添加对象
	 */
	@Override
	public void add(About about) {
		//创建角色持久层对象 
		AboutDAO aboutDAO = new AboutDAO();
		try {
			aboutDAO.add(about);
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
		AboutDAO aboutDAO = new AboutDAO();
		About about = new About(); //{id=0}
		about.setId(id);
		try {
			aboutDAO.delete(about);
		} catch (ClassNotFoundException | SQLException e) {
			// 把异常轨迹进行打印显示
			e.printStackTrace();
		}
	}

	/**
	 * 查询修改对象
	 */
	@Override
	public void update(About about) {
		//创建角色持久层对象 
		AboutDAO aboutDAO = new AboutDAO();
		try {
			aboutDAO.update(about);
		} catch (ClassNotFoundException | SQLException e) {
			// 把异常轨迹进行打印显示
			e.printStackTrace();
		}
	}

	/**
	 * 查询单个对象
	 */
	@Override
	public About find(int id) {
		//创建角色持久层对象 
		AboutDAO aboutDAO = new AboutDAO();
		About about = new About(); //{id=0,name=null}
		try {
			about = aboutDAO.findByPrimaryKey(id);
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		return about;
	}

	/**
	 * 查询所有对象
	 */
	@Override
	public List<About> find() {
		//创建角色持久层对象 
		AboutDAO aboutDAO = new AboutDAO();
		List<About> abouts = new ArrayList<About>();
		try {
			abouts=aboutDAO.findAll();
		} catch (ClassNotFoundException | SQLException e) {
			// 把异常轨迹进行打印显示
			e.printStackTrace();
		}
		return abouts;
	}
	
}