package com.gxnu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gxnu.entity.Inventory;
import com.gxnu.entity.OutDetail;
import com.gxnu.entity.OutStore;


/**
 *持久层类
 */
public class OutDetailDAO extends C3P0BaseDAO {
	
	//添加药品库存
	/**
	 * 添加药品库存
	 * @param outDetail 表示添加的药品库存信息，形如：{id=1，name=访客}
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void add(OutDetail outDetail) throws ClassNotFoundException, SQLException {
		//1.加载驱动  2.连接rbac数据库
		Connection conn=super.getConnection();
		
		//3.基于数据库连接对象java.sql.Connection,创建数据库操作对象java.sql.PreparedStatement,需绑定一个sql语句
		//此处的？表示“占位符”，下标从1开始递增
		PreparedStatement pstmt=
				conn.prepareStatement("insert into out_detail(inventory,out_store,sprice,num,tusage,yuliu) values(?,?,?,?,?,?)");
		
		//设置点位符的值，注意数据类型的选择
		pstmt.setInt(1, outDetail.getInventory().getId());
		pstmt.setInt(2, outDetail.getOutStore().getId());
		pstmt.setInt(3, outDetail.getSprice());
		pstmt.setInt(4, outDetail.getNum());
		pstmt.setString(5,outDetail.getTusage());
		pstmt.setString(6,outDetail.getYuliu());
		pstmt.executeUpdate();
		
		//关闭数据库连接
		super.closeConnection(conn);
		
	}
	
	//修改角色
	/**
	 * 修改角色
	 * @param outDetail 表示待加的角色信息{id=1，name=访客}
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public void merge(OutDetail outDetail) throws ClassNotFoundException, SQLException {
		//1.加载驱动  2.连接rbac数据库
		Connection conn=super.getConnection();
		
		//3.基于数据库连接对象java.sql.Connection,创建数据库操作对象java.sql.PreparedStatement,需绑定一个sql语句
		//此处的？表示“占位符”，下标从1开始递增
		PreparedStatement pstmt=
				conn.prepareStatement("update out_detail set inventory=?,out_store=?,num=?,tusage=?,yuliu=? where id=?");
		
		//设置点位符的值，注意数据类型的选择
		pstmt.setInt(1, outDetail.getInventory().getId());
		pstmt.setInt(2, outDetail.getOutStore().getId());
		pstmt.setInt(3, outDetail.getNum());
		pstmt.setString(4,outDetail.getTusage());
		pstmt.setString(5,outDetail.getYuliu());
		pstmt.setInt(6, outDetail.getId());
		
		
		//执行SQL语句，结果会同步到MySQL表中
		pstmt.executeUpdate();
		
		//关闭数据库连接
		super.closeConnection(conn);
		
	}
	
	//删除角色
	/**
	 * 删除角色
	 * @param outDetail 表示待加的角色信息{id=1，name=访客}
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public void delete(int id) throws ClassNotFoundException, SQLException {
		//1.加载驱动  2.连接rbac数据库
		Connection conn=super.getConnection();
		
		//3.基于数据库连接对象java.sql.Connection,创建数据库操作对象java.sql.PreparedStatement,需绑定一个sql语句
		//此处的？表示“占位符”，下标从1开始递增
		PreparedStatement pstmt=
				conn.prepareStatement("delete from out_detail where id=?");
		
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
	 * @return 把结果集中的所有记录，包装成outDetail对象，再存放到数组中
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<OutDetail> findAll() throws ClassNotFoundException, SQLException {
		//定义数组
		//OutDetail[] outDetails = new OutDetail[findTotal()];   //默认每个元素均为null
		List<OutDetail> outDetails = new ArrayList<OutDetail>();
		
		Connection conn = super.getConnection();     			 //1、加载驱动 2、连接rbacpro数据库
		PreparedStatement pstmt = 								 //3、基于数据库连接对象 java.sql.Connection,创建数据库操作对象java.sql.PreparedStatement，须绑定一个SQL语句
				conn.prepareStatement("select * from out_detail"); 	 //此处的？表示“占位符”，下标从1开始递增，须在后续设置其值													
		
		ResultSet rs = pstmt.executeQuery();	    	//4、基于数据操作对象java.sql.PreparedStatement，创建数据库结果集对象java.sql.ResultSet
		
		//通过循环遍历结果集
		while(rs.next()) {
			Inventory inventory = new InventoryDAO().findById(rs.getInt("inventory"));
			OutStore outStore = new OutStoreDAO().findById(rs.getInt("out_store"));
			
			outDetails.add(new OutDetail(
					rs.getInt("id"),
					inventory,
					outStore,
					rs.getInt("sprice"),
					rs.getInt("num"),
					rs.getString("tusage"),
					rs.getString("yuliu")
					));
		}		
		return outDetails;	//返回集合
	}
	
	public List<OutDetail> findAll(int currentPage,int pageSize) throws ClassNotFoundException, SQLException {
		//定义数组
		//OutDetail[] outDetails = new OutDetail[findTotal()];   //默认每个元素均为null
		List<OutDetail> outDetails = new ArrayList<OutDetail>();
		
		Connection conn = super.getConnection();     			 //1、加载驱动 2、连接rbacpro数据库
		PreparedStatement pstmt = 								 //3、基于数据库连接对象 java.sql.Connection,创建数据库操作对象java.sql.PreparedStatement，须绑定一个SQL语句
				conn.prepareStatement("select * from out_detail order by id limit ?,?"); 	 //此处的？表示“占位符”，下标从1开始递增，须在后续设置其值													
		pstmt.setInt(1, (currentPage-1)*pageSize);
		pstmt.setInt(2, pageSize);
		ResultSet rs = pstmt.executeQuery();	    	//4、基于数据操作对象java.sql.PreparedStatement，创建数据库结果集对象java.sql.ResultSet
		
		//通过循环遍历结果集
		while(rs.next()) {
			Inventory inventory = new InventoryDAO().findById(rs.getInt("inventory"));
			OutStore outStore = new OutStoreDAO().findById(rs.getInt("out_store"));
			
			outDetails.add(new OutDetail(
					rs.getInt("id"),
					inventory,
					outStore,
					rs.getInt("sprice"),
					rs.getInt("num"),
					rs.getString("tusage"),
					rs.getString("yuliu")
					));
		}		
		return outDetails;	//返回集合
	}
	
	/**
	 * 查询角色，查单个
	 * @param id 
	 * @return 把结果集中的所有记录，包装成outDetail对象，再存放到数组中
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public OutDetail findById(int id) throws ClassNotFoundException, SQLException {
		OutDetail outDetail = new OutDetail();
		//1、加载驱动 2、连接rbacpro数据库
		Connection conn = super.getConnection();
		
		//3、基于数据库连接对象 java.sql.Connection,创建数据库操作对象java.sql.PreparedStatement，须绑定一个SQL语句
		//此处的？表示“占位符”，下标从1开始递增，须在后续设置其值
		PreparedStatement pstmt = conn.prepareStatement("select * from out_detail where id=?");
		pstmt.setInt(1, id);
		//4、基于数据操作对象java.sql.PreparedStatement，创建数据库结果集对象java.sql.ResultSet
		ResultSet rs = pstmt.executeQuery();
		
		//因为结果集中只有一条记录，无需循环遍历结果集，只需要让指针移动一次即可
		if(rs.next()) {
			//每循环一次，获取指针定位的某条记录上的数据
			int outDetailid = rs.getInt("id");  //id为字段名称 
			Inventory inventory = new InventoryDAO().findById(rs.getInt("inventory"));
			OutStore outStore = new OutStoreDAO().findById(rs.getInt("out_store"));
			int sprice = rs.getInt("sprice");
			int num = rs.getInt("num");
			String tusage = rs.getString("tusage");
			String yuliu = rs.getString("yuliu");
			outDetail = new OutDetail(outDetailid,inventory,outStore,sprice,num,tusage,yuliu); //把数据包装成OutDetail实体对象
		}
		//返回数组
		return outDetail;
	}
		
}
