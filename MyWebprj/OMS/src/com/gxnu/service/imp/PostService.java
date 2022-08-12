package com.gxnu.service.imp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gxnu.dao.PostDAO;
import com.gxnu.entity.Post;
import com.gxnu.service.IPostService;
/**
 * Ȩ�޲�����Ӧ��ҵ����
 * @author johny
 * ҵ����������ó־ò㷽������ɾ���ҵ����
 * �����쳣
 */
public class PostService implements IPostService{
	@Override
	public void add(Post post) {
		//�����־ò������
		PostDAO postDAO = new PostDAO();
		try {
			postDAO.add(post);
		} catch (ClassNotFoundException | SQLException e) {
			//�����쳣����ӡ�쳣�Ĺ켣
			e.printStackTrace();
		}
	}

	@Override
	public void remove(int id) {
		//�����־ò������
		PostDAO postDAO = new PostDAO();
		Post post = new Post(); //id=0
		post.setId(id);
		try {
			postDAO.delete(post);
		} catch (ClassNotFoundException | SQLException e) {
			//�����쳣����ӡ�쳣�Ĺ켣
			e.printStackTrace();
		}
	}

	@Override
	public void update(Post post) {
		//�����־ò������
		PostDAO postDAO = new PostDAO();
		try {
			postDAO.update(post);
		} catch (ClassNotFoundException | SQLException e) {
			//�����쳣����ӡ�쳣�Ĺ켣
			e.printStackTrace();
		}
	}

	@Override
	public Post find(int id) {
		//�����־ò������
		PostDAO postDAO = new PostDAO();
		Post post = new Post();
		try {
			post = postDAO.findByPrimaryKey(id);
		} catch (ClassNotFoundException | SQLException e) {
			//�����쳣����ӡ�쳣�Ĺ켣
			e.printStackTrace();
		}
		return post;
	}

	@Override
	public List<Post> find() {
		//�����־ò������
		PostDAO postDAO = new PostDAO();
		List<Post> posts = new ArrayList<Post>();
		try {
			posts = postDAO.findAll();
		} catch (ClassNotFoundException | SQLException e) {
			//�����쳣����ӡ�쳣�Ĺ켣
			e.printStackTrace();
		}
		return posts;
	}

	@Override
	public List<Post> findByRole(int roleid) {
		//�����־ò������
		PostDAO postDAO = new PostDAO();
		List<Post> posts = new ArrayList<Post>();
		try {
			posts = postDAO.findAll();
		} catch (ClassNotFoundException | SQLException e) {
			//�����쳣����ӡ�쳣�Ĺ켣
			e.printStackTrace();
		}
		return posts;
	}
}