package com.gxnu.service.imp;

import com.gxnu.service.IRoleService;
import com.gxnu.dao.RoleDao;
import com.gxnu.entity.Role;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Roleservice implements IRoleService {

    @Override
    public void add(Role role) {
        //创建角色
        RoleDao roleDao = new RoleDao();
        try {
            roleDao.add(role);
        } catch (SQLException throwables) {
            //打印异常轨迹
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(int id) {
        //删除角色
        RoleDao roleDao = new RoleDao();
        Role role = new Role();
        role.setId(id);
        try {
            roleDao.delete(role);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Role role) {
        //修改角色
        RoleDao roleDao = new RoleDao();
        try {
            roleDao.update(role);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Role find(int id) {
        //查询单个角色
        RoleDao roleDao = new RoleDao();
        Role role = new Role();
        try {
            role = roleDao.selectOne(id);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return role;
    }

    @Override
    public List<Role> find() {
        //查询所有角色
        RoleDao roleDao = new RoleDao();
        List<Role> roles = new ArrayList<Role>();
        try {
            roles = roleDao.select();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return roles;
    }
}
