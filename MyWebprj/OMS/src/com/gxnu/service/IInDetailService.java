package com.gxnu.service;

import java.util.List;

import com.gxnu.entity.InDetail;
/**
 * 入库明细信息，业务层接口
 * @author ymp0519
 *
 */
public interface IInDetailService {
	//增加入库明细
	public void add(InDetail inDetail);
	//删除入库明细
	public void remove(int id);
	//修改入库明细
	public void update(InDetail inDetail);
	//通过id寻找入库明细
	public InDetail find(int id);
	//寻找所有入库明细信息
	public List<InDetail> findAll();
	//分页，寻找部分入库明细信息
	public List<InDetail> find(int currentPage,int pageSize);
	
}
