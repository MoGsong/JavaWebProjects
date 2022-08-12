package com.gxnu.service;

import java.util.List;

import com.gxnu.entity.Recipe;

public interface IRecipeService {
	//添加处方
	public void add(Recipe recipe);
	//删除处方
	public void remove(int id);
	//修改处方
	public void update(Recipe recipe);
	//查询处方，单个
	public Recipe find(int id);
	//查询处方，所有	
	public List<Recipe> find();
	
}

