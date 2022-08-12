package com.gxnu.service;

import java.util.List;

import com.gxnu.entity.Log;

public interface ILogService {
	public void add(Log log);
	//删除
	public void remove(int id);

	//单个查询
	public Log findById(int id);
	//查询
	public List<Log> find();
	
	public List<Log> findAll(String name, int id);
}
