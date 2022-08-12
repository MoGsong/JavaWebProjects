package com.gxnu.service.imp;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gxnu.dao.RssDAO;
import com.gxnu.entity.Rss;
import com.gxnu.service.IRssService;

/**
 * RSS业务类
 * @author xx
 * 业务层通常调用持久层方法，完成具体业务功能
 * 把异常代码进行处理
 */

public class RssService implements IRssService{
	@Override
	public void add(Rss rss) {
		//创建RSS持久层对象 
		RssDAO rssDAO = new RssDAO();
		try {
			rssDAO.add(rss);
		} catch (ClassNotFoundException | SQLException e) {
			// 把异常轨迹进行打印显示
			e.printStackTrace();
		}
	}

	@Override
	public void remove(int id) {
		//创建RSS持久层对象
		RssDAO rssDAO = new RssDAO();
		Rss rss = new Rss(); //{id=0}
		rss.setId(id);
		try {
			rssDAO.delete(rss);
		} catch (ClassNotFoundException | SQLException e) {
			// 把异常轨迹进行打印显示
			e.printStackTrace();
		}
	}

	@Override
	public void update(Rss rss) {
		//创建RSS持久层对象 
		RssDAO rssDAO = new RssDAO();
		try {
			rssDAO.merge(rss);
		} catch (ClassNotFoundException | SQLException e) {
			// 把异常轨迹进行打印显示
			e.printStackTrace();
		}
	}

	@Override
	public Rss find(int id) {
		//创建RSS持久层对象 
		RssDAO rssDAO = new RssDAO();
		Rss rss = new Rss(); //{id=0,name=null}
		try {
			rss = rssDAO.findByPrimaryKey(id);
		} catch (ClassNotFoundException | SQLException e) {
			// 把异常轨迹进行打印显示
			e.printStackTrace();
		}
		return rss;
	}

	@Override
	public List<Rss> find() {
		//创建RSS持久层对象 
		RssDAO rssDAO = new RssDAO();
		List<Rss> rsss = new ArrayList<Rss>();
		try {
			rsss =rssDAO.findAll();
		} catch (ClassNotFoundException | SQLException e) {
			// 把异常轨迹进行打印显示
			e.printStackTrace();
		}
		return rsss;
	}
	
	@Override
	public List<Rss> find(int currentPage,int pageSize) {
		
		RssDAO rssDAO = new RssDAO();
		List<Rss> rsss = new ArrayList<Rss>();
		try {
			rsss =rssDAO.findAll();
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		return rsss;
	}

}
