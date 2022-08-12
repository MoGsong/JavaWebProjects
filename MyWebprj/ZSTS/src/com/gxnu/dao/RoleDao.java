package com.gxnu.dao;

import com.gxnu.entity.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 角色表的CURD操作
 */
public class RoleDao extends C3P0BaseDAO {
    /**
     * @param role 待添加角色{"name"}
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void add(Role role) throws SQLException, ClassNotFoundException {
        Connection conn = super.getConnection();//连接数据库
        PreparedStatement pstmt = conn.prepareStatement("insert into role(name,yuliu) values (?,?)");//写入sql语句
        pstmt.setString(1, role.getName());//设置值,1表示第一个问号
        pstmt.setString(2, role.getYuliu());
        pstmt.executeUpdate();//执行sql语句
        super.closeConnection(conn);//关闭数据库
    }

    /**
     * @param role 待删除角色{id}
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void delete(Role role) throws SQLException, ClassNotFoundException {
        Connection conn = super.getConnection();
        PreparedStatement pstmt = conn.prepareStatement("delete from role where id = ? ");
        pstmt.setInt(1, role.getId());
        pstmt.executeUpdate();
        super.closeConnection(conn);
    }

    /**
     * @param role 待修改角色{id,"name"}
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void update(Role role) throws SQLException, ClassNotFoundException {
        Connection conn = super.getConnection();
        PreparedStatement pstmt = conn.prepareStatement("update role set name = ?, yuliu = ? where id = ? ");
        pstmt.setString(1, role.getName());
        pstmt.setString(2, role.getYuliu());
        pstmt.setInt(3, role.getId());
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
    public List<Role> select() throws SQLException, ClassNotFoundException {
        List<Role> roles = new ArrayList<Role>();
        int i = 0;
        Connection conn = super.getConnection();
        PreparedStatement pstmt = conn.prepareStatement("select * from role");
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            roles.add( new Role(rs.getInt("id"), rs.getString("name"),rs.getString("yuliu")));
        }
        return roles;
    }

    /**
     * 查询单个角色
     *
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public Role selectOne(int id) throws ClassNotFoundException, SQLException {
        Role role = new Role();
        Connection conn = super.getConnection();
        PreparedStatement pstmt = conn.prepareStatement("select * from role where id = ?");
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            role = new Role(rs.getInt("id"), rs.getString("name"),rs.getString("yuliu"));
        }
        return role;
    }

//    private int total() throws SQLException, ClassNotFoundException {
//        Connection conn = super.getConnection();
//        PreparedStatement pstmt = conn.prepareStatement("select count(*) from role");
//        ResultSet rs = pstmt.executeQuery();
//        int total = 0;
//        ResultSet count = pstmt.executeQuery();
//
//        if (count.next()) {
//            total = count.getInt("count(*)");
//        }
//        return total;
//    }
}