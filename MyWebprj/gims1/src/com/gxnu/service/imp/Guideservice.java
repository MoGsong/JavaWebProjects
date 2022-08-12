package com.gxnu.service.imp;

import com.gxnu.*;
import com.gxnu.dao.GuideDao;
import com.gxnu.entity.Guide;
import com.gxnu.service.IGuideservice;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Guideservice implements IGuideservice {

    @Override
    public void add(Guide guide) {
        //创建图片
        GuideDao guideDao = new GuideDao();
        try {
            guideDao.add(guide);
        } catch (SQLException throwables) {
            //打印异常轨迹
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(int id) {
        //删除图片
        GuideDao guideDao = new GuideDao();
        Guide guide = new Guide();
        guide.setId(id);
        try {
            guideDao.delete(guide);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Guide guide) {
        //修改图片
        GuideDao guideDao = new GuideDao();
        try {
            guideDao.update(guide);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Guide find(int id) {
        //查询单个图片
        GuideDao guideDao = new GuideDao();
        Guide guide = new Guide();
        try {
            guide = guideDao.selectOne(id);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return guide;
    }

    @Override
    public List<Guide> find() {
        //查询所有图片
        GuideDao guideDao = new GuideDao();
        List<Guide> guides = new ArrayList<Guide>();
        try {
            guides = guideDao.select();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return guides;
    }
}
