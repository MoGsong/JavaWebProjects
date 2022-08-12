package com.gxnu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gxnu.entity.DrugInfo;


/**
 *持久层类
 */
public class DrugInfoDAO extends C3P0BaseDAO {
	
	//添加药品库存
	/**
	 * 添加药品库存
	 * @param drugInfo 表示添加的药品库存信息，形如：{id=1，name=访客}
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void add(DrugInfo drugInfo) throws ClassNotFoundException, SQLException {
		//1.加载驱动  2.连接rbac数据库
		Connection conn=super.getConnection();
		
		//3.基于数据库连接对象java.sql.Connection,创建数据库操作对象java.sql.PreparedStatement,需绑定一个sql语句
		//此处的？表示“占位符”，下标从1开始递增
		PreparedStatement pstmt=
				conn.prepareStatement("insert into drug_info(name,element,effect,notice,yuliu) values(?,?,?,?,?)");
		
		//设置点位符的值，注意数据类型的选择
		pstmt.setString(1, drugInfo.getName());
		pstmt.setString(2, drugInfo.getElement());
		pstmt.setString(3, drugInfo.getEffect());
		pstmt.setString(4, drugInfo.getNotice());
		pstmt.setString(5, drugInfo.getYuliu());
		//执行SQL语句，结果会同步到MySQL表中
		pstmt.executeUpdate();
		
		//关闭数据库连接
		super.closeConnection(conn);
		
	}
	
	//修改角色
	/**
	 * 修改角色
	 * @param drugInfo 表示待加的角色信息{id=1，name=访客}
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public void merge(DrugInfo drugInfo) throws ClassNotFoundException, SQLException {
		//1.加载驱动  2.连接rbac数据库
		Connection conn=super.getConnection();
		
		//3.基于数据库连接对象java.sql.Connection,创建数据库操作对象java.sql.PreparedStatement,需绑定一个sql语句
		//此处的？表示“占位符”，下标从1开始递增
		PreparedStatement pstmt=
				conn.prepareStatement("update drug_info set name=?,element=?,effect=?,notice=?,yuliu=? where id=?");
		
		//设置点位符的值，注意数据类型的选择
		pstmt.setString(1, drugInfo.getName());
		pstmt.setString(2, drugInfo.getElement());
		pstmt.setString(3, drugInfo.getEffect());
		pstmt.setString(4, drugInfo.getNotice());
		pstmt.setString(5, drugInfo.getYuliu());
		pstmt.setInt(6, drugInfo.getId());
		
		//执行SQL语句，结果会同步到MySQL表中
		pstmt.executeUpdate();
		
		//关闭数据库连接
		super.closeConnection(conn);
		
	}
	
	//删除角色
	/**
	 * 删除角色
	 * @param drugInfo 表示待加的角色信息{id=1，name=访客}
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public void delete(int id) throws ClassNotFoundException, SQLException {
		//1.加载驱动  2.连接rbac数据库
		Connection conn=super.getConnection();
		
		//3.基于数据库连接对象java.sql.Connection,创建数据库操作对象java.sql.PreparedStatement,需绑定一个sql语句
		//此处的？表示“占位符”，下标从1开始递增
		PreparedStatement pstmt=
				conn.prepareStatement("delete from drug_info where id=?");
		
		//设置点位符的值，注意数据类型的选择
		pstmt.setInt(1,id);
		
		//执行SQL语句，结果会同步到MySQL表中
		pstmt.executeUpdate();
		
		//关闭数据库连接
		super.closeConnection(conn);
		
	}
	
	
	//查询药品库存
	/**
	 * 查询药品库存，查所有
	 * @param parent 
	 * @return 把结果集中的所有记录，包装成drugInfo对象，再存放到数组中
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<DrugInfo> findAll() throws ClassNotFoundException, SQLException {
		//定义数组
		//DrugInfo[] drugInfos = new DrugInfo[findTotal()];   //默认每个元素均为null
		List<DrugInfo> drugInfos = new ArrayList<DrugInfo>();
		int i = 0;
		
		Connection conn = super.getConnection();     			 //1、加载驱动 2、连接rbacpro数据库
		PreparedStatement pstmt = 								 //3、基于数据库连接对象 java.sql.Connection,创建数据库操作对象java.sql.PreparedStatement，须绑定一个SQL语句
				conn.prepareStatement("select * from drug_info"); 	 //此处的？表示“占位符”，下标从1开始递增，须在后续设置其值													
		
		ResultSet rs = pstmt.executeQuery();	    	//4、基于数据操作对象java.sql.PreparedStatement，创建数据库结果集对象java.sql.ResultSet
		
		//通过循环遍历结果集
		while(rs.next()) {
			
			drugInfos.add(new DrugInfo(
					rs.getInt("id"),
					rs.getString("name"),
					rs.getString("element"),
					rs.getString("effect"),
					rs.getString("notice"),
					rs.getString("yuliu")
					));
		}		
		return drugInfos;	//返回集合
	}
	
	public List<DrugInfo> findAll(int currentPage,int pageSize) throws ClassNotFoundException, SQLException {
		//定义数组
		//DrugInfo[] drugInfos = new DrugInfo[findTotal()];   //默认每个元素均为null
		List<DrugInfo> drugInfos = new ArrayList<DrugInfo>();
		int i = 0;
		
		Connection conn = super.getConnection();     			 //1、加载驱动 2、连接rbacpro数据库
		PreparedStatement pstmt = 								 //3、基于数据库连接对象 java.sql.Connection,创建数据库操作对象java.sql.PreparedStatement，须绑定一个SQL语句
				conn.prepareStatement("select * from drug_info order by id limit ?,?"); 	 //此处的？表示“占位符”，下标从1开始递增，须在后续设置其值													
		pstmt.setInt(1, (currentPage-1)*pageSize);
		pstmt.setInt(2, pageSize);
		ResultSet rs = pstmt.executeQuery();	    	//4、基于数据操作对象java.sql.PreparedStatement，创建数据库结果集对象java.sql.ResultSet
		
		//通过循环遍历结果集
		while(rs.next()) {

			drugInfos.add(new DrugInfo(
					rs.getInt("id"),
					rs.getString("name"),
					rs.getString("element"),
					rs.getString("effect"),
					rs.getString("notice"),
					rs.getString("yuliu")
					));
		}		
		return drugInfos;	//返回集合
	}
	
	/**
	 * 查询角色，查单个
	 * @param id 
	 * @return 把结果集中的所有记录，包装成drugInfo对象，再存放到数组中
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public DrugInfo findById(int id) throws ClassNotFoundException, SQLException {
		DrugInfo drugInfo = new DrugInfo();
		//1、加载驱动 2、连接rbacpro数据库
		Connection conn = super.getConnection();
		
		//3、基于数据库连接对象 java.sql.Connection,创建数据库操作对象java.sql.PreparedStatement，须绑定一个SQL语句
		//此处的？表示“占位符”，下标从1开始递增，须在后续设置其值
		PreparedStatement pstmt = conn.prepareStatement("select * from drug_info where id=?");
		pstmt.setInt(1, id);
		//4、基于数据操作对象java.sql.PreparedStatement，创建数据库结果集对象java.sql.ResultSet
		ResultSet rs = pstmt.executeQuery();
		
		//因为结果集中只有一条记录，无需循环遍历结果集，只需要让指针移动一次即可
		if(rs.next()) {
			//每循环一次，获取指针定位的某条记录上的数据
			int drugInfoid = rs.getInt("id");  //id为字段名称 
			
			String name = rs.getString("name");
			String element = rs.getString("element");
			String effect = rs.getString("effect");
			String notice = rs.getString("notice");
			String yuliu = rs.getString("yuliu");
			drugInfo = new DrugInfo(drugInfoid,name,element,effect,notice,yuliu); //把数据包装成DrugInfo实体对象
		}
		//返回数组
		return drugInfo;
	}
		
}
