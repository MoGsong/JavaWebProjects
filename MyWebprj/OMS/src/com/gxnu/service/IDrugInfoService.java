package com.gxnu.service;

import java.util.List;

import com.gxnu.entity.DrugInfo;

public interface IDrugInfoService {
	//增加药品信息
		public void add(DrugInfo drugInfo);
		//删除药品信息
		public void remove(int id);
		//修改药品信息
		public void update(DrugInfo drugInfo);
		//通过id寻找药品信息
		public DrugInfo find(int id);
		//寻找所有药品信息信息
		public List<DrugInfo> findAll();
		//分页，寻找部分药品信息信息
		public List<DrugInfo> find(int currentPage,int pageSize);
}
