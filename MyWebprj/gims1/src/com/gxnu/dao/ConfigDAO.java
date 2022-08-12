package com.gxnu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
<<<<<<< .mine

||||||| .r33
//import java.util.ArrayList;
//import java.util.List;

=======
import java.util.ArrayList;
import java.util.List;
>>>>>>> .r48
import com.gxnu.entity.Config;

/**
 * 服务器配置
 * @author Administrator
 *
 */
public class ConfigDAO extends C3P0BaseDAO {

	//添加操作
	  public void add(Config config) throws ClassNotFoundException, SQLException {
	  //连接数据库 
	  Connection conn = super.getConnection(); 
		  //添加sql预处理语句
	  PreparedStatement pstmt =
			  conn.prepareStatement("insert into config(version,ip,port) values(?,?,?)");
	  //给占位符填充数据 
	  pstmt.setString(1, config.getVersion()); pstmt.setString(2,
	  config.getIp()); pstmt.setInt(3, config.getPort()); //执行
	  pstmt.executeUpdate(); //关闭连接
	  super.closeConnection(conn); 
	  }
	  
	 


    public void modify(Config config) throws ClassNotFoundException, SQLException {
        Connection conn = super.getConnection();
        PreparedStatement pstmt =
                conn.prepareStatement("update config set version=?,ip=?,port=? where id=?");
        pstmt.setInt(4, config.getId());
        pstmt.setString(1, config.getVersion());
        pstmt.setString(2, config.getIp());
        pstmt.setInt(3, config.getPort());
        pstmt.executeUpdate();
        super.closeConnection(conn);
    }


    public void delete(Config config) throws ClassNotFoundException, SQLException {
		//删除操作
        Connection conn = super.getConnection();
        PreparedStatement pstmt =
                conn.prepareStatement("delete from config where id=?");
        pstmt.setInt(1, config.getId());
        pstmt.executeUpdate();
        super.closeConnection(conn);
    }
    
    /**
     * 服务器的查询
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
<<<<<<< .mine
	
	  public Config find() throws ClassNotFoundException, SQLException {
	  
	  Config config = new Config(); 
	  Connection conn = super.getConnection();
	  
	  PreparedStatement pstmt = conn.prepareStatement("select * from config");//limit 1
	  
	  ResultSet rs = pstmt.executeQuery();
	  
	  
	  while (rs.next()) {
	  
	  config = new Config(rs.getInt("id"), rs.getInt("port"),rs.getString("ip"),rs.getString("version")); }
	 
	  super.closeConnection(conn); 
	  return config; 
	  }
||||||| .r33
	/*
	 * public List<Config> findAll() throws ClassNotFoundException, SQLException {
	 * 
	 * List<Config> configs = new ArrayList<Config>(); Connection conn =
	 * super.getConnection();
	 * 
	 * PreparedStatement pstmt = conn.prepareStatement("select * from config");
	 * 
	 * ResultSet rs = pstmt.executeQuery();
	 * 
	 * 
	 * while (rs.next()) {
	 * 
	 * configs.add(new Config(rs.getInt("id"),
	 * rs.getInt("port"),rs.getString("version"), rs.getString("ip"))); }
	 * 
	 * super.closeConnection(conn); return configs; }
	 */
=======
	
	  public List<Config> find() throws ClassNotFoundException, SQLException {
	  
	  List<Config> configs = new ArrayList<Config>(); 
	  Connection conn = super.getConnection();
	  
	  PreparedStatement pstmt = conn.prepareStatement("select * from config");
	  
	  ResultSet rs = pstmt.executeQuery();
	  
	  while (rs.next()) {
	  
	  configs.add(new Config(rs.getInt("id"), rs.getInt("port"),rs.getString("ip"),rs.getString("version"))); }
	 
	  super.closeConnection(conn); 
	  return configs; 
	  }
>>>>>>> .r48

	public Config find(int ID) throws SQLException, ClassNotFoundException {
		Connection conn = super.getConnection();
		 Config config = new Config();
        PreparedStatement pstmt =
                conn.prepareStatement("select * from config where id=?");
        pstmt.setInt(1, ID);
        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            int id = rs.getInt("id"); 
            String ip = rs.getString("ip");
            int port = rs.getInt("port");
            String version = rs.getString("version"); 
            config = new Config(id,port, ip,version); 
        }

        super.closeConnection(conn);
		return config;
	}

}


