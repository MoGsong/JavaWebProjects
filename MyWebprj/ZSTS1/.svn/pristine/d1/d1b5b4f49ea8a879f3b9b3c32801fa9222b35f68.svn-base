package com.gxnu.service;

import java.util.List;

import com.gxnu.entity.lnformation;
/**
 * 	邮件信息业务接口
 * @author johny
 *  业务层通常调用持久层方法，完成具体业务功能
 */
public interface IInformationService {
	//添加邮件信息
	public void add(lnformation information);
	//删除邮件信息
	public void remove(int id);
	//修改邮件信息
	public void update(lnformation information);
	//查询邮件信息，单个
	public lnformation find(int id);
	//查询邮件信息，所有
	public List<lnformation> find();
	
	//查询某一页上的邮件信息,currentPage要显示数据对应的页码，pageSize表示每一页显示的最大记录条数
	public List<lnformation> find(int currentPage,int pageSize);
	
}
