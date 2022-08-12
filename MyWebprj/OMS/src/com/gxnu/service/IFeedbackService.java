package com.gxnu.service;

import java.sql.Timestamp;
import java.util.List;


import com.gxnu.entity.Feedback;



/**
 * 留言反馈业务接口
 * @author 胖子不露小酒窝
 *业务层通常调用持久层方法，完成具体的业务功能
 */
public interface IFeedbackService {
	//添加留言反馈
	public void add(Feedback feedback);
	//删除留言反馈
	public void remove(int id);
	//修改留言反馈
	public void update(Feedback feedback);
	//查询留言反馈，单个
	public Feedback find(int id);
	//查询留言反馈，所有
	public List<Feedback> find();
	//根据time字段查询所有留言反馈信息,若parent=0，则查询得到所有父留言反馈，若parent！=0，则查询
	public List<Feedback> findByTime(Timestamp time);
	//查询某一页上的邮件信息,currentPage表示显示数据对应的页码，pageSize显示每一页对应的最大记录条数
	public List<Feedback> find(int currentPage,int pageSize);
	
}
