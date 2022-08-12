package com.gxnu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gxnu.entity.Doctor;
import com.gxnu.entity.Registration;

/**
 *持久层类
 */
public class RegistrationDAO extends C3P0BaseDAO {
	
	//添加预约挂号
	/**
	 * 添加预约挂号
	 * @param registration 表示添加的预约挂号信息，形如：{id=1，name=访客}
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void add(Registration registration) throws ClassNotFoundException, SQLException {
		//1.加载驱动  2.连接rbac数据库
		Connection conn=super.getConnection();
		
		//3.基于数据库连接对象java.sql.Connection,创建数据库操作对象java.sql.PreparedStatement,需绑定一个sql语句
		//此处的？表示“占位符”，下标从1开始递增
		PreparedStatement pstmt=
				conn.prepareStatement("insert into registration(doctor,patient,reserve_time,pay_time,number,yuliu) values(?,?,?,?,?,?)");
		
		//设置点位符的值，注意数据类型的选择
		pstmt.setInt(1,registration.getDoctor().getId());
		pstmt.setInt(2,registration.getPatient().getId());
		pstmt.setTimestamp(3,registration.getReserve_time());
		pstmt.setTimestamp(4,registration.getPay_time());
		pstmt.setString(5,registration.getNumber());
		pstmt.setString(6,registration.getYuliu());
		//执行SQL语句，结果会同步到MySQL表中
		pstmt.executeUpdate();
		
		//关闭数据库连接
		super.closeConnection(conn);
		
	}
	
	//修改预约挂号
	/**
	 * 修改预约挂号
	 * @param registration 表示待加的预约挂号信息{id=1，name=访客}
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public void merge(Registration registration) throws ClassNotFoundException, SQLException {
		//1.加载驱动  2.连接rbac数据库
		Connection conn=super.getConnection();
		
		//3.基于数据库连接对象java.sql.Connection,创建数据库操作对象java.sql.PreparedStatement,需绑定一个sql语句
		//此处的？表示“占位符”，下标从1开始递增
		PreparedStatement pstmt=
				conn.prepareStatement("update registration set doctor=?,patient=?,reserve_time=?,pay_time=?,number=?,yuliu=? where id=?");
		
		//设置点位符的值，注意数据类型的选择
		pstmt.setInt(1,registration.getDoctor().getId());
		pstmt.setInt(2,registration.getPatient().getId());
		pstmt.setTimestamp(3,registration.getReserve_time());
		pstmt.setTimestamp(4,registration.getPay_time());
		pstmt.setString(5,registration.getNumber());
		pstmt.setString(6,registration.getYuliu());
		pstmt.setInt(7,registration.getId());
		
		//执行SQL语句，结果会同步到MySQL表中
		pstmt.executeUpdate();
		
		//关闭数据库连接
		super.closeConnection(conn);
		
	}
	
	//删除预约挂号
	/**
	 * 删除预约挂号
	 * @param registration 表示待加的预约挂号信息{id=1，name=访客}
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public void delete(Registration registration) throws ClassNotFoundException, SQLException {
		//1.加载驱动  2.连接rbac数据库
		Connection conn=super.getConnection();
		
		//3.基于数据库连接对象java.sql.Connection,创建数据库操作对象java.sql.PreparedStatement,需绑定一个sql语句
		//此处的？表示“占位符”，下标从1开始递增
		PreparedStatement pstmt=
				conn.prepareStatement("delete from registration where id=?");
		
		//设置点位符的值，注意数据类型的选择
		pstmt.setInt(1,registration.getId());
		
		//执行SQL语句，结果会同步到MySQL表中
		pstmt.executeUpdate();
		
		//关闭数据库连接
		super.closeConnection(conn);
		
	}
	
	
	//查询预约挂号
	/**
	 * 查询预约挂号，查所有
	 * @param parent 
	 * @return 把结果集中的所有记录，包装成registration对象，再存放到数组中
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<Registration> findAll() throws ClassNotFoundException, SQLException {
		//定义数组
		//Registration[] registrations = new Registration[findTotal()];   //默认每个元素均为null
		List<Registration> registrations = new ArrayList<Registration>();
		int i = 0;
		
		Connection conn = super.getConnection();     			 //1、加载驱动 2、连接rbacpro数据库
		PreparedStatement pstmt = 								 //3、基于数据库连接对象 java.sql.Connection,创建数据库操作对象java.sql.PreparedStatement，须绑定一个SQL语句
				conn.prepareStatement("select * from registration"); 	 //此处的？表示“占位符”，下标从1开始递增，须在后续设置其值													
		
		ResultSet rs = pstmt.executeQuery();	    	//4、基于数据操作对象java.sql.PreparedStatement，创建数据库结果集对象java.sql.ResultSet
		
		//通过循环遍历结果集
		while(rs.next()) {
			//每循环一次，获取指针定位的某条记录上的数据
			/*
			int id = rs.getInt("id");  //id为字段名称 
			String name = rs.getString("name"); //name为字段名称
			Registration registration = new Registration(id, name); //把数据包装成Registration实体对象
			registrations[i] = registration;
			i++;
			*/

			registrations.add(new Registration(rs.getInt("id"), new DoctorDAO().findByPrimaryKey(rs.getInt("doctor")), new PatientDAO().findByPrimaryKey(rs.getInt("patient")),
					rs.getTimestamp("reserve_time"),rs.getTimestamp("pay_time"),rs.getString("number"),rs.getString("yuliu")));
		}	
		//关闭数据库连接
		super.closeConnection(conn);
		return registrations;	//返回集合
	}
	

	
	/**
	 * 查询预约挂号，查单个
	 * @param id 
	 * @return 把结果集中的所有记录，包装成registration对象，再存放到数组中
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Registration findByPrimaryKey(int id) throws ClassNotFoundException, SQLException {
		Registration registration = new Registration();
		//1、加载驱动 2、连接rbacpro数据库
		Connection conn = super.getConnection();
		
		//3、基于数据库连接对象 java.sql.Connection,创建数据库操作对象java.sql.PreparedStatement，须绑定一个SQL语句
		//此处的？表示“占位符”，下标从1开始递增，须在后续设置其值
		PreparedStatement pstmt = conn.prepareStatement("select * from registration where id=?");
		pstmt.setInt(1, id);
		//4、基于数据操作对象java.sql.PreparedStatement，创建数据库结果集对象java.sql.ResultSet
		ResultSet rs = pstmt.executeQuery();
		
		//因为结果集中只有一条记录，无需循环遍历结果集，只需要让指针移动一次即可
		if(rs.next()) {
			//每循环一次，获取指针定位的某条记录上的数据
			registration= new Registration(rs.getInt("id"), new DoctorDAO().findByPrimaryKey(rs.getInt("doctor")), new PatientDAO().findByPrimaryKey(rs.getInt("patient")),
					rs.getTimestamp("reserve_time"),rs.getTimestamp("pay_time"),rs.getString("number"),rs.getString("yuliu"));
		}
		super.closeConnection(conn);
		//返回数组
		return registration;
	}


}
