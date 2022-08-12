package com.gxnu.service.imp;

import com.gxnu.service.IAuthorizationservice;
import com.gxnu.dao.AuthorizationDao;
import com.gxnu.entity.Authorization;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Authorizationservice implements IAuthorizationservice {

    @Override
    public void add(Authorization authorization) {
        //创建权限
        AuthorizationDao authorizationDao = new AuthorizationDao();
        try {
            authorizationDao.add(authorization);
        } catch (SQLException throwables) {
            //打印异常轨迹
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(int id) {
        //删除权限
        AuthorizationDao authorizationDao = new AuthorizationDao();
        Authorization authorization = new Authorization();
        authorization.setId(id);
        try {
            authorizationDao.delete(authorization);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Authorization authorization) {
        //修改权限
        AuthorizationDao authorizationDao = new AuthorizationDao();
        try {
            authorizationDao.update(authorization);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Authorization find(int id) {
        //查询单个权限
        AuthorizationDao authorizationDao = new AuthorizationDao();
        Authorization authorization = new Authorization();
        try {
            authorization = authorizationDao.selectOne(id);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return authorization;
    }

    @Override
    public List<Authorization> find() {
        //查询所有权限
        AuthorizationDao authorizationDao = new AuthorizationDao();
        List<Authorization> authorizations = new ArrayList<Authorization>();
        try {
            authorizations = authorizationDao.select();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return authorizations;
    }

    @Override
    public List<Authorization> findbyRloe(int roleID) {
        AuthorizationDao authorizationDao = new AuthorizationDao();
       List<Authorization> authorizations = new ArrayList<Authorization>();
        try {
            authorizations = authorizationDao.select(roleID);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return authorizations;
    }
}
