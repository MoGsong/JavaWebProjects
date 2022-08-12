package com.gxnu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gxnu.entity.lnformation;
import com.gxnu.entity.Role;

/**
 * 民俗信息表的CURD
 * 
 * @author johny
 */
public class lnformationDAO extends C3P0BaseDAO {
	private lnformation information;
	/**
	 * 添加民俗信息
	 * 
	 * @param information 待添加的民俗信息信息{2,访客}
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void add(lnformation information) throws ClassNotFoundException, SQLException {
		// 1、加载驱动，2、连接数据库rbac
		Connection conn = super.getConnection();
		// 3、使用子类java.sql.PreparedStatement实现添加操作,
		// 基于数据库连接对象 conn，获取一个数据库操作对象pstmt,
		// 并绑定一条sql语句,sql语句中的？表示“占位符”，下标从1开始递增，须在后续设置具体值
		PreparedStatement pstmt = conn.prepareStatement("insert into information (types,content,picture,time,yuliu) values(?,?,?,?,?)");
		// 设置占位符的值

		pstmt.setString(1, information.getTypes()); // “导航链”,一个对象获取关联对象的详细信息
		pstmt.setString(2, information.getContent());
		pstmt.setString(3, information.getPicture());
		pstmt.setTimestamp(4, information.getTime());
		pstmt.setString(5, information.getYuliu());

		// 执行sql语句，同步到mysql表
		pstmt.executeUpdate();
		// 4、关闭数据库连接
		super.closeConnection(conn);
	}

	/**
	 * 修改民俗信息
	 * 
	 * @param information 修改后的数据
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void merge(lnformation information) throws ClassNotFoundException, SQLException {
		// 1、加载驱动，2、连接数据库rbac
		Connection conn = super.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("update information set types=?,content=?,picture=?,time=?,yuliu=? where id=?");
		// 注意点位符的类型和个数

		pstmt.setString(1, information.getTypes()); // “导航链”,一个对象获取关联对象的详细信息
		pstmt.setString(2, information.getContent());
		pstmt.setString(3, information.getPicture());
		pstmt.setTimestamp(4, information.getTime());
		pstmt.setString(5, information.getYuliu());
		pstmt.setInt(6, information.getId());
		// 执行sql语句，同步到mysql表
				pstmt.executeUpdate();
				// 4、关闭数据库连接
				super.closeConnection(conn);
	}

	/**
	 * 删除民俗信息
	 * @param information 表示删除的操作员信息，形如：{id=3,name=null}
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public void delete(lnformation information) throws ClassNotFoundException, SQLException {
		//1、加载驱动 2、连接rbacpro数据库
		Connection conn = super.getConnection();
		//3、基于数据库连接对象 java.sql.Connection,创建数据库操作对象java.sql.PreparedStatement，须绑定一个SQL语句
		//此处的？表示“占位符”，下标从1开始递增，须在后续设置其值
		PreparedStatement pstmt = 
				conn.prepareStatement("delete from information where id=?");
		//设置点位符的值,注意数据类型的选择
		pstmt.setInt(1, information.getId());
		//执行SQL语句,结果会同步到mysql表中
		pstmt.executeUpdate();
		//关闭数据库连接
		super.closeConnection(conn);
	}
	

	/**
	 * 查询角色，查单个
	 * @return 把结果集中的所有记录，包装成information对象，再存放到数组中
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public lnformation findByPrimaryKey(int id) throws ClassNotFoundException, SQLException {
		lnformation information = new lnformation();
		//1、加载驱动 2、连接rbacpro数据库
		Connection conn = super.getConnection();
		//3、基于数据库连接对象 java.sql.Connection,创建数据库操作对象java.sql.PreparedStatement，须绑定一个SQL语句
		//此处的？表示“占位符”，下标从1开始递增，须在后续设置其值
		PreparedStatement pstmt = conn.prepareStatement("select * from information where id=?");
		pstmt.setInt(1,id);
		//4、基于数据操作对象java.sql.PreparedStatement，创建数据库结果集对象java.sql.ResultSet
		ResultSet rs = pstmt.executeQuery();
		
		//因为结果集中只有一条记录，无需循环遍历结果集，只需要让指针移动一次即可
		if(rs.next()) {
			//每循环一次，获取指针定位的某条记录上的数据
			information = new lnformation(rs.getInt("id"), rs.getString("types"),
					rs.getString("picture"), rs.getTimestamp("time"), rs.getString("yuliu"));
		}
		//返回数组
		return information;

	}

	/**
	 * 查询角色，查所有
	 * @return 把结果集中的所有记录，包装成information对象，再存放到数组中
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	//public lnformation[] findAll() throws ClassNotFoundException, SQLException {
	public List<lnformation> findAll() throws ClassNotFoundException, SQLException {
		//定义数组
		//lnformation[] informations = new lnformation[findTotal()]; //默认每个元素均为null
		List<lnformation> informations = new ArrayList<lnformation>(); 
		//int i = 0;
		//1、加载驱动 2、连接rbacpro数据库
		Connection conn = super.getConnection();
		//3、基于数据库连接对象 java.sql.Connection,创建数据库操作对象java.sql.PreparedStatement，须绑定一个SQL语句
		//此处的？表示“占位符”，下标从1开始递增，须在后续设置其值
		PreparedStatement pstmt = conn.prepareStatement("select * from information");
		//4、基于数据操作对象java.sql.PreparedStatement，创建数据库结果集对象java.sql.ResultSet
		ResultSet rs = pstmt.executeQuery();
		
		//通过循环遍历结果集
		while(rs.next()) {
			//每循环一次，获取指针定位的某条记录上的数据
			/*
			int id = rs.getInt("id");  //id为字段名称 
			String name = rs.getString("name"); //name为字段名称
			lnformation information = new lnformation(id, name); //把数据包装成lnformation实体对象
			informations[i] = information;
			i++;
			*/			
			//informations[i++] = new lnformation(rs.getInt("id"), rs.getString("name"));
			information = new lnformation(rs.getInt("id"), rs.getString("types"),
					rs.getString("picture"), rs.getTimestamp("time"), rs.getString("yuliu"));
		}
		//返回数组
		return informations;
	
	}
	// 查询民俗信息表中的所有记录总条数
	private int findTotal(int roleid) throws ClassNotFoundException, SQLException {
		int total = 0;
		// 1、加载驱动，2、连接数据库rbac
		Connection conn = super.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("select count(*) from information where role=?");
		pstmt.setInt(1, roleid);
		// 4、根据数据操作对象获取结果集对象，结果集对象存放了所有查询到的记录
		ResultSet rs = pstmt.executeQuery();
		// 因为结果集只有一条记录，无需循环
		if (rs.next()) {
			total = rs.getInt(1); // 此处使用字段对应的序号，作用同 rs.getInt("count(*)")
		}
		return total;
	}
}
