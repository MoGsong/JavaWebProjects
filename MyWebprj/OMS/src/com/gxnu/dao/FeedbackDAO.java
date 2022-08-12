package com.gxnu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.gxnu.entity.Feedback;
/**
* 
* @author 胖子不露小酒窝
*持久层类
*/
public class FeedbackDAO extends C3P0BaseDAO{
	/**
	 * 添加留言反馈
	 * @param feedback 表示添加的留言反馈信息，形如：{id=1，content=访客}
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void add(Feedback feedback) throws ClassNotFoundException, SQLException {
		//1.加载驱动  2.连接rbac数据库
		Connection conn=super.getConnection();
		
		//3.基于数据库连接对象java.sql.Connection,创建数据库操作对象java.sql.PreparedStatement,需绑定一个sql语句
		//此处的？表示“占位符”，下标从1开始递增
		PreparedStatement pstmt=
				conn.prepareStatement("insert into feedback(content,time,yuliu) values(?,?,?)");
		
		//设置点位符的值，注意数据类型的选择
		pstmt.setString(1,feedback.getContent());
		pstmt.setTimestamp(2,feedback.getTime());
		pstmt.setString(3,feedback.getYuliu());
		
		//执行SQL语句，结果会同步到MySQL表中
		pstmt.executeUpdate();
		
		//关闭数据库连接
		super.closeConnection(conn);
		
	}
	

	/**
	 * 修改留言
	 * @param feedback 表示待加的留言信息{id=1，content=访客}
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public void merge(Feedback feedback) throws ClassNotFoundException, SQLException {
		//1.加载驱动  2.连接rbac数据库
		Connection conn=super.getConnection();
		
		//3.基于数据库连接对象java.sql.Connection,创建数据库操作对象java.sql.PreparedStatement,需绑定一个sql语句
		//此处的？表示“占位符”，下标从1开始递增
		PreparedStatement pstmt=
				conn.prepareStatement("update feedback set content=?,time=?,yuliu=? where id=?");
		
		//设置点位符的值，注意数据类型的选择
		pstmt.setString(1,feedback.getContent());
		pstmt.setTimestamp(2,feedback.getTime());
		pstmt.setString(3, feedback.getYuliu());
		pstmt.setInt(4, feedback.getId());			//添加新字段，容易忽略设置点位符，导致修改内容为前而非后！
		
		
		//执行SQL语句，结果会同步到MySQL表中
		pstmt.executeUpdate();
		
		//关闭数据库连接
		super.closeConnection(conn);
		
	}

	/**
	 * 删除留言
	 * @param feedback 表示待加的留言信息{id=1，content=访客}
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public void delete(Feedback feedback) throws ClassNotFoundException, SQLException {
		//1.加载驱动  2.连接rbac数据库
		Connection conn=super.getConnection();
		
		//3.基于数据库连接对象java.sql.Connection,创建数据库操作对象java.sql.PreparedStatement,需绑定一个sql语句
		//此处的？表示“占位符”，下标从1开始递增
		PreparedStatement pstmt=
				conn.prepareStatement("delete from feedback where id=?");
		
		//设置点位符的值，注意数据类型的选择
		pstmt.setInt(1,feedback.getId());
		
		//执行SQL语句，结果会同步到MySQL表中
		pstmt.executeUpdate();
		
		//关闭数据库连接
		super.closeConnection(conn);
		
	}
	

	/**
	 * 查询留言反馈，查所有
	 * @param time 
	 * @return 把结果集中的所有记录，包装成feedback对象，再存放到数组中
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
//	public Feedback[] findAll() throws ClassNotFoundException, SQLException {
	public List<Feedback> findAll() throws ClassNotFoundException, SQLException {
		//定义数组
//		Feedback[] feedbacks = new Feedback[findTotal()];   //默认每个元素均为null
//		int i = 0;
		List<Feedback> feedbacks=new ArrayList<Feedback>();
		
		Connection conn = super.getConnection();     			 //1、加载驱动 2、连接rbacpro数据库
		PreparedStatement pstmt = 								 //3、基于数据库连接对象 java.sql.Connection,创建数据库操作对象java.sql.PreparedStatement，须绑定一个SQL语句
				conn.prepareStatement("select * from feedback"); 	 //此处的？表示“占位符”，下标从1开始递增，须在后续设置其值													
		
		ResultSet rs = pstmt.executeQuery();	    	//4、基于数据操作对象java.sql.PreparedStatement，创建数据库结果集对象java.sql.ResultSet
		
		//通过循环遍历结果集
		while(rs.next()) {
			//每循环一次，获取指针定位的某条记录上的数据
			feedbacks.add(new Feedback(rs.getInt("id"), rs.getString("content"),rs.getTimestamp("time"),rs.getString("yuliu")));
		}
		return feedbacks;  //返回数组
	}
	
	/**
	 * 查询留言，查单个
	 * @param id 
	 * @return 把结果集中的所有记录，包装成feedback对象，再存放到数组中
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Feedback findByPrimaryKey(int id) throws ClassNotFoundException, SQLException {
		Feedback feedback = new Feedback();
		//1、加载驱动 2、连接rbacpro数据库
		Connection conn = super.getConnection();
		
		//3、基于数据库连接对象 java.sql.Connection,创建数据库操作对象java.sql.PreparedStatement，须绑定一个SQL语句
		//此处的？表示“占位符”，下标从1开始递增，须在后续设置其值
		PreparedStatement pstmt = conn.prepareStatement("select * from feedback where id=?");
		pstmt.setInt(1, id);
		
		//4、基于数据操作对象java.sql.PreparedStatement，创建数据库结果集对象java.sql.ResultSet
		ResultSet rs = pstmt.executeQuery();
		
		//因为结果集中只有一条记录，无需循环遍历结果集，只需要让指针移动一次即可
		if(rs.next()) {
			//每循环一次，获取指针定位的某条记录上的数据
			int feedbackid = rs.getInt("id");  //id为字段名称 
			String content = rs.getString("content"); //content为字段名称
			Timestamp time = rs.getTimestamp("time"); //time为字段名称 = rs.getString("content"); //content为字段名称
			String yuliu = rs.getString("yuliu");
			feedback = new Feedback(feedbackid,content,time,yuliu); //把数据包装成Feedback实体对象
		}
		//返回数组
		return feedback;
	}
	
	/**
	 * 查询表中所有记录总条数
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	private int findTotal() throws ClassNotFoundException, SQLException {
		int total =0;
		//1、加载驱动 2、连接rbacpro数据库
		Connection conn = super.getConnection();
		//3、基于数据库连接对象 java.sql.Connection,创建数据库操作对象java.sql.PreparedStatement，须绑定一个SQL语句
		//此处的？表示“占位符”，下标从1开始递增，须在后续设置其值
		PreparedStatement pstmt = conn.prepareStatement("select  count(*) from feedback");
		//4、基于数据操作对象java.sql.PreparedStatement，创建数据库结果集对象java.sql.ResultSet
		ResultSet rs = pstmt.executeQuery();
		
		//通过循环遍历结果集
		if(rs.next()) {
			//每循环一次，获取指针定位的某条记录上的数据
			total = rs.getInt(1);  // 此处1为字段序号，也可以使用 count(*)为字段名称 
		}
		return total;
	}
	
	
	/**
	 * 查询留言反馈，根据time字段查询所有留言反馈，若time=0，则得到的是所有父留言反馈
	 * @param time
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<Feedback> findAll(Timestamp time) throws ClassNotFoundException, SQLException {
		//定义数组
		List<Feedback> feedbacks = new ArrayList<Feedback>();   //默认每个元素均为null
		//int i = 0;
		System.out.println("id");
		Connection conn = super.getConnection();     			 //1、加载驱动 2、连接rbacpro数据库
		PreparedStatement pstmt = 								 //3、基于数据库连接对象 java.sql.Connection,创建数据库操作对象java.sql.PreparedStatement，须绑定一个SQL语句
				conn.prepareStatement("select * from feedback where time=?"); 	 //此处的？表示“占位符”，下标从1开始递增，须在后续设置其值													
		pstmt.setTimestamp(1, time);
		
		ResultSet rs = pstmt.executeQuery();	    	//4、基于数据操作对象java.sql.PreparedStatement，创建数据库结果集对象java.sql.ResultSet
		
		//通过循环遍历结果集
		while(rs.next()) {
		
			//每循环一次，获取指针定位的某条记录上的数据				
			feedbacks.add(new Feedback(rs.getInt("id"), rs.getString("content"),rs.getTimestamp("time"),rs.getString("yuliu")));
		}
		
		return feedbacks;	//返回数组
	}
	
	/**
	 * 分页查询
	 * @return
	 */
	public List<Feedback> findAll(int currentPage,int pageSize) throws ClassNotFoundException, SQLException {
		List<Feedback> feedbacks = new ArrayList<Feedback>();
		
		Connection conn = super.getConnection();     			 //1、加载驱动 2、连接rbacpro数据库
		PreparedStatement pstmt = 								 //3、基于数据库连接对象 java.sql.Connection,创建数据库操作对象java.sql.PreparedStatement，须绑定一个SQL语句
				conn.prepareStatement("select * from feedback limit ?,?"); 	 //此处的？表示“占位符”，下标从1开始递增，须在后续设置其值													
		pstmt.setInt(1, (currentPage-1)*pageSize);
		pstmt.setInt(2, pageSize);
		ResultSet rs = pstmt.executeQuery();	    	//4、基于数据操作对象java.sql.PreparedStatement，创建数据库结果集对象java.sql.ResultSet
		
		//通过循环遍历结果集
		while(rs.next()) {
						feedbacks.add(new Feedback(rs.getInt("id"), rs.getString("content"),rs.getTimestamp("time"),
							              				rs.getString("yuliu")));
		}
		
		return feedbacks;	//返回数组
	}
	
	
}
