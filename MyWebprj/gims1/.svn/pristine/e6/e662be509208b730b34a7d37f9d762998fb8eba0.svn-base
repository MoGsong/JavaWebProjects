package com.gxnu.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gxnu.entity.Rss;


/**
 * RSS表的CURD操作
 * @author xx
 *持久层
 */
public class RssDAO extends C3P0BaseDAO {
	
	/**
	 * 添加RSS
	 * @param rss 表示待添加的Rss信息{id = 1 , name = 访客}
	 * @throws SQLEception
	 * @throws ClassNotFoundException
	 */
	public void add(Rss rss) throws ClassNotFoundException,SQLException {
//		1加载驱动  2链接rbac数据库
		Connection conn = super.getConnection();
//		3基于数据库链接对象Java.sql.Connection,创建数据库操作对象java.sql.PreparedStatement，须绑定一个SQL语句
//		此处的？表示“占位符”，下标从1开始递增
		PreparedStatement pstmt = conn.prepareStatement("insert into rss(title,url,content,updatetime) values(?,?,?,?)");
//		设置点位符的值，注意数据类型的选择
		pstmt.setString(1,rss.getTitle());
		pstmt.setString(2,rss.getUrl());
		pstmt.setString(3,rss.getContent());
		pstmt.setString(4,rss.getUpdatetime());
//		执行SQL语句，结果会同步到mysql表中
		pstmt.executeUpdate();
//		关闭数据库链接
		super.closeConnection(conn);
	  }	

	/**
	 * 修改RSS
	 * @param rss 表示修改后的RSS信息，形如：{id=3,name=超管}
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
		public void merge(Rss rss) throws ClassNotFoundException, SQLException {
		//1、加载驱动 2、连接rbac数据库
		Connection conn = super.getConnection();
		//3、基于数据库连接对象 java.sql.Connection,创建数据库操作对象java.sql.PreparedStatement，须绑定一个SQL语句
		//此处的？表示“占位符”，下标从1开始递增，须在后续设置其值
    	PreparedStatement pstmt = 
				conn.prepareStatement("update rss set titler=?,url=?,content=?,updatetime=? where id=?");
		//设置点位符的值,注意数据类型的选择
    	pstmt.setString(1,rss.getTitle());
		pstmt.setString(2,rss.getUrl());
		pstmt.setString(3,rss.getContent());
		pstmt.setString(4,rss.getUpdatetime());
		pstmt.setInt(5,rss.getId());
		//执行SQL语句,结果会同步到mysql表中
		pstmt.executeUpdate();
		//关闭数据库连接
		super.closeConnection(conn);
	}

	/**
	 * 删除RSS
	 * delete
	 * @param rss 表示修改后的RSS信息，形如：{id=3,name=超管}
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public void delete(Rss rss) throws ClassNotFoundException, SQLException {
		//1、加载驱动 2、连接rbac数据库
		Connection conn = super.getConnection();
		//3、基于数据库连接对象 java.sql.Connection,创建数据库操作对象java.sql.PreparedStatement，须绑定一个SQL语句
		//此处的？表示“占位符”，下标从1开始递增，须在后续设置其值
		PreparedStatement pstmt = 
				conn.prepareStatement("delete from rss where id=?");
		//设置点位符的值,注意数据类型的选择
		pstmt.setInt(1, rss.getId());
		//执行SQL语句,结果会同步到mysql表中
		pstmt.executeUpdate();
		//关闭数据库连接
		super.closeConnection(conn);
	}

   /**
         * 查询RSS，查所有
     * findAll
     */
	public List<Rss> findAll() throws ClassNotFoundException, SQLException {
		////定义数组
		List<Rss> rsss = new ArrayList<Rss>();//默认每个元素都为null
		int i = 0;
		//1、加载驱动 2、连接rbac数据库
		Connection conn = super.getConnection();
		//3、基于数据库连接对象 java.sql.Connection,创建数据库操作对象java.sql.PreparedStatement，须绑定一个SQL语句
		PreparedStatement pstmt = conn.prepareStatement("select * from rss");
		//基于数据操作对象Java.sql.PreparedSatement,创建数据库结果集对象java.sql.ResultSet
		ResultSet rs = pstmt.executeQuery();
		//通过循环遍历结果集
		while(rs.next()) {
			//每循环一次，获取指针定位的记录上的数据
			/*
			int id = rs.getInt("id");//id为字段名称
			String name = rs.getString("name");//name为字段名称
			Rss rss = new Rss(id, name);//把数据包装成Rss实体对象
			rsss[i] = rss;
			i++;
			*/
			rsss.add(new Rss(rs.getInt("id"),rs.getString("title"),rs.getString("url"),
					rs.getString("content"),rs.getString("updatetime")));
		}
		//返回数组
		return rsss;
}
		
	/**
	 * 查询RSS，查单个
	 * @return 把结果集中的所有记录，包装成rss对象，再存放到数组中
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Rss findByPrimaryKey(int id) throws ClassNotFoundException, SQLException {
		Rss rss = new Rss();
		//1、加载驱动 2、连接rbac数据库
		Connection conn = super.getConnection();
		//3、基于数据库连接对象 java.sql.Connection,创建数据库操作对象java.sql.PreparedStatement，须绑定一个SQL语句
		//此处的？表示“占位符”，下标从1开始递增，须在后续设置其值
		PreparedStatement pstmt = conn.prepareStatement("select * from rss where id=?");
		pstmt.setInt(1,id);
		//4、基于数据操作对象java.sql.PreparedStatement，创建数据库结果集对象java.sql.ResultSet
		ResultSet rs = pstmt.executeQuery();
		
		//因为结果集中只有一条记录，无需循环遍历结果集，只需要让指针移动一次即可
		if(rs.next()) {
		rss =	new Rss(rs.getInt("id"),rs.getString("title"),rs.getString("url"),
				rs.getString("content"),rs.getString("updatetime"));
			
		}
		//返回数组
		return rss;
	}
	
	/**
	 * 查询分页记录
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<Rss> findAll(int currentPage,int pageSize) throws ClassNotFoundException, SQLException {
		//PageBean[] emailInfos = new PageBean[findTotal()]; //创建数组，用于存放所查询所有的角色对象,findTotal()根据表的数据条数创建相应的数组空间
		List<Rss> rsss = new ArrayList<Rss>();
		//int i=0;
		Connection conn = super.getConnection();
		PreparedStatement pstmt =conn.prepareStatement("select * from rss order by id limit ?,? ");
		pstmt.setInt(1, (currentPage-1)*pageSize);
		pstmt.setInt(2, pageSize);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			/*
			int emailInfoid = rs.getInt("id");//其中id为结果集字段名称
			String emailInfoname = rs.getString("name");//其中name为结果集字段名称
			PageBean emailInfo = new PageBean(emailInfoid,emailInfoname);  //把指针当前定位的记录信息存放到角色实体对象中
			emailInfos[i]=emailInfo; //把实体对象存放到数组
			i++;
			*/
			rsss.add(new Rss(rs.getInt("id"),rs.getString("title"),rs.getString("url"),
					rs.getString("content"),rs.getString("updatetime")));
		}
		super.closeConnection(conn);
		return rsss;
	}
}