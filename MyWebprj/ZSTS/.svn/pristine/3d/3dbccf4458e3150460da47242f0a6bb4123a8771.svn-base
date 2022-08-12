package com.gxnu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gxnu.entity.Menu;


/**
* 
* @author 胖子不露小酒窝
*持久层类
*/
public class MenuDAO extends C3P0BaseDAO{
	/**
	 * 添加菜单
	 * @param menu 表示添加的菜单信息，形如：{id=1，name=访客}
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void add(Menu menu) throws ClassNotFoundException, SQLException {
		//1.加载驱动  2.连接rbac数据库
		Connection conn=super.getConnection();
		
		//3.基于数据库连接对象java.sql.Connection,创建数据库操作对象java.sql.PreparedStatement,需绑定一个sql语句
		//此处的？表示“占位符”，下标从1开始递增
		PreparedStatement pstmt=
				conn.prepareStatement("insert into menu(name,parent,URL,yuliu) values(?,?,?,?)");
		
		//设置点位符的值，注意数据类型的选择
		pstmt.setString(1,menu.getName());
		pstmt.setInt(2,menu.getParent());
		pstmt.setString(3,menu.getURL());
		pstmt.setString(4,menu.getYuliu());
		
		//执行SQL语句，结果会同步到MySQL表中
		pstmt.executeUpdate();
		
		//关闭数据库连接
		super.closeConnection(conn);
		
	}
	

	/**
	 * 修改角色
	 * @param menu 表示待加的角色信息{id=1，name=访客}
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public void merge(Menu menu) throws ClassNotFoundException, SQLException {
		//1.加载驱动  2.连接rbac数据库
		Connection conn=super.getConnection();
		
		//3.基于数据库连接对象java.sql.Connection,创建数据库操作对象java.sql.PreparedStatement,需绑定一个sql语句
		//此处的？表示“占位符”，下标从1开始递增
		PreparedStatement pstmt=
				conn.prepareStatement("update menu set name=?,parent=?,URL=?,yuliu=? where id=?");
		
		//设置点位符的值，注意数据类型的选择
		pstmt.setString(1,menu.getName());
		pstmt.setInt(2,menu.getParent());
		pstmt.setString(3,menu.getURL());
		pstmt.setInt(4, menu.getId());
		pstmt.setString(5, menu.getYuliu());
		
		//执行SQL语句，结果会同步到MySQL表中
		pstmt.executeUpdate();
		
		//关闭数据库连接
		super.closeConnection(conn);
		
	}

	/**
	 * 删除角色
	 * @param menu 表示待加的角色信息{id=1，name=访客}
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public void delete(Menu menu) throws ClassNotFoundException, SQLException {
		//1.加载驱动  2.连接rbac数据库
		Connection conn=super.getConnection();
		
		//3.基于数据库连接对象java.sql.Connection,创建数据库操作对象java.sql.PreparedStatement,需绑定一个sql语句
		//此处的？表示“占位符”，下标从1开始递增
		PreparedStatement pstmt=
				conn.prepareStatement("delete from menu where id=?");
		
		//设置点位符的值，注意数据类型的选择
		pstmt.setInt(1,menu.getId());
		
		//执行SQL语句，结果会同步到MySQL表中
		pstmt.executeUpdate();
		
		//关闭数据库连接
		super.closeConnection(conn);
		
	}
	

	/**
	 * 查询菜单，查所有
	 * @param parent 
	 * @return 把结果集中的所有记录，包装成menu对象，再存放到数组中
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
//	public Menu[] findAll() throws ClassNotFoundException, SQLException {
	public List<Menu> findAll() throws ClassNotFoundException, SQLException {
		//定义数组
//		Menu[] menus = new Menu[findTotal()];   //默认每个元素均为null
//		int i = 0;
		List<Menu> menus=new ArrayList<Menu>();
		
		Connection conn = super.getConnection();     			 //1、加载驱动 2、连接rbacpro数据库
		PreparedStatement pstmt = 								 //3、基于数据库连接对象 java.sql.Connection,创建数据库操作对象java.sql.PreparedStatement，须绑定一个SQL语句
				conn.prepareStatement("select * from menu"); 	 //此处的？表示“占位符”，下标从1开始递增，须在后续设置其值													
		
		ResultSet rs = pstmt.executeQuery();	    	//4、基于数据操作对象java.sql.PreparedStatement，创建数据库结果集对象java.sql.ResultSet
		
		//通过循环遍历结果集
		while(rs.next()) {
			//每循环一次，获取指针定位的某条记录上的数据
			/*
			int id = rs.getInt("id");  //id为字段名称 
			String name = rs.getString("name"); //name为字段名称
			Menu menu = new Menu(id, name); //把数据包装成Menu实体对象
			menus[i] = menu;
			i++;
			*/
			
//			menus[i++] = new Menu(rs.getInt("id"), rs.getString("name"),rs.getInt("parent"),rs.getString("URL"));
			menus.add(new Menu(rs.getInt("id"), rs.getString("name"),rs.getInt("parent"),rs.getString("URL"), null));
		}
		
		return menus;	//返回数组
	}
	
	/**
	 * 查询角色，查单个
	 * @param id 
	 * @return 把结果集中的所有记录，包装成menu对象，再存放到数组中
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Menu findByPrimaryKey(int id) throws ClassNotFoundException, SQLException {
		Menu menu = new Menu();
		//1、加载驱动 2、连接rbacpro数据库
		Connection conn = super.getConnection();
		
		//3、基于数据库连接对象 java.sql.Connection,创建数据库操作对象java.sql.PreparedStatement，须绑定一个SQL语句
		//此处的？表示“占位符”，下标从1开始递增，须在后续设置其值
		PreparedStatement pstmt = conn.prepareStatement("select * from menu where id=?");
		pstmt.setInt(1, id);
		
		//4、基于数据操作对象java.sql.PreparedStatement，创建数据库结果集对象java.sql.ResultSet
		ResultSet rs = pstmt.executeQuery();
		
		//因为结果集中只有一条记录，无需循环遍历结果集，只需要让指针移动一次即可
		if(rs.next()) {
			//每循环一次，获取指针定位的某条记录上的数据
			int menuid = rs.getInt("id");  //id为字段名称 
			String name = rs.getString("name"); //name为字段名称
			int parent = rs.getInt("parent"); //parent为字段名称 = rs.getString("name"); //name为字段名称
			String URL = rs.getString("URL"); //name为字段名称
			String yuliu = rs.getString("yuliu");
			menu = new Menu(menuid,name,parent,URL,yuliu); //把数据包装成Menu实体对象
		}
		//返回数组
		return menu;
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
		PreparedStatement pstmt = conn.prepareStatement("select  count(*) from menu");
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
	 * 查询菜单，根据parent字段查询所有菜单，若parent=0，则得到的是所有父菜单
	 * @param parent
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<Menu> findAll(int parent) throws ClassNotFoundException, SQLException {
		//定义数组
		List<Menu> menus = new ArrayList<Menu>();   //默认每个元素均为null
		//int i = 0;
		System.out.println("id");
		Connection conn = super.getConnection();     			 //1、加载驱动 2、连接rbacpro数据库
		PreparedStatement pstmt = 								 //3、基于数据库连接对象 java.sql.Connection,创建数据库操作对象java.sql.PreparedStatement，须绑定一个SQL语句
				conn.prepareStatement("select * from menu where parent=?"); 	 //此处的？表示“占位符”，下标从1开始递增，须在后续设置其值													
		pstmt.setInt(1, parent);
		
		ResultSet rs = pstmt.executeQuery();	    	//4、基于数据操作对象java.sql.PreparedStatement，创建数据库结果集对象java.sql.ResultSet
		
		//通过循环遍历结果集
		while(rs.next()) {
		
			//每循环一次，获取指针定位的某条记录上的数据
			/*
			int id = rs.getInt("id");  //id为字段名称 
			String name = rs.getString("name"); //name为字段名称
			Menu menu = new Menu(id, name); //把数据包装成Menu实体对象
			menus[i] = menu;
			i++;
			*/
			
			menus.add(new Menu(rs.getInt("id"), rs.getString("name"),rs.getInt("parent"),rs.getString("URL"),rs.getString("yuliu")));
		}
		
		return menus;	//返回数组
	}
	
	/**
	 * 查询表中记录（条件查询）
	 * @param parent
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	private int findTotal(int parent) throws ClassNotFoundException, SQLException {
		int total =0;
		//1、加载驱动 2、连接rbacpro数据库
		Connection conn = super.getConnection();
		
		//3、基于数据库连接对象 java.sql.Connection,创建数据库操作对象java.sql.PreparedStatement，须绑定一个SQL语句
		//此处的？表示“占位符”，下标从1开始递增，须在后续设置其值
		PreparedStatement pstmt = conn.prepareStatement("select  count(*) from menu where parent=?");
		pstmt.setInt(1, parent);
		
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
	 * 分页查询
	 * @return
	 */
	public List<Menu> findAll(int currentPage,int pageSize) throws ClassNotFoundException, SQLException {
		List<Menu> menus = new ArrayList<Menu>();
		
		Connection conn = super.getConnection();     			 //1、加载驱动 2、连接rbacpro数据库
		PreparedStatement pstmt = 								 //3、基于数据库连接对象 java.sql.Connection,创建数据库操作对象java.sql.PreparedStatement，须绑定一个SQL语句
				conn.prepareStatement("select * from menu limit ?,?"); 	 //此处的？表示“占位符”，下标从1开始递增，须在后续设置其值													
		pstmt.setInt(1, (currentPage-1)*pageSize);
		pstmt.setInt(2, pageSize);
		ResultSet rs = pstmt.executeQuery();	    	//4、基于数据操作对象java.sql.PreparedStatement，创建数据库结果集对象java.sql.ResultSet
		
		//通过循环遍历结果集
		while(rs.next()) {
						menus.add(new Menu(rs.getInt("id"), rs.getString("name"),rs.getInt("parent"),rs.getString("URL"),
							              				rs.getString("yuliu")));
		}
		
		return menus;	//返回数组
	}
}
