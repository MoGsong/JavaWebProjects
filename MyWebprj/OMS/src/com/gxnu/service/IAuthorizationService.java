package com.gxnu.service;

import java.util.List;

import com.gxnu.entity.Authorization;

public interface IAuthorizationService {
    //??????
    void add(Authorization authorization);

    //??????
    void remove(int id);

    //??????
    void update(Authorization authorization);

    //???????????
    Authorization find(int id);

    //???????????
    List<Authorization> find();
   //getting  authorization whole role info
    List<Authorization> findByRole(int roleId);
}
