package com.gxnu.service;

import java.util.List;

import com.gxnu.entity.Picture;

/**
 * 图片管理对应的接口
 * @author hjj
 *
 */
public interface IPictureService {
	//添加图片
	public void add(Picture picture);
	//删除照片
	public void remove(int id);
	//修改照片
	public void update(Picture picture);
	//查询所有照片
	public List<Picture> findAll();
	//根据id查询单张照片
	public Picture findById(int id);

}
