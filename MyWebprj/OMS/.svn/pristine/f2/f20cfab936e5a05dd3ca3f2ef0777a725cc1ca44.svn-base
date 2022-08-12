package com.gxnu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DrawDAO extends C3P0BaseDAO {
	
	//查询
	public int find(String time, int unitid) throws ClassNotFoundException, SQLException {
		//1.加载驱动  2.连接rbac数据库
		int sum = 0;
//		String sql = "select count(*) from registration where "
//				+ "DATE_FORMAT(reserve_time,'%Y-%m-%d')='2022-08-10'  "
//				+ "and doctor in(select id from doctor where unit =1 );";
	    Connection conn=super.getConnection();
	    PreparedStatement pstmt=conn.prepareStatement("select count(*) from registration where "
				+ "DATE_FORMAT(reserve_time,'%Y-%m-%d')=? "
				+ "and doctor in(select id from doctor where unit =? );");
	    pstmt.setString(1,time);
	    pstmt.setInt(2,unitid);
	    ResultSet rs = pstmt.executeQuery();
	  //通过循环遍历结果集
	  if(rs.next()) {
	  //每循环一次，获取指针定位的某条记录上的数据
	      sum = rs.getInt(1);  // 此处1为字段序号，也可以使用 count(*)为字段名称 
	  }
	  return sum;
	}

}
