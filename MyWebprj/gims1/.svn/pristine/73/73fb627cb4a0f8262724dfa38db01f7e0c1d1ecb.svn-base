package com.gxnu.dao;

import com.gxnu.entity.Guide;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 引导图片表的CURD操作
 */
public class GuideDao extends C3P0BaseDAO {
    /**
     * @param guide 待添加图片{"name""URL"}
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void add(Guide guide) throws SQLException, ClassNotFoundException {
        Connection conn = super.getConnection();//连接数据库
        PreparedStatement pstmt = conn.prepareStatement("insert into guide(name,URL) values (?,?)");//写入sql语句
        pstmt.setString(1, guide.getName());
        pstmt.setString(2, guide.getURL());//设置值,1表示第一个问号
        pstmt.executeUpdate();//执行sql语句
        super.closeConnection(conn);//关闭数据库
    }

    /**
     * @param guide 待删除图片{id}
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void delete(Guide guide) throws SQLException, ClassNotFoundException {
        Connection conn = super.getConnection();
        PreparedStatement pstmt = conn.prepareStatement("delete from guide where id = ? ");
        pstmt.setInt(1, guide.getId());
        pstmt.executeUpdate();
        super.closeConnection(conn);
    }

    /**
     * @param guide 待修改图片{id,"name"}
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void update(Guide guide) throws SQLException, ClassNotFoundException {
        Connection conn = super.getConnection();
        PreparedStatement pstmt = conn.prepareStatement("update guide set name =  ? ,URL=? where id = ? ");
        pstmt.setString(1, guide.getName());
        pstmt.setString(2, guide.getURL());
        pstmt.setInt(3, guide.getId());
        pstmt.executeUpdate();
        super.closeConnection(conn);
    }

    /**
         * 查询所有图片
     * @param
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<Guide> select() throws SQLException, ClassNotFoundException {
    	
        List<Guide> guides = new ArrayList<Guide>();
        int i = 0;
        Connection conn = super.getConnection();
        PreparedStatement pstmt = conn.prepareStatement("select * from guide");
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            guides.add( new Guide(rs.getInt("id"), rs.getString("name"),rs.getString("URL")));
        }
        return guides;
    }

    /**
     * 查询单个图片
     *
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public Guide selectOne(int id) throws ClassNotFoundException, SQLException {
        Guide guide = new Guide();
        Connection conn = super.getConnection();
        PreparedStatement pstmt = conn.prepareStatement("select * from guide where id = ?");
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            guide = new Guide(rs.getInt("id"), rs.getString("name"),rs.getString("URL"));
        }
        return guide;
    }

//    private int total() throws SQLException, ClassNotFoundException {
//        Connection conn = super.getConnection();
//        PreparedStatement pstmt = conn.prepareStatement("select count(*) from guide");
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
