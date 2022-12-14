package com.gxnu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gxnu.entity.Dialogue;

public class DialogueDAO extends C3P0BaseDAO{
	/**
	 * 添加消息记录
	 * @param dialogue 表示添加的消息记录信息，形如：{id=1，name=访客}
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void add(Dialogue dialogue) throws ClassNotFoundException, SQLException {
		//1.加载驱动  2.连接rbac数据库
		Connection conn=super.getConnection();
		
		//3.基于数据库连接对象java.sql.Connection,创建数据库操作对象java.sql.PreparedStatement,需绑定一个sql语句
		//此处的？表示“占位符”，下标从1开始递增
		PreparedStatement pstmt=
				conn.prepareStatement("insert into dialogue(name,host,guest,ip) values(?,?,?,?)");
		
		//设置点位符的值，注意数据类型的选择
		pstmt.setString(1,dialogue.getName());
		pstmt.setInt(2,dialogue.getHost());
		pstmt.setInt(3,dialogue.getGuest());
		pstmt.setString(1,dialogue.getIp());
		//执行SQL语句，结果会同步到MySQL表中
		pstmt.executeUpdate();
		
		//关闭数据库连接
		super.closeConnection(conn);
		
	}
	
	
	//删除对话hua
	/**
	 * 删除对话hua
	 * @param dialogue 表示待加的对话hua信息{id=1，name=访客}
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public void delete(Dialogue dialogue) throws ClassNotFoundException, SQLException {
		//1.加载驱动  2.连接rbac数据库
		Connection conn=super.getConnection();
		
		//3.基于数据库连接对象java.sql.Connection,创建数据库操作对象java.sql.PreparedStatement,需绑定一个sql语句
		//此处的？表示“占位符”，下标从1开始递增
		PreparedStatement pstmt=
				conn.prepareStatement("delete from dialogue where id=?");
		
		//设置点位符的值，注意数据类型的选择
		pstmt.setInt(1,dialogue.getId());
		
		//执行SQL语句，结果会同步到MySQL表中
		pstmt.executeUpdate();
		
		//关闭数据库连接
		super.closeConnection(conn);
		
	}
	
	
	/**
	 * 查询消息记录，查所有
	 * @param parent 
	 * @return 把结果集中的所有记录，包装成dialogue对象，再存放到数组中
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<Dialogue> findAll() throws ClassNotFoundException, SQLException {
		//定义数组
		//Dialogue[] dialogues = new Dialogue[findTotal()];   //默认每个元素均为null
		List<Dialogue> dialogues = new ArrayList<Dialogue>();
		
		Connection conn = super.getConnection();     			 //1、加载驱动 2、连接rbacpro数据库
		PreparedStatement pstmt = 								 //3、基于数据库连接对象 java.sql.Connection,创建数据库操作对象java.sql.PreparedStatement，须绑定一个SQL语句
				conn.prepareStatement("select * from dialogue"); 	 //此处的？表示“占位符”，下标从1开始递增，须在后续设置其值													
		
		ResultSet rs = pstmt.executeQuery();	    	//4、基于数据操作对象java.sql.PreparedStatement，创建数据库结果集对象java.sql.ResultSet
		
		//通过循环遍历结果集
		while(rs.next()) {
			//每循环一次，获取指针定位的某条记录上的数据
			
			dialogues.add(new Dialogue(rs.getInt("id"), rs.getString("name"), rs.getInt("host"), rs.getInt("guest"),rs.getString("ip")));
		}		
		return dialogues;	//返回集合
	}
	
		
	/**
	 * 查询对话，查单个
	 * @param id 
	 * @return 把结果集中的所有记录，包装成dialogue对象，再存放到数组中
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Dialogue findById(int id) throws ClassNotFoundException, SQLException {
		Dialogue dialogue = new Dialogue();
		//1、加载驱动 2、连接rbacpro数据库
		Connection conn = super.getConnection();
		
		//3、基于数据库连接对象 java.sql.Connection,创建数据库操作对象java.sql.PreparedStatement，须绑定一个SQL语句
		//此处的？表示“占位符”，下标从1开始递增，须在后续设置其值
		PreparedStatement pstmt = conn.prepareStatement("select * from dialogue where id=?");
		pstmt.setInt(1, id);
		//4、基于数据操作对象java.sql.PreparedStatement，创建数据库结果集对象java.sql.ResultSet
		ResultSet rs = pstmt.executeQuery();
		
		//因为结果集中只有一条记录，无需循环遍历结果集，只需要让指针移动一次即可
		if(rs.next()) {
			//每循环一次，获取指针定位的某条记录上的数据
			int dialogueid = rs.getInt("id");
			String name = rs.getString("name");
			int host = rs.getInt("host");
			int guest = rs.getInt("guest");
			String ip = rs.getString("ip");
			dialogue = new Dialogue(dialogueid,name,host,guest,ip); //把数据包装成Diadialogueue实体对象
		}
		//返回数组
		return dialogue;
	}
	
	public Dialogue find(int host, int guest) throws ClassNotFoundException, SQLException {
		Dialogue dialogue = new Dialogue();
		//1、加载驱动 2、连接rbacpro数据库
		Connection conn = super.getConnection();
		
		//3、基于数据库连接对象 java.sql.Connection,创建数据库操作对象java.sql.PreparedStatement，须绑定一个SQL语句
		//此处的？表示“占位符”，下标从1开始递增，须在后续设置其值
		PreparedStatement pstmt = conn.prepareStatement("select * from dialogue where host=? AND guest=?");
		pstmt.setInt(1, host);
		pstmt.setInt(1, guest);
		//4、基于数据操作对象java.sql.PreparedStatement，创建数据库结果集对象java.sql.ResultSet
		ResultSet rs = pstmt.executeQuery();
		
		//因为结果集中只有一条记录，无需循环遍历结果集，只需要让指针移动一次即可
		if(rs.next()) {
			//每循环一次，获取指针定位的某条记录上的数据
			int dialogueid = rs.getInt("id");
			String name = rs.getString("name");
			String ip = rs.getString("ip");
			dialogue = new Dialogue(dialogueid,name,host,guest,ip); //把数据包装成Dialogue实体对象
		}
		//返回数组
		return dialogue;
	}
	
	
	/**
	 * 
	 * @param name  需要查找的字段名 host or guest
	 * @param id    该字段的id
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<Dialogue> findAll(String name, int id) throws ClassNotFoundException, SQLException {
		//定义数组
		List<Dialogue> dialogues = new ArrayList<Dialogue>();  //默认每个元素均为null
		Connection conn = super.getConnection();     			 //1、加载驱动 2、连接rbacpro数据库
		String sql = null;
		if("source".equals(name)) {
			sql ="select * from dialogue where host = ?";
		}else if("target".equals(name)) {
			sql ="select * from dialogue where guest = ?";
		}
		PreparedStatement pstmt = 								 //3、基于数据库连接对象 java.sql.Connection,创建数据库操作对象java.sql.PreparedStatement，须绑定一个SQL语句
				conn.prepareStatement(sql); 	 //此处的？表示“占位符”，下标从1开始递增，须在后续设置其值													
		pstmt.setInt(1, id);
		ResultSet rs = pstmt.executeQuery();	    	//4、基于数据操作对象java.sql.PreparedStatement，创建数据库结果集对象java.sql.ResultSet
		
		//通过循环遍历结果集
		while(rs.next()) {
			//每循环一次，获取指针定位的某条记录上的数据
			//dialogues[i++] = new Dialogue(rs.getInt("id"), rs.getString("name"),rs.getInt("parent"),rs.getString("url"));
			dialogues.add(new Dialogue(rs.getInt("id"), rs.getString("name"), rs.getInt("host"), rs.getInt("guest"),rs.getString("ip")));
		}
		
		return dialogues;	//返回数组
	}
	
}
