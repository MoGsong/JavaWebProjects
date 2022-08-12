package com.gxnu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gxnu.entity.Measure;
/**
 * 角色表的CURD操作
 * @author johny
 * 持久层类
 */
public class MeasureDAO extends C3P0BaseDAO {
	/**
	 * 添加角色
	 * @param measure 表示待添加的角色信息，形如：{id=1,name=访客}
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public void add(Measure measure) throws ClassNotFoundException, SQLException {
		//1、加载驱动 2、连接rbacpro数据库
		Connection conn = super.getConnection();
		//3、基于数据库连接对象 java.sql.Connection,创建数据库操作对象java.sql.PreparedStatement，须绑定一个SQL语句
		//此处的？表示“占位符”，下标从1开始递增，须在后续设置其值
		PreparedStatement pstmt = 
				conn.prepareStatement("insert into measure(name) values(?)");
		//设置点位符的值,注意数据类型的选择
		pstmt.setString(1,measure.getName());
		//执行SQL语句,结果会同步到mysql表中
		pstmt.executeUpdate();
		//关闭数据库连接
		super.closeConnection(conn);
	}
	/**
	 * 修改角色
	 * @param measure 表示修改后的角色信息，形如：{id=3,name=超管}
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public void merge(Measure measure) throws ClassNotFoundException, SQLException {
		//1、加载驱动 2、连接rbacpro数据库
		Connection conn = super.getConnection();
		//3、基于数据库连接对象 java.sql.Connection,创建数据库操作对象java.sql.PreparedStatement，须绑定一个SQL语句
		//此处的？表示“占位符”，下标从1开始递增，须在后续设置其值
		PreparedStatement pstmt = 
				conn.prepareStatement("update measure set name=? where id=?");
		//设置点位符的值,注意数据类型的选择
		pstmt.setString(1,measure.getName());
		pstmt.setInt(2, measure.getId());
		//执行SQL语句,结果会同步到mysql表中
		pstmt.executeUpdate();
		//关闭数据库连接
		super.closeConnection(conn);
	}
	
	/**
	 * 删除角色
	 * @param measure 表示删除的角色信息，形如：{id=3,name=null}
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public void delete(int id) throws ClassNotFoundException, SQLException {
		//1、加载驱动 2、连接rbacpro数据库
		Connection conn = super.getConnection();
		//3、基于数据库连接对象 java.sql.Connection,创建数据库操作对象java.sql.PreparedStatement，须绑定一个SQL语句
		//此处的？表示“占位符”，下标从1开始递增，须在后续设置其值
		PreparedStatement pstmt = 
				conn.prepareStatement("delete from measure where id=?");
		//设置点位符的值,注意数据类型的选择
		pstmt.setInt(1, id);
		//执行SQL语句,结果会同步到mysql表中
		pstmt.executeUpdate();
		//关闭数据库连接
		super.closeConnection(conn);
	}

	/**
	 * 查询角色，查所有
	 * @return 把结果集中的所有记录，包装成measure对象，再存放到数组中
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	//public Measure[] findAll() throws ClassNotFoundException, SQLException {
	public List<Measure> findAll() throws ClassNotFoundException, SQLException {
		//定义数组
		//Measure[] measures = new Measure[findTotal()]; //默认每个元素均为null
		List<Measure> measures = new ArrayList<Measure>(); 
		//int i = 0;
		//1、加载驱动 2、连接rbacpro数据库
		Connection conn = super.getConnection();
		//3、基于数据库连接对象 java.sql.Connection,创建数据库操作对象java.sql.PreparedStatement，须绑定一个SQL语句
		//此处的？表示“占位符”，下标从1开始递增，须在后续设置其值
		PreparedStatement pstmt = conn.prepareStatement("select * from measure");
		//4、基于数据操作对象java.sql.PreparedStatement，创建数据库结果集对象java.sql.ResultSet
		ResultSet rs = pstmt.executeQuery();
		
		//通过循环遍历结果集
		while(rs.next()) {
			//每循环一次，获取指针定位的某条记录上的数据
			/*
			int id = rs.getInt("id");  //id为字段名称 
			String name = rs.getString("name"); //name为字段名称
			Measure measure = new Measure(id, name); //把数据包装成Measure实体对象
			measures[i] = measure;
			i++;
			*/
			
			//measures[i++] = new Measure(rs.getInt("id"), rs.getString("name"));
			measures.add(new Measure(rs.getInt("id"), rs.getString("name")));
		}
		//返回数组
		return measures;
	}
	
	/**
	 * 查询角色，查单个
	 * @return 把结果集中的所有记录，包装成measure对象，再存放到数组中
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Measure findById(int id) throws ClassNotFoundException, SQLException {
		Measure measure = new Measure();
		//1、加载驱动 2、连接rbacpro数据库
		Connection conn = super.getConnection();
		//3、基于数据库连接对象 java.sql.Connection,创建数据库操作对象java.sql.PreparedStatement，须绑定一个SQL语句
		//此处的？表示“占位符”，下标从1开始递增，须在后续设置其值
		PreparedStatement pstmt = conn.prepareStatement("select * from measure where id=?");
		pstmt.setInt(1,id);
		//4、基于数据操作对象java.sql.PreparedStatement，创建数据库结果集对象java.sql.ResultSet
		ResultSet rs = pstmt.executeQuery();
		
		//因为结果集中只有一条记录，无需循环遍历结果集，只需要让指针移动一次即可
		if(rs.next()) {
			//每循环一次，获取指针定位的某条记录上的数据
			int measureid = rs.getInt("id");  //id为字段名称 
			String name = rs.getString("name"); //name为字段名称
			measure = new Measure(measureid, name); //把数据包装成Measure实体对象
		}
		//返回数组
		return measure;
	}
	
}
