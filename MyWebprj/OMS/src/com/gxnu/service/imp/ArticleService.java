package com.gxnu.service.imp;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gxnu.dao.ArticleDAO;
import com.gxnu.entity.Article;
import com.gxnu.service.IArticleService;

/**
 * Article业务类
 * @author xx
 * 业务层通常调用持久层方法，完成具体业务功能
 * 把异常代码进行处理
 */

public class ArticleService implements IArticleService{
	@Override
	public void add(Article article) {
		//创建Article持久层对象 
		ArticleDAO articleDAO = new ArticleDAO();
		try {
			articleDAO.add(article);
		} catch (ClassNotFoundException | SQLException e) {
			// 把异常轨迹进行打印显示
			e.printStackTrace();
		}
	}

	@Override
	public void remove(int id) {
		//创建Article持久层对象
		ArticleDAO articleDAO = new ArticleDAO();
		Article article = new Article(); //{id=0}
		article.setId(id);
		try {
			articleDAO.delete(article);
		} catch (ClassNotFoundException | SQLException e) {
			// 把异常轨迹进行打印显示
			e.printStackTrace();
		}
	}

	@Override
	public void update(Article article) {
		//创建Article持久层对象 
		ArticleDAO articleDAO = new ArticleDAO();
		try {
			articleDAO.merge(article);
		} catch (ClassNotFoundException | SQLException e) {
			// 把异常轨迹进行打印显示
			e.printStackTrace();
		}
	}

	@Override
	public Article find(int id) {
		//创建Article持久层对象 
		ArticleDAO articleDAO = new ArticleDAO();
		Article article = new Article(); //{id=0,name=null}
		try {
			article = articleDAO.findByPrimaryKey(id);
		} catch (ClassNotFoundException | SQLException e) {
			// 把异常轨迹进行打印显示
			e.printStackTrace();
		}
		return article;
	}

	@Override
	public List<Article> find() {
		//创建Article持久层对象 
		ArticleDAO articleDAO = new ArticleDAO();
		List<Article> articles = new ArrayList<Article>();
		try {
			articles =articleDAO.findAll();
		} catch (ClassNotFoundException | SQLException e) {
			// 把异常轨迹进行打印显示
			e.printStackTrace();
		}
		return articles;
	}
	
	@Override
	public List<Article> find(int currentPage,int pageSize) {
		
		ArticleDAO articleDAO = new ArticleDAO();
		List<Article> articles = new ArrayList<Article>();
		try {
			articles =articleDAO.findAll(currentPage,pageSize);
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		return articles;
	}

}
