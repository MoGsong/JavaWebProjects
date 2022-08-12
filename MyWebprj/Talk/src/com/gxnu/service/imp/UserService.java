package com.gxnu.service.imp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.gxnu.dao.UserDAO;
import com.gxnu.entity.User;
import com.gxnu.service.IUserService;

public class UserService implements IUserService{

	@Override
	public void add(User user) {
		UserDAO userDAO = new UserDAO();
        try {
            userDAO.add(user);
        } catch (SQLException throwables) {
            //打印异常轨迹
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
		
	}

	@Override
	public void remove(int id) {
		UserDAO userDAO = new UserDAO();
		User user = new User();
	    user.setId(id);
        try {
            userDAO.delete(user);;
        } catch (SQLException throwables) {
            //打印异常轨迹
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
		
	}

	@Override
	public void update(User user) {
		UserDAO userDAO = new UserDAO();
        try {
            userDAO.update(user);
        } catch (SQLException throwables) {
            //打印异常轨迹
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
		
	}

	@Override
	public User findById(int id) {
		UserDAO userDAO = new UserDAO();
		User user = new User();
        try {
        	user = userDAO.findById(id);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
		
	}

	@Override
	public List<User> find() {
		UserDAO userDAO = new UserDAO();
        List<User> users = new ArrayList<User>();
        try {
        	users = userDAO.find();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
		return users;
	}

}
