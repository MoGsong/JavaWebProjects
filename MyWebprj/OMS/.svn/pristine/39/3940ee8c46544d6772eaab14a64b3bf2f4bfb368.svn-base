package com.gxnu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gxnu.entity.Post;
import com.gxnu.entity.Post;


/**
 * 职位表
 * @author 
 *
 */
public class PostDAO extends C3P0BaseDAO {
	
	//添加职位	
	public void add(Post post) throws ClassNotFoundException, SQLException {
		Connection conn=super.getConnection();
		PreparedStatement pstmt=
				conn.prepareStatement("insert into post(post,price) values(?,?)");	
		pstmt.setString(1,post.getPost());
		pstmt.setInt(2,post.getPrice());				 
		pstmt.executeUpdate();
		super.closeConnection(conn);
		
	}
	
	//修改职位
	public void update(Post post) throws ClassNotFoundException, SQLException {
		Connection conn=super.getConnection();
		PreparedStatement pstmt=
				conn.prepareStatement("update post set post=?,price=? where id=?");
		pstmt.setString(1,post.getPost());
		pstmt.setInt(2,post.getPrice());
		pstmt.setInt(3,post.getId());	
		pstmt.executeUpdate();
		super.closeConnection(conn);
		
	}
	
	//删除职位
	public void delete(Post post) throws ClassNotFoundException, SQLException {
		Connection conn=super.getConnection();
		PreparedStatement pstmt=
				conn.prepareStatement("delete from post where id=?");
		pstmt.setInt(1,post.getId());
		pstmt.executeUpdate();
		super.closeConnection(conn);
		
	}
	
	//查找所有
	public List<Post> findAll() throws ClassNotFoundException, SQLException {
		List<Post> posts = new ArrayList<Post>(); 
		int i = 0;		
		Connection conn = super.getConnection();     		
		PreparedStatement pstmt = 								 
				conn.prepareStatement("select * from post"); 													
		ResultSet rs = pstmt.executeQuery();	    	
		while(rs.next()) {
			posts.add( new Post(rs.getInt("id"), rs.getString("post"),rs.getInt("price")));					   					   			  							
		}
		super.closeConnection(conn);
		return posts;	
	}
	
	//主键查找职位
	public Post findByPrimaryKey(int id) throws ClassNotFoundException, SQLException {
		Post post = new Post();
		Connection conn = super.getConnection();
		
		//3���������ݿ����Ӷ��� java.sql.Connection,�������ݿ��������java.sql.PreparedStatement�����һ��SQL���
		//�˴��ģ���ʾ��ռλ�������±��1��ʼ��������ں���������ֵ
		PreparedStatement pstmt = conn.prepareStatement("select * from post where id=?");
		pstmt.setInt(1, id);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			
			post=new Post(rs.getInt("id"), rs.getString("post"),rs.getInt("price"));
		
		}
		
	return post;
	}
	
	//记录数据总条数
	private int findTotal() throws ClassNotFoundException, SQLException {
		int total =0;
		Connection conn = super.getConnection();
		//3���������ݿ����Ӷ��� java.sql.Connection,�������ݿ��������java.sql.PreparedStatement�����һ��SQL���
		//�˴��ģ���ʾ��ռλ�������±��1��ʼ���������ں���������ֵ
		PreparedStatement pstmt = conn.prepareStatement("select  count(*) from post");
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			total = rs.getInt(1);  
		}
		return total;
	}
}
