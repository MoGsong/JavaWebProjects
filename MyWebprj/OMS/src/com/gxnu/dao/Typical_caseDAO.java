package com.gxnu.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gxnu.entity.Typical_case;


/**
 * Typical_case表的CURD操作
 * @author xx
 *持久层
 */
public class Typical_caseDAO extends C3P0BaseDAO {
	
	/**
	 * 添加Typical_case
	 * @param typical_case 表示待添加的Typical_case信息{id = 1 , name = 访客}
	 * @throws SQLEception
	 * @throws ClassNotFoundException
	 */
	public void add(Typical_case typical_case) throws ClassNotFoundException,SQLException {
//		1加载驱动  2链接rbac数据库
		Connection conn = super.getConnection();
//		3基于数据库链接对象Java.sql.Connection,创建数据库操作对象java.sql.PreparedStatement，须绑定一个SQL语句
//		此处的？表示“占位符”，下标从1开始递增
		PreparedStatement pstmt = conn.prepareStatement("insert into typical_case(title,pic,content,date) values(?,?,?,?)");
//		设置点位符的值，注意数据类型的选择
		pstmt.setString(1,typical_case.getTitle());
		
		pstmt.setString(2,typical_case.getPic());
		
		pstmt.setString(3,typical_case.getContent());
				
		pstmt.setTimestamp(4,typical_case.getDate());
		

//		执行SQL语句，结果会同步到mysql表中
		pstmt.executeUpdate();
//		关闭数据库链接
		super.closeConnection(conn);
	  }	

	/**
	 * 修改Typical_case
	 * @param typical_case 表示修改后的Typical_case信息，形如：{id=3,name=超管}
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
		public void merge(Typical_case typical_case) throws ClassNotFoundException, SQLException {
		//1、加载驱动 2、连接rbac数据库
		Connection conn = super.getConnection();
		//3、基于数据库连接对象 java.sql.Connection,创建数据库操作对象java.sql.PreparedStatement，须绑定一个SQL语句
		//此处的？表示“占位符”，下标从1开始递增，须在后续设置其值
    	PreparedStatement pstmt = 
				conn.prepareStatement("update typical_case set title=?,pic=?,content=?,date=? where id=?");
		//设置点位符的值,注意数据类型的选择
		pstmt.setString(1,typical_case.getTitle());
		pstmt.setString(2,typical_case.getPic());
		pstmt.setString(3,typical_case.getContent());
		pstmt.setTimestamp(4,typical_case.getDate());
		pstmt.setInt(5,typical_case.getId());

		//执行SQL语句,结果会同步到mysql表中
		pstmt.executeUpdate();
		//关闭数据库连接
		super.closeConnection(conn);
	}

	/**
	 * 删除Typical_case
	 * delete
	 * @param typical_case 表示修改后的Typical_case信息，形如：{id=3,name=超管}
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public void delete(Typical_case typical_case) throws ClassNotFoundException, SQLException {
		//1、加载驱动 2、连接rbac数据库
		Connection conn = super.getConnection();
		//3、基于数据库连接对象 java.sql.Connection,创建数据库操作对象java.sql.PreparedStatement，须绑定一个SQL语句
		//此处的？表示“占位符”，下标从1开始递增，须在后续设置其值
		PreparedStatement pstmt = 
				conn.prepareStatement("delete from typical_case where id=?");
		//设置点位符的值,注意数据类型的选择
		pstmt.setInt(1, typical_case.getId());
		//执行SQL语句,结果会同步到mysql表中
		pstmt.executeUpdate();
		//关闭数据库连接
		super.closeConnection(conn);
	}

   /**
         * 查询Typical_case，查所有
     * findAll
     */
	public List<Typical_case> findAll() throws ClassNotFoundException, SQLException {
		////定义数组
		List<Typical_case> typical_cases = new ArrayList<Typical_case>();//默认每个元素都为null
		int i = 0;
		//1、加载驱动 2、连接rbac数据库
		Connection conn = super.getConnection();
		//3、基于数据库连接对象 java.sql.Connection,创建数据库操作对象java.sql.PreparedStatement，须绑定一个SQL语句
		PreparedStatement pstmt = conn.prepareStatement("select * from typical_case");
		//基于数据操作对象Java.sql.PreparedSatement,创建数据库结果集对象java.sql.ResultSet
		ResultSet rs = pstmt.executeQuery();
		//通过循环遍历结果集
		while(rs.next()) {
			//每循环一次，获取指针定位的记录上的数据
			/*
			int id = rs.getInt("id");//id为字段名称
			String name = rs.getString("name");//name为字段名称
			Typical_case typical_case = new Typical_case(id, name);//把数据包装成Typical_case实体对象
			typical_cases[i] = typical_case;
			i++;
			*/
			typical_cases.add(new Typical_case
					(rs.getInt("id"),
					rs.getString("title"),
					rs.getString("pic"),
					rs.getString("content"),
					rs.getTimestamp("date")
					
					));
		}
		//返回数组
		return typical_cases;
}
		
	/**
	 * 查询Typical_case，查单个
	 * @return 把结果集中的所有记录，包装成typical_case对象，再存放到数组中
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Typical_case findByPrimaryKey(int id) throws ClassNotFoundException, SQLException {
		Typical_case typical_case = new Typical_case();
		//1、加载驱动 2、连接rbac数据库
		Connection conn = super.getConnection();
		//3、基于数据库连接对象 java.sql.Connection,创建数据库操作对象java.sql.PreparedStatement，须绑定一个SQL语句
		//此处的？表示“占位符”，下标从1开始递增，须在后续设置其值
		PreparedStatement pstmt = conn.prepareStatement("select * from typical_case where id=?");
		pstmt.setInt(1,id);
		//4、基于数据操作对象java.sql.PreparedStatement，创建数据库结果集对象java.sql.ResultSet
		ResultSet rs = pstmt.executeQuery();
		
		//因为结果集中只有一条记录，无需循环遍历结果集，只需要让指针移动一次即可
		if(rs.next()) {
		typical_case =	new Typical_case(rs.getInt("id"),rs.getString("title"),rs.getString("pic"),
				rs.getString("content"),rs.getTimestamp("date"));
			
		}
		//返回数组
		return typical_case;
	}
	
	/**
	 * 查询分页记录
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<Typical_case> findAll(int currentPage,int pageSize) throws ClassNotFoundException, SQLException {
		//PageBean[] emailInfos = new PageBean[findTotal()]; //创建数组，用于存放所查询所有的角色对象,findTotal()根据表的数据条数创建相应的数组空间
		List<Typical_case> typical_cases = new ArrayList<Typical_case>();
		//int i=0;
		Connection conn = super.getConnection();
		PreparedStatement pstmt =conn.prepareStatement("select * from typical_case order by id limit ?,? ");
		pstmt.setInt(1, (currentPage-1)*pageSize);
		pstmt.setInt(2, pageSize);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			
			
			typical_cases.add(new Typical_case(rs.getInt("id"),rs.getString("title"),
					rs.getString("pic"),rs.getString("content"),rs.getTimestamp("date")));
		}
		super.closeConnection(conn);
		return typical_cases;
	}
}