
package com.gxnu.service.imp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gxnu.dao.PictureDAO;
import com.gxnu.entity.Picture;
import com.gxnu.service.IPictureService;

public class PictureService implements IPictureService {

	//添加图片
	@Override
	public void add(Picture picture) {
		// 创建持久层对象
		PictureDAO pictureDAO = new PictureDAO();
		try {
			pictureDAO.add(picture);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}

	//删除图片
	@Override
	public void remove(int id) {
		// 创建持久层对象
	    PictureDAO pictureDAO = new PictureDAO();
	    Picture picture = new Picture();
	    picture.setId(id);
		try {
			pictureDAO.delete(picture);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}

	//更新图片
	@Override
	public void update(Picture picture) {
		// 创建持久层对象
		PictureDAO pictureDAO = new PictureDAO();
		try {
			pictureDAO.merger(picture);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}

	//查询所有图片，返回为集合形式
	@Override
	public List<Picture> findAll() {
		// 创建持久层对象
		PictureDAO pictureDAO = new PictureDAO();
		List<Picture> pics = new ArrayList<Picture>();
		try {
			pics = pictureDAO.findAll();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return pics;
	}

	//根据id查询单个记录
	@Override
	public Picture findById(int id) {
		// 创建持久层对象
		PictureDAO pictureDAO = new PictureDAO();
		Picture pic = new Picture();
		try {
			pic = pictureDAO.findById(id);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return pic;
	}

	@Override
	public List<Picture> findAll(int currentPage, int pageSize) {
		//创建持久层对象
		PictureDAO pictureDAO = new PictureDAO();
		List<Picture> pics = new ArrayList<Picture>();
		try {
			pics = pictureDAO.findAll(currentPage, pageSize);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return pics;
	}
	
	

}
