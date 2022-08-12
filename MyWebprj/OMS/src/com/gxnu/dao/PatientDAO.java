package com.gxnu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gxnu.entity.Patient;
import com.gxnu.entity.Patient;


/**
 * 操作员的CURD操作
 * @author 胖子不露小酒窝
 *
 */
public class PatientDAO extends C3P0BaseDAO {
	
	//添加操作员
	/**
	 * 添加操作员
	 * @param patient 表示待加的操作员信息{id=1，name=访客}
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public void add(Patient patient) throws ClassNotFoundException, SQLException {
		//1.加载驱动  2.连接rbac数据库
		Connection conn=super.getConnection();
		
		//3.基于数据库连接对象java.sql.Connection,创建数据库操作对象java.sql.PreparedStatement,需绑定一个sql语句
		//此处的？表示“占位符”，下标从1开始递增
		PreparedStatement pstmt=
				conn.prepareStatement("insert into patient(name,sex,age,username,password,idcard,tel,pic,yuliu,email) values(?,?,?,?,?,?,?,?,?,?)");
		
		//设置点位符的值，注意数据类型的选择
		
		pstmt.setString(1,patient.getName());
		pstmt.setString(2,patient.getSex());
		pstmt.setInt(3,patient.getAge());
		pstmt.setString(4,patient.getUsername());
		pstmt.setString(5,patient.getPassword());	
		pstmt.setString(6,patient.getIdcard());	
		pstmt.setString(7,patient.getTel());		
		pstmt.setString(8,patient.getPic());		
		pstmt.setString(9,patient.getYuliu());				
		pstmt.setString(10,patient.getEmail());	
			 
		//执行SQL语句，结果会同步到MySQL表中
		pstmt.executeUpdate();
		
		//关闭数据库连接
		super.closeConnection(conn);
		
	}
	
	
	//修改操作员
	/**
	 * 修改操作员
	 * @param patient 表示待加的操作员信息{id=1，name=访客}
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public void update(Patient patient) throws ClassNotFoundException, SQLException {
		//1.加载驱动  2.连接rbac数据库
		Connection conn=super.getConnection();
		
		//3.基于数据库连接对象java.sql.Connection,创建数据库操作对象java.sql.PreparedStatement,需绑定一个sql语句
		//此处的？表示“占位符”，下标从1开始递增
		PreparedStatement pstmt=
				conn.prepareStatement("update patient set name=?,sex=?,age=?,username=?,password=?,idcard=?,tel=?,pic=?,yuliu=?,email=? where id=?");
		
		//设置点位符的值，注意数据类型的选择
		pstmt.setString(1,patient.getName());
		pstmt.setString(2,patient.getSex());
		pstmt.setInt(3,patient.getAge());
		pstmt.setString(4,patient.getUsername());
		pstmt.setString(5,patient.getPassword());	
		pstmt.setString(6,patient.getIdcard());	
		pstmt.setString(7,patient.getTel());		
		pstmt.setString(8,patient.getPic());		
		pstmt.setString(9,patient.getYuliu());				
		pstmt.setString(10,patient.getEmail());	
		pstmt.setInt(11,patient.getId());	
		//pstmt.setInt(5,patient.getRole().getId());  //导航链，可以获取关联对象中的详细信息		
		//执行SQL语句，结果会同步到MySQL表中
		pstmt.executeUpdate();
		
		//关闭数据库连接
		super.closeConnection(conn);
		
	}
	
	//删除操作员
	/**
	 * 删除操作员
	 * @param patient 表示待加的操作员信息{id=1，name=访客}
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public void delete(Patient patient) throws ClassNotFoundException, SQLException {
		//1.加载驱动  2.连接rbac数据库
		Connection conn=super.getConnection();
		
		//3.基于数据库连接对象java.sql.Connection,创建数据库操作对象java.sql.PreparedStatement,需绑定一个sql语句
		//此处的？表示“占位符”，下标从1开始递增
		PreparedStatement pstmt=
				conn.prepareStatement("delete from patient where id=?");
		
		//设置点位符的值，注意数据类型的选择
		pstmt.setInt(1,patient.getId());
		
		//执行SQL语句，结果会同步到MySQL表中
		pstmt.executeUpdate();
		
		//关闭数据库连接
		super.closeConnection(conn);
		
	}
	
	//查询操作员
	/**
	 * 查询操作员，查所有
	 * @return 把结果集中的所有记录，包装成patient对象，再存放到数组中
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<Patient> findAll() throws ClassNotFoundException, SQLException {
		//定义数组
		List<Patient> patients = new ArrayList<Patient>();   //默认每个元素均为null
		int i = 0;		
		Connection conn = super.getConnection();     			 //1、加载驱动 2、连接rbacpro数据库
		PreparedStatement pstmt = 								 //3、基于数据库连接对象 java.sql.Connection,创建数据库操作对象java.sql.PreparedStatement，须绑定一个SQL语句
				conn.prepareStatement("select * from patient"); 	 //此处的？表示“占位符”，下标从1开始递增，须在后续设置其值													
		ResultSet rs = pstmt.executeQuery();	    	//4、基于数据操作对象java.sql.PreparedStatement，创建数据库结果集对象java.sql.ResultSet
		
		//通过循环遍历结果集
		while(rs.next()) {
			//每循环一次，获取指针定位的某条记录上的数据
			/*
			int id = rs.getInt("id");  //id为字段名称 
			String name = rs.getString("name"); //name为字段名称
			Patient patient = new Patient(id, name); //把数据包装成Patient实体对象
			patients[i] = patient;
			i++;
			*/
			
