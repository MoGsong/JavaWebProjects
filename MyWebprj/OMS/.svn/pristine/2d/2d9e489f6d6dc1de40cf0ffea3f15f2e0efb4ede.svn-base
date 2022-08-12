package com.gxnu.service.imp;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.gxnu.dao.FeedbackDAO;
import com.gxnu.entity.Feedback;
import com.gxnu.service.IFeedbackService;


/**
 * 角色业务类
 * @author johny
 * 业务层通常调用持久层方法，完成具体业务功能
 * 把异常代码进行处理
 */
public class FeedbackService implements IFeedbackService {
	/**
	 * 查询添加对象
	 */
	@Override
	public void add(Feedback feedback) {
		//创建角色持久层对象 
		FeedbackDAO feedbackDAO = new FeedbackDAO();
		try {
			feedbackDAO.add(feedback);
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
		FeedbackDAO feedbackDAO = new FeedbackDAO();
		Feedback feedback = new Feedback(); //{id=0}
		feedback.setId(id);
		try {
			feedbackDAO.delete(feedback);
		} catch (ClassNotFoundException | SQLException e) {
			// 把异常轨迹进行打印显示
			e.printStackTrace();
		}
	}

	/**
	 * 查询修改对象
	 */
	@Override
	public void update(Feedback feedback) {
		//创建角色持久层对象 
		FeedbackDAO feedbackDAO = new FeedbackDAO();
		try {
			feedbackDAO.merge(feedback);
		} catch (ClassNotFoundException | SQLException e) {
			// 把异常轨迹进行打印显示
			e.printStackTrace();
		}
	}

	/**
	 * 查询单个对象
	 */
	@Override
	public Feedback find(int id) {
		//创建角色持久层对象 
		FeedbackDAO feedbackDAO = new FeedbackDAO();
		Feedback feedback = new Feedback(); //{id=0,name=null}
		try {
			feedback = feedbackDAO.findByPrimaryKey(id);
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		return feedback;
	}

	/**
	 * 查询所有对象
	 */
	@Override
	public List<Feedback> find() {
		//创建角色持久层对象 
		FeedbackDAO feedbackDAO = new FeedbackDAO();
		List<Feedback> feedbacks = new ArrayList<Feedback>();
		try {
			feedbacks=feedbackDAO.findAll();
		} catch (ClassNotFoundException | SQLException e) {
			// 把异常轨迹进行打印显示
			e.printStackTrace();
		}
		return feedbacks;
	}
	
/**
 * 根据time字段查询所有留言信息
 *若parent=0,则查询得到所有父留言，若parent=!=0,则查询的是所有父留言的子留言
 */
	public List<Feedback>  findByTime(Timestamp time) {
	
	
		//创建角色持久层对象 
		FeedbackDAO feedbackDAO = new FeedbackDAO();
		List<Feedback> feedbacks = new ArrayList<Feedback>();
		try {
			feedbacks=feedbackDAO.findAll(time);	} 
		catch (ClassNotFoundException | SQLException e) {
			// 把异常轨迹进行打印显示
			e.printStackTrace();
		}
		return feedbacks;
	}
	
	/**
	 * 	分页查询
	 */
	@Override
	public List<Feedback> find(int currentPage,int pageSize) {
		// 创建邮件信息持久层对象
		FeedbackDAO feedbackDAO=new FeedbackDAO();
		List<Feedback> feedbacks=new ArrayList<Feedback>();
		try {
			feedbacks = feedbackDAO.findAll(currentPage,pageSize);
		} catch (ClassNotFoundException | SQLException e) {
			// 把异常轨迹进行打印显示
			e.printStackTrace();
		}
		return feedbacks;
	}
}