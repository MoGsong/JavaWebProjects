package com.gxnu.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gxnu.entity.Article;


/**
 * Article表的CURD操作
 * @author xx
 *持久层
 */
public class ArticleDAO extends C3P0BaseDAO {
	
	/**
	 * 添加Article
	 * @param article 表示待添加的Article信息{id = 1 , name = 访客}
	 * @throws SQLEception
	 * @throws ClassNotFoundException
	 */
	public void add(Article article) throws ClassNotFoundException,SQLException {
//		1加载驱动  2链接rbac数据库
		Connection conn = super.getConnection();
//		3基于数据库链接对象Java.sql.Connection,创建数据库操作对象java.sql.PreparedStatement，须绑定一个SQL语句
//		此处的？表示“占位符”，下标从1开始递增
		PreparedStatement pstmt = conn.prepareStatement("insert into article(title,content,pic,author,time) values(?,?,?,?,?)");
//		设置点位符的值，注意数据类型的选择
		pstmt.setString(1,article.getTitle());
		pstmt.setString(2,article.getContent());
		pstmt.setString(3,article.getPic());
		pstmt.setString(4,article.getAuthor());		
		pstmt.setTimestamp(5,article.getTime());
		
		
//		执行SQL语句，结果会同步到mysql表中
		pstmt.executeUpdate();
//		关闭数据库链接
		super.closeConnection(conn);
	  }	

	/**
	 * 修改Article
	 * @param article 表示修改后的Article信息，形如：{id=3,name=超管}
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
		public void merge(Article article) throws ClassNotFoundException, SQLException {
		//1、加载驱动 2、连接rbac数据库
		Connection conn = super.getConnection();
		//3、基于数据库连接对象 java.sql.Connection,创建数据库操作对象java.sql.PreparedStatement，须绑定一个SQL语句
		//此处的？表示“占位符”，下标从1开始递增，须在后续设置其值
    	PreparedStatement pstmt = 
				conn.prepareStatement("update article set title=?,content=?,pic=?,author=?,time=? where id=?");
		//设置点位符的值,注意数据类型的选择
		pstmt.setString(1,article.getTitle());
		pstmt.setString(2,article.getContent());
		pstmt.setString(3,article.getPic());
		pstmt.setString(4,article.getAuthor());		
		pstmt.setTimestamp(5,article.getTime());
		pstmt.setInt(6,article.getId());
		//执行SQL语句,结果会同步到mysql表中
		pstmt.executeUpdate();
		//关闭数据库连接
		super.closeConnection(conn);
	}

	/**
	 * 删除Article
	 * delete
	 * @param article 表示修改后的Article信息，形如：{id=3,name=超管}
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public void delete(Article article) throws ClassNotFoundException, SQLException {
		//1、加载驱动 2、连接rbac数据库
		Connection conn = super.getConnection();
		//3、基于数据库连接对象 java.sql.Connection,创建数据库操作对象java.sql.PreparedStatement，须绑定一个SQL语句
		//此处的？表示“占位符”，下标从1开始递增，须在后续设置其值
		PreparedStatement pstmt = 
				conn.prepareStatement("delete from article where id=?");
		//设置点位符的值,注意数据类型的选择
		pstmt.setInt(1, article.getId());
		//执行SQL语句,结果会同步到mysql表中
		pstmt.executeUpdate();
		//关闭数据库连接
		super.closeConnection(conn);
	}

   /**
         * 查询Article，查所有
     * findAll
     */
	public List<Article> findAll() throws ClassNotFoundException, SQLException {
		////定义数组
		List<Article> articles = new ArrayList<Article>();//默认每个元素都为null
		int i = 0;
		//1、加载驱动 2、连接rbac数据库
		Connection conn = super.getConnection();
		//3、基于数据库连接对象 java.sql.Connection,创建数据库操作对象java.sql.PreparedStatement，须绑定一个SQL语句
		PreparedStatement pstmt = conn.prepareStatement("select * from article");
		//基于数据操作对象Java.sql.PreparedSatement,创建数据库结果集对象java.sql.ResultSet
		ResultSet rs = pstmt.executeQuery();
		//通过循环遍历结果集
		while(rs.next()) {
			//每循环一次，获取指针定位的记录上的数据
			/*
			int id = rs.getInt("id");//id为字段名称
			String name = rs.getString("name");//name为字段名称
			Article article = new Article(id, name);//把数据包装成Article实体对象
			articles[i] = article;
			i++;
			*/
			articles.add(new Article
					(rs.getInt("id"),
					rs.getString("title"),
					rs.getString("content"),
					rs.getString("pic"),
					rs.getString("author"),
					rs.getTimestamp("time")
					
					));
		}
		//返回数组
		return articles;
}
		
	/**
	 * 查询Article，查单个
	 * @return 把结果集中的所有记录，包装成article对象，再存放到数组中
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Article findByPrimaryKey(int id) throws ClassNotFoundException, SQLException {
		Article article = new Article();
		//1、加载驱动 2、连接rbac数据库
		Connection conn = super.getConnection();
		//3、基于数据库连接对象 java.sql.Connection,创建数据库操作对象java.sql.PreparedStatement，须绑定一个SQL语句
		//此处的？表示“占位符”，下标从1开始递增，须在后续设置其值
		PreparedStatement pstmt = conn.prepareStatement("select * from article where id=?");
		pstmt.setInt(1,id);
		//4、基于数据操作对象java.sql.PreparedStatement，创建数据库结果集对象java.sql.ResultSet
		ResultSet rs = pstmt.executeQuery();
		
		//因为结果集中只有一条记录，无需循环遍历结果集，只需要让指针移动一次即可
		if(rs.next()) {
		article =	new Article(rs.getInt("id"),rs.getString("title"),rs.getString("content"),
				rs.getString("pic"),rs.getString("author"),rs.getTimestamp("time"));
			
		}
		//返回数组
		return article;
	}
	
	/**
	 * 查询分页记录
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<Article> findAll(int currentPage,int pageSize) throws ClassNotFoundException, SQLException {
		//PageBean[] emailInfos = new PageBean[findTotal()]; //创建数组，用于存放所查询所有的角色对象,findTotal()根据表的数据条数创建相应的数组空间
		List<Article> articles = new ArrayList<Article>();
		//int i=0;
		Connection conn = super.getConnection();
		PreparedStatement pstmt =conn.prepareStatement("select * from article order by id limit ?,? ");
		pstmt.setInt(1, (currentPage-1)*pageSize);
		pstmt.setInt(2, pageSize);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			
			
			articles.add(new Article(rs.getInt("id"),
					rs.getString("title"),
					rs.getString("content"),
					rs.getString("pic"),
					rs.getString("author"),
					rs.getTimestamp("time")
					));
		}
		super.closeConnection(conn);
		return articles;
	}
}