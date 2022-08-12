package com.gxnu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.gxnu.entity.About;
/**
* 关于医院
* @author 胖子不露小酒窝
*持久层类
*/
public class AboutDAO extends C3P0BaseDAO{
	/**
	 * 添加关于医院
	 * @param about 表示添加的关于医院信息，形如：{id=1，content=访客}
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void add(About about) throws ClassNotFoundException, SQLException {
		//1.加载驱动  2.连接rbac数据库
		Connection conn=super.getConnection();
		
		//3.基于数据库连接对象java.sql.Connection,创建数据库操作对象java.sql.PreparedStatement,需绑定一个sql语句
		//此处的？表示“占位符”，下标从1开始递增
		PreparedStatement pstmt=
				conn.prepareStatement("insert into about(name,address,synopsis,tel,pic,postcode,yuliu) values(?,?,?,?,?,?,?)");
		
		//设置点位符的值，注意数据类型的选择
		pstmt.setString(1,about.getName());
		pstmt.setString(2,about.getAddress());
		pstmt.setString(3,about.getSynopsis());
		pstmt.setString(4,about.getTel());
		pstmt.setString(5,about.getPic());
		pstmt.setString(6,about.getPostcode());
		pstmt.setString(7,about.getYuliu());
		
		//执行SQL语句，结果会同步到MySQL表中
		pstmt.executeUpdate();
		
		//关闭数据库连接
		super.closeConnection(conn);
		
	}
	

	/**
	 * 修改关于医院
	 * @param about 表示待加的关于医院信息{id=1，content=访客}
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public void update(About about) throws ClassNotFoundException, SQLException {
		//1.加载驱动  2.连接rbac数据库
		Connection conn=super.getConnection();
		
		//3.基于数据库连接对象java.sql.Connection,创建数据库操作对象java.sql.PreparedStatement,需绑定一个sql语句
		//此处的？表示“占位符”，下标从1开始递增
		PreparedStatement pstmt=
				conn.prepareStatement("update about set name=?,address=?,synopsis=?,tel=?,pic=?,postcode=?,yuliu=? where id=?");
		
		//设置点位符的值，注意数据类型的选择
		pstmt.setString(1,about.getName());
		pstmt.setString(2,about.getAddress());
		pstmt.setString(3,about.getSynopsis());
		pstmt.setString(4,about.getTel());
		pstmt.setString(5,about.getPic());
		pstmt.setString(6,about.getPostcode());
		pstmt.setString(7,about.getYuliu());
		pstmt.setInt(8, about.getId());			
		
		
		//执行SQL语句，结果会同步到MySQL表中
		pstmt.executeUpdate();
		
		//关闭数据库连接
		super.closeConnection(conn);
		
	}

	/**
	 * 删除关于医院
	 * @param about 表示待加的关于医院信息{id=1，content=访客}
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public void delete(About about) throws ClassNotFoundException, SQLException {
		//1.加载驱动  2.连接rbac数据库
		Connection conn=super.getConnection();
		
		//3.基于数据库连接对象java.sql.Connection,创建数据库操作对象java.sql.PreparedStatement,需绑定一个sql语句
		//此处的？表示“占位符”，下标从1开始递增
		PreparedStatement pstmt=
				conn.prepareStatement("delete from about where id=?");
		
		//设置点位符的值，注意数据类型的选择
		pstmt.setInt(1,about.getId());
		
		//执行SQL语句，结果会同步到MySQL表中
		pstmt.executeUpdate();
		
		//关闭数据库连接
		super.closeConnection(conn);
		
	}
	

	/**
	 * 查询关于医院，查所有
	 * @param time 
	 * @return 把结果集中的所有记录，包装成about对象，再存放到数组中
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<About> findAll() throws ClassNotFoundException, SQLException {
		List<About> abouts=new ArrayList<About>();
		
		Connection conn = super.getConnection();     			 //1、加载驱动 2、连接rbacpro数据库
		PreparedStatement pstmt = 								 //3、基于数据库连接对象 java.sql.Connection,创建数据库操作对象java.sql.PreparedStatement，须绑定一个SQL语句
				conn.prepareStatement("select * from about"); 	 //此处的？表示“占位符”，下标从1开始递增，须在后续设置其值													
		
		ResultSet rs = pstmt.executeQuery();	    	//4、基于数据操作对象java.sql.PreparedStatement，创建数据库结果集对象java.sql.ResultSet
		
		//通过循环遍历结果集
		while(rs.next()) {
			//每循环一次，获取指针定位的某条记录上的数据
			abouts.add(new About(rs.getInt("id"), rs.getString("name"),rs.getString("address"),rs.getString("synopsis"),
												rs.getString("tel"),rs.getString("pic"),rs.getString("postcode"),rs.getString("yuliu")));
		}
		return abouts;  //返回数组
	}
	
	/**
	 * 查询关于医院，查单个
	 * @param id 
	 * @return 把结果集中的所有记录，包装成about对象，再存放到数组中
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public About findByPrimaryKey(int id) throws ClassNotFoundException, SQLException {
		About about = new About();
		//1、加载驱动 2、连接rbacpro数据库
		Connection conn = super.getConnection();
		
		//3、基于数据库连接对象 java.sql.Connection,创建数据库操作对象java.sql.PreparedStatement，须绑定一个SQL语句
		//此处的？表示“占位符”，下标从1开始递增，须在后续设置其值
		PreparedStatement pstmt = conn.prepareStatement("select * from about where id=?");
		pstmt.setInt(1, id);
		
		//4、基于数据操作对象java.sql.PreparedStatement，创建数据库结果集对象java.sql.ResultSet
		ResultSet rs = pstmt.executeQuery();
		
		//因为结果集中只有一条记录，无需循环遍历结果集，只需要让指针移动一次即可
		if(rs.next()) {
			//每循环一次，获取指针定位的某条记录上的数据
			int aboutid = rs.getInt("id");  //id为字段名称 
			String name = rs.getString("name"); //content为字段名称
			String address = rs.getString("address"); //time为字段名称 = rs.getString("content"); //content为字段名称
			String synopsis = rs.getString("synopsis");
			String tel = rs.getString("tel");
			String pic = rs.getString("pic");
			String postcode = rs.getString("postcode");
			String yuliu = rs.getString("yuliu");
			
			about = new About(aboutid,name,address,synopsis,tel,pic,postcode,yuliu); //把数据包装成About实体对象
		}
		//返回数组
		return about;
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
		PreparedStatement pstmt = conn.prepareStatement("select  count(*) from about");
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
