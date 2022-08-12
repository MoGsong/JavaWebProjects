package com.gxnu.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.gxnu.entity.Doctor;
import com.gxnu.entity.ReserveCase;
import com.gxnu.service.IDoctorService;
import com.gxnu.service.imp.DoctorService;


/**
 * 可预约情况表的CURD
 * @author hjj
 *
 */

public class ReserveCaseDAO extends C3P0BaseDAO {
	/**
	 * 在可预约情况表中添加一条记录
	 * @param reservecase
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void add(ReserveCase reservecase) throws ClassNotFoundException, SQLException {
		Connection conn = super.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("insert into reserve_case(doctor,time,al_reserve) values(?,?,?)");
		pstmt.setInt(1, reservecase.getDoctor().getId());
		pstmt.setTimestamp(2, reservecase.getTime());
		pstmt.setInt(3, reservecase.getAl_reserve());
		pstmt.executeUpdate();
		super.closeConnection(conn);
	}
	
	/**
	 * 根据id删除一条预约挂号表的记录
	 * @param reservecase
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void delete(ReserveCase reservecase) throws ClassNotFoundException, SQLException {
		Connection conn = super.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("delete from reserve_case where id=?");
		pstmt.setInt(1, reservecase.getId());
		pstmt.executeUpdate();
		super.closeConnection(conn);
	}
	
	
	/**
	 * 根据id修改某一条记录信息
	 * @param reservecase
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void merger(ReserveCase reservecase) throws ClassNotFoundException, SQLException {
		Connection conn = super.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("update reserve_case set doctor=?,time=?,al_reserve=? where id=?");
		pstmt.setInt(1, reservecase.getDoctor().getId());
		pstmt.setTimestamp(2, reservecase.getTime());
		pstmt.setInt(3, reservecase.getAl_reserve());
		pstmt.setInt(4, reservecase.getId());
		pstmt.executeUpdate();
		super.closeConnection(conn);
	}
	
	/**
	 * 查询所以可预约情况
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<ReserveCase> findAll() throws ClassNotFoundException, SQLException {
		List<ReserveCase> reservecases = new ArrayList<ReserveCase>();
		Connection conn = super.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("select * from reserve_case");
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			int id = rs.getInt("id");
			int doctorid = rs.getInt("doctor");
			Timestamp time = rs.getTimestamp("time");
			int al_reserve = rs.getInt("al_reserve");
			Doctor doctor = new DoctorDAO().findByPrimaryKey(doctorid);
			reservecases.add(new ReserveCase(id, doctor, time,al_reserve));
		}
		super.closeConnection(conn);
		return reservecases;
	}
	
	
	/**
	 * 根据id查询可预约情况表中的某一条记录
	 * @param id
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public ReserveCase findById(int id) throws ClassNotFoundException, SQLException {
		ReserveCase reservecase = new ReserveCase();
		Connection conn = super.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("select * from reserve_case where id=?");
		pstmt.setInt(1, id);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			int rid = rs.getInt("id");
			int doctorid = rs.getInt("doctor");
			Timestamp time = rs.getTimestamp("time");
			int al_reserve = rs.getInt("al_reserve");
			Doctor doctor = new DoctorDAO().findByPrimaryKey(doctorid);
			reservecase = new ReserveCase(rid,doctor, time, al_reserve);
		}
		super.closeConnection(conn);
		return reservecase;
	}


}
