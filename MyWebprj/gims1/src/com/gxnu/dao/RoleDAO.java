package com.gxnu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gxnu.entity.Role;
/**
 * 角色表的CURD操作
 * @author johny
 * 持久层类
 */
public class RoleDAO extends C3P0BaseDAO {
	/**
	 * 添加角色
	 * @param role 表示待添加的角色信息，形如：{id=1,name=访客}
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public void add(Role role) throws ClassNotFoundException, SQLException {
		//1、加载驱动 2、连接rbacpro数据库
		Connection conn = super.getConnection();
		//3、基于数据库连接对象 java.sql.Connection,创建数据库操作对象java.sql.PreparedStatement，须绑定一个SQL语句
		//此处的？表示“占位符”，下标从1开始递增，须在后续设置其值
		PreparedStatement pstmt = 
				conn.prepareStatement("insert into role(name) values(?)");
		//设置点位符的值,注意数据类型的选择
		pstmt.setString(1,role.getName());
		//执行SQL语句,结果会同步到mysql表中
		pstmt.executeUpdate();
		//关闭数据库连接
		super.closeConnection(conn);
	}
	/**
	 * 修改角色
	 * @param role 表示修改后的角色信息，形如：{id=3,name=超管}
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public void merge(Role role) throws ClassNotFoundException, SQLException {
		//1、加载驱动 2、连接rbacpro数据库
		Connection conn = super.getConnection();
		//3、基于数据库连接对象 java.sql.Connection,创建数据库操作对象java.sql.PreparedStatement，须绑定一个SQL语句
		//此处的？表示“占位符”，下标从1开始递增，须在后续设置其值
		PreparedStatement pstmt = 
				conn.prepareStatement("update role set name=? where id=?");
		//设置点位符的值,注意数据类型的选择
		pstmt.setString(1,role.getName());
		pstmt.setInt(2, role.getId());
		//执行SQL语句,结果会同步到mysql表中
		pstmt.executeUpdate();
		//关闭数据库连接
		super.closeConnection(conn);
	}
	
	/**
	 * 删除角色
	 * @param role 表示删除的角色信息，形如：{id=3,name=null}
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public void delete(Role role) throws ClassNotFoundException, SQLException {
		//1、加载驱动 2、连接rbacpro数据库
		Connection conn = super.getConnection();
		//3、基于数据库连接对象 java.sql.Connection,创建数据库操作对象java.sql.PreparedStatement，须绑定一个SQL语句
		//此处的？表示“占位符”，下标从1开始递增，须在后续设置其值
		PreparedStatement pstmt = 
				conn.prepareStatement("delete from role where id=?");
		//设置点位符的值,注意数据类型的选择
		pstmt.setInt(1, role.getId());
		//执行SQL语句,结果会同步到mysql表中
		pstmt.executeUpdate();
		//关闭数据库连接
		super.closeConnection(conn);
	}

	/**
	 * 查询角色，查所有
	 * @return 把结果集中的所有记录，包装成role对象，再存放到数组中
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	//public Role[] findAll() throws ClassNotFoundException, SQLException {
	public List<Role> findAll() throws ClassNotFoundException, SQLException {
		//定义数组
		//Role[] roles = new Role[findTotal()]; //默认每个元素均为null
		List<Role> roles = new ArrayList<Role>(); 
		//int i = 0;
		//1、加载驱动 2、连接rbacpro数据库
		Connection conn = super.getConnection();
		//3、基于数据库连接对象 java.sql.Connection,创建数据库操作对象java.sql.PreparedStatement，须绑定一个SQL语句
		//此处的？表示“占位符”，下标从1开始递增，须在后续设置其值
		PreparedStatement pstmt = conn.prepareStatement("select * from role");
		//4、基于数据操作对象java.sql.PreparedStatement，创建数据库结果集对象java.sql.ResultSet
		ResultSet rs = pstmt.executeQuery();
		
		//通过循环遍历结果集
		while(rs.next()) {
			//每循环一次，获取指针定位的某条记录上的数据
			/*
			int id = rs.getInt("id");  //id为字段名称 
			String name = rs.getString("name"); //name为字段名称
			Role role = new Role(id, name); //把数据包装成Role实体对象
			roles[i] = role;
			i++;
			*/
			
			//roles[i++] = new Role(rs.getInt("id"), rs.getString("name"));
			roles.add(new Role(rs.getInt("id"), rs.getString("name")));
		}
		//返回数组
		return roles;
	}
	
	/**
	 * 查询角色，查单个
	 * @return 把结果集中的所有记录，包装成role对象，再存放到数组中
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Role findByPrimaryKey(int id) throws ClassNotFoundException, SQLException {
		Role role = new Role();
		//1、加载驱动 2、连接rbacpro数据库
		Connection conn = super.getConnection();
		//3、基于数据库连接对象 java.sql.Connection,创建数据库操作对象java.sql.PreparedStatement，须绑定一个SQL语句
		//此处的？表示“占位符”，下标从1开始递增，须在后续设置其值
		PreparedStatement pstmt = conn.prepareStatement("select * from role where id=?");
		pstmt.setInt(1,id);
		//4、基于数据操作对象java.sql.PreparedStatement，创建数据库结果集对象java.sql.ResultSet
		ResultSet rs = pstmt.executeQuery();
		
		//因为结果集中只有一条记录，无需循环遍历结果集，只需要让指针移动一次即可
		if(rs.next()) {
			//每循环一次，获取指针定位的某条记录上的数据
			int roleid = rs.getInt("id");  //id为字段名称 
			String name = rs.getString("name"); //name为字段名称
			role = new Role(roleid, name); //把数据包装成Role实体对象
		}
		//返回数组
		return role;
	}
	
	     //查询表中所有记录总条数
	    private int findTotal() throws ClassNotFoundException, SQLException {
		int total =0;
		//1、加载驱动 2、连接rbacpro数据库
		Connection conn = super.getConnection();
	  //3、基于数据库连接对象 java.sql.Connection,创建数据库操作对象java.sql.PreparedStatement，须绑定一个SQL语句
	  //此处的？表示“占位符”，下标从1开始递增，须在后续设置其值
	    PreparedStatement pstmt = conn.prepareStatement("select  count(*) from role");
		//4、基于数据操作对象java.sql.PreparedStatement，创建数据库结果集对象java.sql.ResultSet
		ResultSet rs = pstmt.executeQuery();
		
		//通过循环遍历结果集
		if(rs.next()) {
			//每循环一次，获取指针定位的某条记录上的数据
			total = rs.getInt(1);  // 此处1为字段序号，也可以使用 count(*)为字段名称 
		}
		return total;
	}
}
