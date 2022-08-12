package com.gxnu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gxnu.entity.Authorization;
import com.gxnu.entity.Menu;
import com.gxnu.entity.Role;

/**
 * 权限表的CURD
 * 
 * @author johny
 */
public class AuthorizationDAO extends C3P0BaseDAO {
	/**
	 * 添加权限
	 * 
	 * @param authorization 待添加的权限信息{2,访客}
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void add(Authorization authorization) throws ClassNotFoundException, SQLException {
		// 1、加载驱动，2、连接数据库rbac
		Connection conn = super.getConnection();
		// 3、使用子类java.sql.PreparedStatement实现添加操作,
		// 基于数据库连接对象 conn，获取一个数据库操作对象pstmt,
		// 并绑定一条sql语句,sql语句中的？表示“占位符”，下标从1开始递增，须在后续设置具体值
		PreparedStatement pstmt = conn.prepareStatement("insert into authorization (role,menu) values(?,?)");
		// 设置占位符的值

		pstmt.setInt(1, authorization.getRole().getId()); // “导航链”,一个对象获取关联对象的详细信息
		pstmt.setInt(2, authorization.getMenu().getId());

		// 执行sql语句，同步到mysql表
		pstmt.executeUpdate();
		// 4、关闭数据库连接
		super.closeConnection(conn);
	}

	/**
	 * 修改权限
	 * 
	 * @param authorization 修改后的数据
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void merge(Authorization authorization) throws ClassNotFoundException, SQLException {
		// 1、加载驱动，2、连接数据库rbac
		Connection conn = super.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("update authorization set role=?,menu=? where id=?");
		// 注意点位符的类型和个数

		pstmt.setInt(1, authorization.getRole().getId());// “导航链”,一个对象获取关联对象的详细信息
		pstmt.setInt(2, authorization.getMenu().getId());
		pstmt.setInt(3, authorization.getId());
		pstmt.executeUpdate();
		super.closeConnection(conn);
	}

	/**
	 * 删除权限
	 * 
	 * @param authorization (1,超级管理 员)
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void delete(Authorization authorization) throws ClassNotFoundException, SQLException {
		// 1、加载驱动，2、连接数据库rbac
		Connection conn = super.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("delete from authorization where id=?");
		pstmt.setInt(1, authorization.getId());
		pstmt.executeUpdate();
		super.closeConnection(conn);
	}
	// 查询权限
	// 查询权限

	/**
	 * 查询权限,单个
	 * 
	 * @param id 某个权限的编号
	 * @return 该权限对象
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public Authorization findByPrimaryKey(int id) throws SQLException, ClassNotFoundException {
		Authorization authorization = new Authorization();
		Connection conn = super.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("select * from authorization where id=?");
		pstmt.setInt(1, id);
		// 4、根据数据操作对象获取结果集对象，结果集对象存放了所有查询到的记录
		ResultSet rs = pstmt.executeQuery();
		// 通过next()方法让结果集中的指针向下移动一行，当移动到结果集末尾时，返回false，否则返回true
		if (rs.next()) {
			int authorizationid = rs.getInt("id"); // 其中id为结果集字段名称

			int roleid = rs.getInt("role");
			// 根据权限编号，获取权限对象信息（完整信息）
			RoleDAO roleDAO = new RoleDAO();
			Role role = roleDAO.findByPrimaryKey(roleid);

			int menuid = rs.getInt("menu");
			// 根据权限编号，获取权限对象信息（完整信息）
			MenuDAO menuDAO = new MenuDAO();
			Menu menu = menuDAO.findByPrimaryKey(menuid);

			// 把指针当前定位的记录信息存放到权限实体对象中
			authorization = new Authorization(authorizationid, role, menu);
		}
		super.closeConnection(conn);
		return authorization;
	}

	/**
	 * 查询权限,所有
	 * 
	 * @return 每一条权限信息均会保存在一个权限实体对象中，并且添加到 权限实体数组中
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<Authorization> findAll() throws ClassNotFoundException, SQLException {
		List<Authorization> authorizations = new ArrayList<Authorization>(); // 创建一个数组，用于存放100个权限实体对象
		int i = 0;
		// 1、加载驱动，2、连接数据库rbac
		Connection conn = super.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("select * from authorization");
		// 4、根据数据操作对象获取结果集对象，结果集对象存放了所有查询到的记录
		ResultSet rs = pstmt.executeQuery();
		// 通过next()方法让结果集中的指针向下移动一行，当移动到结果集末尾时，返回false，否则返回true
		while (rs.next()) {

			authorizations.add( new Authorization(rs.getInt("id"), new RoleDAO().findByPrimaryKey(rs.getInt("role")),
					new MenuDAO().findByPrimaryKey(rs.getInt("menu"))));
		}

		super.closeConnection(conn);
		return authorizations;
	}

	/**
	 * 查询权限,所有
	 * 
	 * @return 每一条权限信息均会保存在一个权限实体对象中，并且添加到 权限实体数组中
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<Authorization> findAll(int roleid) throws ClassNotFoundException, SQLException {
		List<Authorization> authorizations = new ArrayList<Authorization>(); // 创建一个数组，用于存放100个权限实体对象
		int i = 0;
		// 1、加载驱动，2、连接数据库rbac
		Connection conn = super.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("select * from authorization where role=?");
		pstmt.setInt(1, roleid);
		// 4、根据数据操作对象获取结果集对象，结果集对象存放了所有查询到的记录
		ResultSet rs = pstmt.executeQuery();
		// 通过next()方法让结果集中的指针向下移动一行，当移动到结果集末尾时，返回false，否则返回true
		while (rs.next()) {

			authorizations.add(new Authorization(rs.getInt("id"), new RoleDAO().findByPrimaryKey(rs.getInt("role")),
					new MenuDAO().findByPrimaryKey(rs.getInt("menu"))));
		}

		super.closeConnection(conn);
		return authorizations;
	}

	// 查询权限表中的所有记录总条数
	private int findTotal() throws ClassNotFoundException, SQLException {
		int total = 0;
		// 1、加载驱动，2、连接数据库rbac
		Connection conn = super.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("select count(*) from authorization");
		// 4、根据数据操作对象获取结果集对象，结果集对象存放了所有查询到的记录
		ResultSet rs = pstmt.executeQuery();
		// 因为结果集只有一条记录，无需循环
		if (rs.next()) {
			total = rs.getInt(1); // 此处使用字段对应的序号，作用同 rs.getInt("count(*)")
		}
		return total;
	}

	// 查询权限表中的所有记录总条数
	private int findTotal(int roleid) throws ClassNotFoundException, SQLException {
		int total = 0;
		// 1、加载驱动，2、连接数据库rbac
		Connection conn = super.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("select count(*) from authorization where role=?");
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