			/*Role role=new Role();  //{id=0,name=null;}
			RoleDAO roleDAO=new RoleDAO();
			role=roleDAO.findByPrimaryKey(rs.getInt("role");
			*/
			//Role role=new RoleDAO().findByPrimaryKey(rs.getInt("role"));
			patients.add( new Patient(rs.getInt("id"),
					   rs.getString("name"),
					   rs.getString("sex"),
					   rs.getInt("age"),
					   rs.getString("username"),
					   rs.getString("password"),
					   rs.getString("idcard"),
					   rs.getString("pic"),
					   rs.getString("tel"),
					   rs.getString("email"),
					   rs.getString("yuliu")));					
			
		}
		super.closeConnection(conn);
		return patients;	//返回数组
	}
	
	/**
	 * 查询操作员，查单个
	 * @return 把结果集中的所有记录，包装成patient对象，再存放到数组中
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Patient findByPrimaryKey(int id) throws ClassNotFoundException, SQLException {
		Patient patient = new Patient();
		//1、加载驱动 2、连接rbacpro数据库
		Connection conn = super.getConnection();
		
		//3、基于数据库连接对象 java.sql.Connection,创建数据库操作对象java.sql.PreparedStatement，须绑定一个SQL语句
		//此处的？表示“占位符”，下标从1开始递增，须在后续设置其值
		PreparedStatement pstmt = conn.prepareStatement("select * from patient where id=?");
		pstmt.setInt(1, id);
		
		//4、基于数据操作对象java.sql.PreparedStatement，创建数据库结果集对象java.sql.ResultSet
		ResultSet rs = pstmt.executeQuery();
		
		//因为结果集中只有一条记录，无需循环遍历结果集，只需要让指针移动一次即可
		if(rs.next()) {
			
			patient=new Patient(rs.getInt("id"),
					   rs.getString("name"),
					   rs.getString("sex"),
					   rs.getInt("age"),
					   rs.getString("username"),
					   rs.getString("password"),
					   rs.getString("idcard"),
					   rs.getString("pic"),
					   rs.getString("tel"),
					   rs.getString("email"),
					   rs.getString("yuliu"));
			
			 //把数据包装成Patient实体对象
		}
		//返回数组
		super.closeConnection(conn);
	return patient;
	}
	
	//查询表中所有记录总条数
	private int findTotal() throws ClassNotFoundException, SQLException {
		int total =0;
		//1、加载驱动 2、连接rbacpro数据库
		Connection conn = super.getConnection();
		//3、基于数据库连接对象 java.sql.Connection,创建数据库操作对象java.sql.PreparedStatement，须绑定一个SQL语句
		//此处的？表示“占位符”，下标从1开始递增，须在后续设置其值
		PreparedStatement pstmt = conn.prepareStatement("select  count(*) from patient");
		//4、基于数据操作对象java.sql.PreparedStatement，创建数据库结果集对象java.sql.ResultSet
		ResultSet rs = pstmt.executeQuery();
		
		//通过循环遍历结果集
		if(rs.next()) {
			//每循环一次，获取指针定位的某条记录上的数据
			total = rs.getInt(1);  // 此处1为字段序号，也可以使用 count(*)为字段名称 
		}
		super.closeConnection(conn);
		return total;
	}
}
