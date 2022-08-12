package com.gxnu.service;

import java.util.List;


import com.gxnu.entity.Menu;



/**
 * 菜单业务接口
 * @author 胖子不露小酒窝
 *业务层通常调用持久层方法，完成具体的业务功能
 */
public interface IMenuService {
	//添加菜单
	public void add(Menu menu);
	//删除菜单
	public void remove(int id);
	//修改菜单
	public void update(Menu menu);
	//查询菜单，单个
	public Menu find(int id);
	//查询菜单，所有
	public List<Menu> find();
	//根据parent字段查询所有菜单信息,若parent=0，则查询得到所有父菜单，若parent！=0，则查询
	public List<Menu> findByParent(int parent);
	//查询某一页上的邮件信息,currentPage表示显示数据对应的页码，pageSize显示每一页对应的最大记录条数
	public List<Menu> find(int currentPage,int pageSize);
	
}
