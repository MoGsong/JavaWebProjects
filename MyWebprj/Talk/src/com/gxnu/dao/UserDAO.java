package com.gxnu.dao;


import com.gxnu.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 角色表的CURD操作
 */
public class UserDAO extends C3P0BaseDAO {
    /**
     * @param user 待添加角色{"name"}
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void add(User user) throws SQLException, ClassNotFoundException {
        Connection conn = super.getConnection();//连接数据库
        PreparedStatement pstmt = conn.prepareStatement("insert into user(name) values (?)");//写入sql语句
        pstmt.setString(1, user.getName());//设置值,1表示第一个问号
        pstmt.executeUpdate();//执行sql语句
        super.closeConnection(conn);//关闭数据库
    }

    /**
     * @param user 待删除角色{id}
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void delete(User user) throws SQLException, ClassNotFoundException {
        Connection conn = super.getConnection();
        PreparedStatement pstmt = conn.prepareStatement("delete from user where id = ? ");
        pstmt.setInt(1, user.getId());
        pstmt.executeUpdate();
        super.closeConnection(conn);
    }

    /**
     * @param user 待修改角色{id,"name"}
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void update(User user) throws SQLException, ClassNotFoundException {
        Connection conn = super.getConnection();
        PreparedStatement pstmt = conn.prepareStatement("update user set name = ? where id = ? ");
        pstmt.setString(1, user.getName());
        pstmt.setInt(2, user.getId());
        pstmt.executeUpdate();
        super.closeConnection(conn);
    }

    /**
     * 查询所有角色
     *
     * @param
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<User> find() throws SQLException, ClassNotFoundException {
        List<User> users = new ArrayList<User>();
        Connection conn = super.getConnection();
        PreparedStatement pstmt = conn.prepareStatement("select * from user");
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            users.add( new User(rs.getInt("id"), rs.getString("name")));
        }
        return users;
    }

    /**
     * 查询单个角色
     *
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public User findById(int id) throws ClassNotFoundException, SQLException {
        User user = new User();
        Connection conn = super.getConnection();
        PreparedStatement pstmt = conn.prepareStatement("select * from user where id = ?");
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            user = new User(rs.getInt("id"), rs.getString("name"));
        }
        return user;
    }


}