package com.gxnu.service;

import java.util.List;

import com.gxnu.entity.Authorization;

/**
 * 业务层权限功能接口
 */
public interface IAuthorizationservice {
    //权限添加
    public void add(Authorization authorization);

    //权限删除
    public void remove(int id);

    //权限修改
    public void update(Authorization authorization);

    //查询单个权限
    public Authorization find(int id);

    //查询所有权限
    public List<Authorization> find();

    public List<Authorization> findbyRloe(int roleID);
}
