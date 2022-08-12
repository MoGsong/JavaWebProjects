package com.gxnu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.gxnu.entity.Operator;
import com.gxnu.entity.OutStore;
import com.gxnu.entity.Recipe;


/**
 *持久层类
 */
public class OutStoreDAO extends C3P0BaseDAO {
	
	//添加药品库存
	/**
	 * 添加药品库存
	 * @param outStore 表示添加的药品库存信息，形如：{id=1，name=访客}
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void add(OutStore outStore) throws ClassNotFoundException, SQLException {
		//1.加载驱动  2.连接rbac数据库
		Connection conn=super.getConnection();
		
		//3.基于数据库连接对象java.sql.Connection,创建数据库操作对象java.sql.PreparedStatement,需绑定一个sql语句
		//此处的？表示“占位符”，下标从1开始递增
		PreparedStatement pstmt=
				conn.prepareStatement("insert into out_store(operator,recipe,tprice,time,status,yuliu) values(?,?,?,?,?,?)");
		
		//设置点位符的值，注意数据类型的选择
		pstmt.setInt(1, outStore.getOperator().getId());
		pstmt.setInt(2, outStore.getRecipe().getId());
		pstmt.setInt(3, outStore.getTprice());
		pstmt.setTimestamp(4,outStore.getTime());
		pstmt.setInt(5,outStore.getStatus());
		pstmt.setString(6,outStore.getYuliu());
		pstmt.executeUpdate();
		
		//关闭数据库连接
		super.closeConnection(conn);
		
	}
	
	//修改角色
	/**
	 * 修改角色
	 * @param outStore 表示待加的角色信息{id=1，name=访客}
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public void merge(OutStore outStore) throws ClassNotFoundException, SQLException {
		//1.加载驱动  2.连接rbac数据库
		Connection conn=super.getConnection();
		
		//3.基于数据库连接对象java.sql.Connection,创建数据库操作对象java.sql.PreparedStatement,需绑定一个sql语句
		//此处的？表示“占位符”，下标从1开始递增
		PreparedStatement pstmt=
				conn.prepareStatement("update out_store set operator=?,recipe=?,tprice=?,time=?,status=?,yuliu=? where id=?");
		
		//设置点位符的值，注意数据类型的选择
		pstmt.setInt(1, outStore.getOperator().getId());
		pstmt.setInt(2, outStore.getRecipe().getId());
		pstmt.setInt(3, outStore.getTprice());
		pstmt.setTimestamp(4,outStore.getTime());
		pstmt.setInt(5,outStore.getStatus());
		pstmt.setString(6,outStore.getYuliu());
		pstmt.setInt(7, outStore.getId());
		
		
		//执行SQL语句，结果会同步到MySQL表中
		pstmt.executeUpdate();
		
		//关闭数据库连接
		super.closeConnection(conn);
		
	}
	
	//删除角色
	/**
	 * 删除角色
	 * @param outStore 表示待加的角色信息{id=1，name=访客}
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public void delete(int id) throws ClassNotFoundException, SQLException {
		//1.加载驱动  2.连接rbac数据库
		Connection conn=super.getConnection();
		
		//3.基于数据库连接对象java.sql.Connection,创建数据库操作对象java.sql.PreparedStatement,需绑定一个sql语句
		//此处的？表示“占位符”，下标从1开始递增
		PreparedStatement pstmt=
				conn.prepareStatement("delete from out_store where id=?");
		
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
	 * @return 把结果集中的所有记录，包装成outStore对象，再存放到数组中
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<OutStore> findAll() throws ClassNotFoundException, SQLException {
		//定义数组
		//OutStore[] outStores = new OutStore[findTotal()];   //默认每个元素均为null
		List<OutStore> outStores = new ArrayList<OutStore>();
		
		Connection conn = super.getConnection();     			 //1、加载驱动 2、连接rbacpro数据库
		PreparedStatement pstmt = 								 //3、基于数据库连接对象 java.sql.Connection,创建数据库操作对象java.sql.PreparedStatement，须绑定一个SQL语句
				conn.prepareStatement("select * from out_store"); 	 //此处的？表示“占位符”，下标从1开始递增，须在后续设置其值													
		
		ResultSet rs = pstmt.executeQuery();	    	//4、基于数据操作对象java.sql.PreparedStatement，创建数据库结果集对象java.sql.ResultSet
		
		//通过循环遍历结果集
		while(rs.next()) {
			Operator operator = new OperatorDAO().findByPrimaryKey(rs.getInt("operator"));
			Recipe recipe = new RecipeDAO().findById(rs.getInt("recipe"));
			
			outStores.add(new OutStore(
					rs.getInt("id"),
					operator,
					recipe,
					rs.getInt("tprice"),
					rs.getTimestamp("time"),
					rs.getInt("status"),
					rs.getString("yuliu")
					));
		}rs.close();	
		return outStores;	//返回集合
	}
	
	public List<OutStore> findAll(int currentPage,int pageSize) throws ClassNotFoundException, SQLException {
		//定义数组
		//OutStore[] outStores = new OutStore[findTotal()];   //默认每个元素均为null
		List<OutStore> outStores = new ArrayList<OutStore>();
		
		Connection conn = super.getConnection();     			 //1、加载驱动 2、连接rbacpro数据库
		PreparedStatement pstmt = 								 //3、基于数据库连接对象 java.sql.Connection,创建数据库操作对象java.sql.PreparedStatement，须绑定一个SQL语句
				conn.prepareStatement("select * from out_store order by id limit ?,?"); 	 //此处的？表示“占位符”，下标从1开始递增，须在后续设置其值													
		pstmt.setInt(1, (currentPage-1)*pageSize);
		pstmt.setInt(2, pageSize);
		ResultSet rs = pstmt.executeQuery();	    	//4、基于数据操作对象java.sql.PreparedStatement，创建数据库结果集对象java.sql.ResultSet
		
		//通过循环遍历结果集
		while(rs.next()) {
			Operator operator = new OperatorDAO().findByPrimaryKey(rs.getInt("operator"));
			Recipe recipe = new RecipeDAO().findById(rs.getInt("recipe"));
			
			outStores.add(new OutStore(
					operator,
					recipe,
					rs.getInt("tprice"),
					rs.getTimestamp("time"),
					rs.getInt("status"),
					rs.getString("yuliu")
					));
		}		
		return outStores;	//返回集合
	}
	
	/**
	 * 查询角色，查单个
	 * @param id 
	 * @return 把结果集中的所有记录，包装成outStore对象，再存放到数组中
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public OutStore findById(int id) throws ClassNotFoundException, SQLException {
		OutStore outStore = new OutStore();
		//1、加载驱动 2、连接rbacpro数据库
		Connection conn = super.getConnection();
		
		//3、基于数据库连接对象 java.sql.Connection,创建数据库操作对象java.sql.PreparedStatement，须绑定一个SQL语句
		//此处的？表示“占位符”，下标从1开始递增，须在后续设置其值
		PreparedStatement pstmt = conn.prepareStatement("select * from out_store where id=?");
		pstmt.setInt(1, id);
		//4、基于数据操作对象java.sql.PreparedStatement，创建数据库结果集对象java.sql.ResultSet
		ResultSet rs = pstmt.executeQuery();
		
		//因为结果集中只有一条记录，无需循环遍历结果集，只需要让指针移动一次即可
		if(rs.next()) {
			//每循环一次，获取指针定位的某条记录上的数据
			int outStoreid = rs.getInt("id");  //id为字段名称 
			Operator operator = new OperatorDAO().findByPrimaryKey(rs.getInt("operator"));
			Recipe recipe = new RecipeDAO().findById(rs.getInt("recipe"));
			
			int tprice = rs.getInt("tprice");
			Timestamp time = rs.getTimestamp("time");
			int status = rs.getInt("status");
			String yuliu = rs.getString("yuliu");
			outStore = new OutStore(outStoreid,operator,recipe,tprice,time,status,yuliu); //把数据包装成OutStore实体对象
		}
		//返回数组
		return outStore;
	}
		
}
