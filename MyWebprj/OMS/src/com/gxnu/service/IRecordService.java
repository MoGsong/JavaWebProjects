package com.gxnu.service;

import java.util.List;

import com.gxnu.entity.Record;

public interface IRecordService {
	//添加病例
	public void add(Record record);
	//删除病例
	public void remove(int id);
	//修改病例
	public void update(Record record);
	//查询病例，单个
	public Record find(int id);
	//查询病例，所有	
	public List<Record> find();
	//分页查询
	public List<Record> find(int currentPage,int PageSize);
	
	
}

