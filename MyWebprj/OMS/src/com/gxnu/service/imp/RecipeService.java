package com.gxnu.service.imp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gxnu.dao.RecipeDAO;
import com.gxnu.entity.Recipe;
import com.gxnu.service.IRecipeService;

/**
 * 处方表操作对应的业务类
 * @author 
 *业务层需合理调用持久层，完成具体的业务功能
 *处理异常
 */
public class RecipeService implements IRecipeService {

	@Override
	public void add(Recipe recipe) {
		//创建持久层类对象
		RecipeDAO recipeDAO = new RecipeDAO();
		try {
			recipeDAO.add(recipe);
		} catch (ClassNotFoundException | SQLException e) {
			//处理异常，打印异常轨迹
			e.printStackTrace();
		}
		
	}

	@Override
	public void remove(int id) {
		//删除持久层类对象
		RecipeDAO recipeDAO = new RecipeDAO();
		Recipe recipe = new Recipe();
		recipe.setId(id);
		try {
			recipeDAO.delete(recipe);
		} catch (ClassNotFoundException | SQLException e) {
			//处理异常，打印异常轨迹
			e.printStackTrace();
		}
	}

	@Override
	public void update(Recipe recipe) {
		//修改持久层类对象
		RecipeDAO recipeDAO = new RecipeDAO();
		try {
			recipeDAO.merge(recipe);
		} catch (ClassNotFoundException | SQLException e) {
			//处理异常，打印异常轨迹
			e.printStackTrace();
		}
	}

	@Override
	public List<Recipe> find() {
		//查询所有持久层类对象
		RecipeDAO recipeDAO = new RecipeDAO();
		List<Recipe> recipes =new ArrayList<Recipe>();
		//Recipe[] recipes =new Recipe[1];
		try {
			recipes = recipeDAO.findAll();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return recipes;
	}

	@Override
	public Recipe find(int id) {
		//查询单个持久层类对象
		RecipeDAO recipeDAO = new RecipeDAO();
		Recipe recipe = new Recipe();
		try {
			recipe = recipeDAO.findById(id);
		} catch (ClassNotFoundException | SQLException e) {
			//处理异常，打印异常轨迹
			e.printStackTrace();
		}
		return recipe;
	}


}
