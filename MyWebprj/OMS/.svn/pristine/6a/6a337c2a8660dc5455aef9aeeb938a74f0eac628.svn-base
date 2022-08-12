package com.gxnu.service.imp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gxnu.dao.PostDAO;
import com.gxnu.entity.Post;
import com.gxnu.service.IPostService;
/**
 * 权限操作对应的业务类
 * @author johny
 * 业务层须合理调用持久层方法，完成具体业务功能
 * 处理异常
 */
public class PostService implements IPostService{
	@Override
	public void add(Post post) {
		//创建持久层类对象
		PostDAO postDAO = new PostDAO();
		try {
			postDAO.add(post);
		} catch (ClassNotFoundException | SQLException e) {
			//处理异常，打印异常的轨迹
			e.printStackTrace();
		}
	}

	@Override
	public void remove(int id) {
		//创建持久层类对象
		PostDAO postDAO = new PostDAO();
		Post post = new Post(); //id=0
		post.setId(id);
		try {
			postDAO.delete(post);
		} catch (ClassNotFoundException | SQLException e) {
			//处理异常，打印异常的轨迹
			e.printStackTrace();
		}
	}

	@Override
	public void update(Post post) {
		//创建持久层类对象
		PostDAO postDAO = new PostDAO();
		try {
			postDAO.update(post);
		} catch (ClassNotFoundException | SQLException e) {
			//处理异常，打印异常的轨迹
			e.printStackTrace();
		}
	}

	@Override
	public Post find(int id) {
		//创建持久层类对象
		PostDAO postDAO = new PostDAO();
		Post post = new Post();
		try {
			post = postDAO.findByPrimaryKey(id);
		} catch (ClassNotFoundException | SQLException e) {
			//处理异常，打印异常的轨迹
			e.printStackTrace();
		}
		return post;
	}

	@Override
	public List<Post> find() {
		//创建持久层类对象
		PostDAO postDAO = new PostDAO();
		List<Post> posts = new ArrayList<Post>();
		try {
			posts = postDAO.findAll();
		} catch (ClassNotFoundException | SQLException e) {
			//处理异常，打印异常的轨迹
			e.printStackTrace();
		}
		return posts;
	}

	@Override
	public List<Post> findByRole(int roleid) {
		//创建持久层类对象
		PostDAO postDAO = new PostDAO();
		List<Post> posts = new ArrayList<Post>();
		try {
			posts = postDAO.findAll();
		} catch (ClassNotFoundException | SQLException e) {
			//处理异常，打印异常的轨迹
			e.printStackTrace();
		}
		return posts;
	}
}