package com.gxnu.service;

import java.util.List;

import com.gxnu.entity.Rss;



public interface IRssService {
	//添加RSS信息
	public void add(Rss rss);
	
	//删除RSS信息
	public void remove(int id);
	
	//修改RSS信息
	public void update(Rss rss);
	//查询RSS信息，单个
	public Rss find(int id);
	//查询RSS信息，所有
	public List<Rss> find();
	List<Rss> find(int currentPage, int pageSize);
	
	
}
