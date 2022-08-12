package com.gxnu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gxnu.entity.Operator;
import com.gxnu.entity.Role;



/**
 * 操作员表的CURD操作
 * @author xx
 *持久层
 */
public class OperatorDAO extends C3P0BaseDAO {
	
	/**
	 * 添加操作员,yuliu是预留
	 * @param operator 表示待添加的操作员信息{id = 1 , username = xxx, password = xxx , tel = xxx , pic = xx , yuliu = xx , role = 1}
	 * @throws SQLEception
	 * @throws ClassNotFoundException
	 */
	public void add(Operator operator) throws ClassNotFoundException,SQLException {
//		1加载驱动  2链接rbac数据库
		Connection conn = super.getConnection();
//		3基于数据库链接对象Java.sql.Connection,创建数据库操作对象java.sql.YuliuparedStatement，须绑定一个SQL语句
//		此处的？表示“占位符”，下标从1开始递增
		PreparedStatement pstmt = conn.prepareStatement("insert into operator(id,username,password,tel,pic,role,yuliu,email,status,falsetime) values(?,?,?,?,?,?,?,?,?,?)");
//		设置点位符的值，注意数据类型的选择
		pstmt.setInt(1,operator.getId());
		pstmt.setString(2,operator.getUsername());
		pstmt.setString(3,operator.getPassword());
		pstmt.setString(4,operator.getTel());
		pstmt.setString(5,operator.getPic());
		pstmt.setInt(6,operator.getRole().getId());
		pstmt.setString(7,operator.getYuliu());
		pstmt.setString(8,operator.getEmail());
		pstmt.setInt(9,operator.getStatus());
		pstmt.setInt(10,operator.getFalsetime());
//		执行SQL语句，结果会同步到mysql表中
		pstmt.executeUpdate();
//		关闭数据库链接
		super.closeConnection(conn);
	  }	

	/**
	 * 修改操作员
	 * @param operator 表示修改后的角色信息，形如：{id = 1 , username = xxx, password = xxx , tel = xxx , pic = xx , yuliu = xx , role = 1}
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
		public void merge(Operator operator) throws ClassNotFoundException, SQLException {
		//1、加载驱动 2、连接rbac数据库
		Connection conn = super.getConnection();
		//3、基于数据库连接对象 java.sql.Connection,创建数据库操作对象java.sql.YuliuparedStatement，须绑定一个SQL语句
		//此处的？表示“占位符”，下标从1开始递增，须在后续设置其值
		PreparedStatement pstmt = 
				conn.prepareStatement("update operator set username=?,password=?,tel=?,pic=?,role=?,yuliu=?,email=?,status=?,falsetime=? where id=?");
		//设置点位符的值,注意数据类型的选择
        pstmt.setString(1,operator.getUsername());
	    pstmt.setString(2,operator.getPassword());
	    pstmt.setString(3,operator.getTel());
	    pstmt.setString(4,operator.getPic());
	    pstmt.setInt(5,operator.getRole().getId());
  	    pstmt.setString(6,operator.getYuliu());
  	    pstmt.setString(7,operator.getEmail());
  	    pstmt.setInt(8,operator.getStatus());
  	    pstmt.setInt(9,operator.getFalsetime());
  	    
        pstmt.setInt(10, operator.getId());
		//执行SQL语句,结果会同步到mysql表中
		pstmt.executeUpdate();
		//关闭数据库连接
		super.closeConnection(conn);
	}

	/**
	 * 删除操作员
	 * @param operator 表示修改后的角色信息，形如：{id = 1 , username = xxx, password = xxx , tel = xxx , pic = xx , yuliu = xx , role = 1}
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public void delete(Operator operator) throws ClassNotFoundException, SQLException {
		//1、加载驱动 2、连接rbac数据库
		Connection conn = super.getConnection();
		//3、基于数据库连接对象 java.sql.Connection,创建数据库操作对象java.sql.YuliuparedStatement，须绑定一个SQL语句
		//此处的？表示“占位符”，下标从1开始递增，须在后续设置其值
		PreparedStatement pstmt = 
				conn.prepareStatement("delete from operator where id=?");
		//设置点位符的值,注意数据类型的选择
		pstmt.setInt(1, operator.getId());
		//执行SQL语句,结果会同步到mysql表中
		pstmt.executeUpdate();
		//关闭数据库连接
		super.closeConnection(conn);
	}

	/**
     * 查询所有操作员
   * findAll
      * 操作员信息{id = 1 , username = xxx, password = xxx , tel = xxx , pic = xx , role = 1,yuliu = xx }
   */
public List<Operator> findAll() throws ClassNotFoundException, SQLException {
	//定义数组
	
	List<Operator> operators = new ArrayList<Operator>();//默认每个元素都为null
	int i = 0;
	//1、加载驱动 2、连接rbac数据库
	Connection conn = super.getConnection();
	//3、基于数据库连接对象 java.sql.Connection,创建数据库操作对象java.sql.YuliuparedStatement，须绑定一个SQL语句
	PreparedStatement pstmt = conn.prepareStatement("select * from operator");
	//基于数据操作对象Java.sql.YuliuparedSatement,创建数据库结果集对象java.sql.ResultSet
	ResultSet rs = pstmt.executeQuery();
	//通过循环遍历结果集
	while(rs.next()) {
		
     operators.add(new Operator(
    		 rs.getInt("id"),
    		 rs.getString("username"),
    		 rs.getString("password"),
    		 rs.getString("tel"),
    		 rs.getString("pic"),
    		 new RoleDao().selectOne(rs.getInt("role")),
    		 rs.getString("yuliu"),
    		 rs.getString("email"),
    		 rs.getInt("status"),
    		 rs.getInt("falsetime")
    		 )); //精简版
	}
	//返回数组
	return operators;
}

