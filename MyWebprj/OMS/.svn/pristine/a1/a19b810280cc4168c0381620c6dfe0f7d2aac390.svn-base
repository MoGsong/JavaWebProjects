package com.gxnu.service.imp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gxnu.dao.ImageDAO;
import com.gxnu.entity.Image;
import com.gxnu.service.IImageService;

/**
 * 图片管理表操作对应的业务类
 * @author 
 *业务层需合理调用持久层，完成具体的业务功能
 *处理异常
 */
public class ImageService implements IImageService {

	@Override
	public void add(Image image) {
		//创建持久层类对象
		ImageDAO imageDAO = new ImageDAO();
		try {
			imageDAO.add(image);
		} catch (ClassNotFoundException | SQLException e) {
			//处理异常，打印异常轨迹
			e.printStackTrace();
		}
		
	}

	@Override
	public void remove(int id) {
		//删除持久层类对象
		ImageDAO imageDAO = new ImageDAO();
		Image image = new Image();
		image.setId(id);
		try {
			imageDAO.delete(image);
		} catch (ClassNotFoundException | SQLException e) {
			//处理异常，打印异常轨迹
			e.printStackTrace();
		}
	}

	@Override
	public void update(Image image) {
		//修改持久层类对象
		ImageDAO imageDAO = new ImageDAO();
		try {
			imageDAO.merge(image);
		} catch (ClassNotFoundException | SQLException e) {
			//处理异常，打印异常轨迹
			e.printStackTrace();
		}
	}

	@Override
	public List<Image> find() {
		//查询所有持久层类对象
		ImageDAO imageDAO = new ImageDAO();
		List<Image> images =new ArrayList<Image>();
		//Image[] images =new Image[1];
		try {
			images = imageDAO.findAll();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return images;
	}

	@Override
	public Image find(int id) {
		//查询单个持久层类对象
		ImageDAO imageDAO = new ImageDAO();
		Image image = new Image();
		try {
			image = imageDAO.findById(id);
		} catch (ClassNotFoundException | SQLException e) {
			//处理异常，打印异常轨迹
			e.printStackTrace();
		}
		return image;
	}


}
