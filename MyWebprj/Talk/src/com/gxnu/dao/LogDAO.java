package com.gxnu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.gxnu.entity.Log;

public class LogDAO extends C3P0BaseDAO{
		/**
		 * 添加消息记录
		 * @param log 表示添加的消息记录信息，形如：{id=1，name=访客}
		 * @throws ClassNotFoundException
		 * @throws SQLException
		 */
		public void add(Log log) throws ClassNotFoundException, SQLException {
			//1.加载驱动  2.连接rbac数据库
			Connection conn=super.getConnection();
			
			//3.基于数据库连接对象java.sql.Connection,创建数据库操作对象java.sql.PreparedStatement,需绑定一个sql语句
			//此处的？表示“占位符”，下标从1开始递增
			PreparedStatement pstmt=
					conn.prepareStatement("insert into log(name,source,target,time,content) values(?,?,?,?,?)");
			
			//设置点位符的值，注意数据类型的选择
			pstmt.setString(1,log.getName());
			pstmt.setInt(2,log.getSource());
			pstmt.setInt(3,log.getTarget());
			pstmt.setTimestamp(4, log.getTime());
			pstmt.setString(5,log.getContent());
			//执行SQL语句，结果会同步到MySQL表中
			pstmt.executeUpdate();
			
			//关闭数据库连接
			super.closeConnection(conn);
			
		}
		
		
		//删除角色
		/**
		 * 删除角色
		 * @param log 表示待加的角色信息{id=1，name=访客}
		 * @throws SQLException 
		 * @throws ClassNotFoundException 
		 */
		public void delete(Log log) throws ClassNotFoundException, SQLException {
			//1.加载驱动  2.连接rbac数据库
			Connection conn=super.getConnection();
			
			//3.基于数据库连接对象java.sql.Connection,创建数据库操作对象java.sql.PreparedStatement,需绑定一个sql语句
			//此处的？表示“占位符”，下标从1开始递增
			PreparedStatement pstmt=
					conn.prepareStatement("delete from log where id=?");
			
			//设置点位符的值，注意数据类型的选择
			pstmt.setInt(1,log.getId());
			
			//执行SQL语句，结果会同步到MySQL表中
			pstmt.executeUpdate();
			
			//关闭数据库连接
			super.closeConnection(conn);
			
		}
		
		
		/**
		 * 查询消息记录，查所有
		 * @param parent 
		 * @return 把结果集中的所有记录，包装成log对象，再存放到数组中
		 * @throws ClassNotFoundException
		 * @throws SQLException
		 */
		public List<Log> findAll() throws ClassNotFoundException, SQLException {
			//定义数组
			//Log[] logs = new Log[findTotal()];   //默认每个元素均为null
			List<Log> logs = new ArrayList<Log>();
			
			Connection conn = super.getConnection();     			 //1、加载驱动 2、连接rbacpro数据库
			PreparedStatement pstmt = 								 //3、基于数据库连接对象 java.sql.Connection,创建数据库操作对象java.sql.PreparedStatement，须绑定一个SQL语句
					conn.prepareStatement("select * from log"); 	 //此处的？表示“占位符”，下标从1开始递增，须在后续设置其值													
			
			ResultSet rs = pstmt.executeQuery();	    	//4、基于数据操作对象java.sql.PreparedStatement，创建数据库结果集对象java.sql.ResultSet
			
			//通过循环遍历结果集
			while(rs.next()) {
				//每循环一次，获取指针定位的某条记录上的数据
				
				logs.add(new Log(rs.getInt("id"), rs.getString("name"), rs.getInt("source"), rs.getInt("target"), rs.getTimestamp("time"), rs.getString("content")));
			}		
			return logs;	//返回集合
		}
		
			
		/**
		 * 查询角色，查单个
		 * @param id 
		 * @return 把结果集中的所有记录，包装成log对象，再存放到数组中
		 * @throws ClassNotFoundException
		 * @throws SQLException
		 */
		public Log findById(int id) throws ClassNotFoundException, SQLException {
			Log log = new Log();
			//1、加载驱动 2、连接rbacpro数据库
			Connection conn = super.getConnection();
			
			//3、基于数据库连接对象 java.sql.Connection,创建数据库操作对象java.sql.PreparedStatement，须绑定一个SQL语句
			//此处的？表示“占位符”，下标从1开始递增，须在后续设置其值
			PreparedStatement pstmt = conn.prepareStatement("select * from log where id=?");
			pstmt.setInt(1, id);
			//4、基于数据操作对象java.sql.PreparedStatement，创建数据库结果集对象java.sql.ResultSet
			ResultSet rs = pstmt.executeQuery();
			
			//因为结果集中只有一条记录，无需循环遍历结果集，只需要让指针移动一次即可
			if(rs.next()) {
				//每循环一次，获取指针定位的某条记录上的数据
				int logid = rs.getInt("id");
				String name = rs.getString("name");
				int source = rs.getInt("source");
				int target = rs.getInt("target");
				Timestamp time = rs.getTimestamp("time");
				String content = rs.getString("content");
				log = new Log(logid,name,source,target,time,content); //把数据包装成Log实体对象
			}
			//返回数组
			return log;
		}
		
		/**
		 * 
		 * @param name  需要查找的字段名 source or target
		 * @param id    该字段的id
		 * @return
		 * @throws ClassNotFoundException
		 * @throws SQLException
		 */
		public List<Log> findAll(String name, int id) throws ClassNotFoundException, SQLException {
			//定义数组
			List<Log> logs = new ArrayList<Log>();  //默认每个元素均为null
			Connection conn = super.getConnection();     			 //1、加载驱动 2、连接rbacpro数据库
			String sql = null;
			if("source".equals(name)) {
				sql ="select * from log where source = ?";
			}else if("target".equals(name)) {
				sql ="select * from log where target = ?";
			}
			PreparedStatement pstmt = 								 //3、基于数据库连接对象 java.sql.Connection,创建数据库操作对象java.sql.PreparedStatement，须绑定一个SQL语句
					conn.prepareStatement(sql); 	 //此处的？表示“占位符”，下标从1开始递增，须在后续设置其值													
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();	    	//4、基于数据操作对象java.sql.PreparedStatement，创建数据库结果集对象java.sql.ResultSet
			
			//通过循环遍历结果集
			while(rs.next()) {
				//每循环一次，获取指针定位的某条记录上的数据
				//logs[i++] = new Log(rs.getInt("id"), rs.getString("name"),rs.getInt("parent"),rs.getString("url"));
				logs.add(new Log(rs.getInt("id"), rs.getString("name"), rs.getInt("source"), rs.getInt("target"), rs.getTimestamp("time"), rs.getString("content")));
			}
			
			return logs;	//返回数组
		}
			
		
}