	/**
	 * 查询操作员，查单个
	 * @return 把结果集中的所有记录，包装成role对象，再存放到数组中
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Operator findByPrimaryKey(int id) throws ClassNotFoundException, SQLException {
		Operator operator = new Operator();
		//1、加载驱动 2、连接rbac数据库
		Connection conn = super.getConnection();
		//3、基于数据库连接对象 java.sql.Connection,创建数据库操作对象java.sql.YuliuparedStatement，须绑定一个SQL语句
		//此处的？表示“占位符”，下标从1开始递增，须在后续设置其值
		PreparedStatement pstmt = conn.prepareStatement("select * from operator where id=?");
		pstmt.setInt(1,id);
		//4、基于数据操作对象java.sql.YuliuparedStatement，创建数据库结果集对象java.sql.ResultSet
		ResultSet rs = pstmt.executeQuery();
		
		//因为结果集中只有一条记录，无需循环遍历结果集，只需要让指针移动一次即可
		if(rs.next()) {
			//每循环一次，获取指针定位的某条记录上的数据
			int operatorid = rs.getInt("id");  //id为字段名称 
	        String username = rs.getString("username");//name为字段名称
	        String password = rs.getString("password");
	        String tel = rs.getString("tel");
	        String pic = rs.getString("pic");
	        String yuliu = rs.getString("yuliu");
	        String email = rs.getString("email");
	        int status = rs.getInt("status");
	        int falsetime = rs.getInt("falsetime");
	        
	        Role role = new RoleDao().selectOne(rs.getInt("role"));//因为操作员表关联角色表，所以要额外查询
	        operator = new Operator(operatorid,username,password,tel,pic,role,yuliu,email,status,falsetime); //把数据包装成Operator实体对象
		}
		//返回数组
		return operator;
	}
	
/**
* 查询数组中记录的条数
* findTotal
* 
*/
private int findTotal() throws ClassNotFoundException, SQLException{
	        int total = 0;
	        //1、加载驱动 2、连接rbac数据库
			Connection conn = super.getConnection();
			//3、基于数据库连接对象 java.sql.Connection,创建数据库操作对象java.sql.YuliuparedStatement，须绑定一个SQL语句
			PreparedStatement pstmt = conn.prepareStatement("select count(*) from operator");
			//基于数据操作对象Java.sql.YuliuparedSatement,创建数据库结果集对象java.sql.ResultSet
			ResultSet rs = pstmt.executeQuery();
			//通过循环遍历结果集
			if(rs.next()) {
				total = rs.getInt(1);
				
			}
			return total;
}
}



