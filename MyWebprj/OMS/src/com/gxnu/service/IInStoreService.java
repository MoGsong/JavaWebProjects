package com.gxnu.service;

import java.util.List;

import com.gxnu.entity.InStore;
/**
 * 入库信息，业务层接口
 * @author ymp0519
 *
 */
public interface IInStoreService {
	//增加入库
	public void add(InStore inStore);
	//删除入库
	public void remove(int id);
	//修改入库
	public void update(InStore inStore);
	//通过id寻找入库
	public InStore find(int id);
	//寻找所有入库信息
	public List<InStore> findAll();
	//分页，寻找部分入库信息
	public List<InStore> find(int currentPage,int pageSize);
	
}
