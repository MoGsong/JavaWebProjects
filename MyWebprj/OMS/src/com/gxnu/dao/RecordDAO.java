package com.gxnu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.gxnu.entity.Record;
import com.gxnu.dao.C3P0BaseDAO;
import com.gxnu.entity.Doctor;
import com.gxnu.entity.Patient;

/**
 * 病例表的CURD
 * @author 
 *
 */
public class RecordDAO extends C3P0BaseDAO{
	//添加病例
	public void add(Record record) throws ClassNotFoundException, SQLException {
		Connection conn =super.getConnection();
		PreparedStatement pstmt =conn.prepareStatement("insert into record (patient,doctor,disease,time,result,yuliu) values(?,?,?,?,?,?)");
		//设置占位符的值
		pstmt.setInt(1, record.getPatient().getId());
		pstmt.setInt(2, record.getDoctor().getId());
		pstmt.setString(3, record.getDisease());
		pstmt.setTimestamp(4, record.getTime());
		pstmt.setString(5, record.getResult());
		pstmt.setString(6, record.getYuliu());
		//执行sql语句，同步到mysql表  (这个代码很关键）
		pstmt.executeUpdate();
		//4.关闭数据库连接
		super.closeConnection(conn);
		
	}
	
	
	//修改病例
	public void merge(Record record) throws ClassNotFoundException, SQLException {
		Connection conn =super.getConnection();
		PreparedStatement pstmt =conn.prepareStatement("update record set patient=?,doctor=?,disease=?,time=?,result=?,yuliu=? where id=?");
		pstmt.setInt(1, record.getPatient().getId());
		pstmt.setInt(2, record.getDoctor().getId());
		pstmt.setString(3, record.getDisease());
		pstmt.setTimestamp(4, record.getTime());
		pstmt.setString(5, record.getResult());
		pstmt.setString(6, record.getYuliu());
		pstmt.setInt(7, record.getId());
		pstmt.executeUpdate();
		super.closeConnection(conn);
	}
	
	//删除病例
	public void delete (Record record) throws ClassNotFoundException, SQLException {
		//加载驱动，连接数据库oms
		Connection conn =super.getConnection();
		//获取数据库操作对象pstmt,并绑定mysql语句
		PreparedStatement pstmt =conn.prepareStatement("delete from record where id=?");
		//设置占位符的值
		pstmt.setInt(1,record.getId());
		//执行sql语句，同步到mysql表
		pstmt.executeUpdate();
		//关闭数据库连接
		super.closeConnection(conn);
	}
	
	
	
	//查询所有病例
	public List<Record> findAll() throws ClassNotFoundException, SQLException {
		 List<Record> records =new ArrayList<Record>();
		Connection conn =super.getConnection();
		PreparedStatement pstmt =conn.prepareStatement("select * from record");
		//4.根据数据库操作对象获取结果集对象,结果集对象存放了所有查询的结果
		ResultSet rs = pstmt.executeQuery();
		//通过next()方法让结果集中的指针向下移动一行，当移动到结果集末尾时，返回到false,否则返回true
		while(rs.next()) {
			int recordid = rs.getInt("id");//其中id为结果集字段名称
			int patientid= rs.getInt("patient");
			int doctorid= rs.getInt("doctor");
		    String disease= rs.getString("disease");//症状
		    Timestamp time=rs.getTimestamp("time");
		    String result= rs.getString("result");
		    String yuliu= rs.getString("yuliu");
			//把指针当前定位的记录信息存放到病例实体对象中
		    PatientDAO pa=new PatientDAO();
		    Patient patient=pa.findByPrimaryKey(patientid);
		    DoctorDAO doc=new DoctorDAO();
		    Doctor doctor=doc.findByPrimaryKey(doctorid);
			Record record = new Record (recordid,patient,doctor,disease,time,result,yuliu);
			//把实体对象存放到数组
			records.add(record);
		}
		//关闭数据库连接
		super.closeConnection(conn);
		return records;
	}
	
	//查询病例表中的所有记录总条数
	private int findTotal() throws ClassNotFoundException, SQLException {
		int total =0;
		Connection conn =super.getConnection();
		PreparedStatement pstmt =conn.prepareStatement("select count(*)from record");
		ResultSet rs = pstmt.executeQuery();
		//因为结果集只有一条记录，无需循环
		if(rs.next()) {
			rs.getInt(1);//此处使用字段对应的序号，作用同rs.get.Int("count(*)"
		}
		super.closeConnection(conn);
		return total;
	}
	
	//根据主键查单个病例
	public Record findById(int id) throws ClassNotFoundException, SQLException {
		Record record = new Record();
		Connection conn =super.getConnection();
		PreparedStatement pstmt =conn.prepareStatement("select * from record where id =?");
		pstmt.setInt(1, id);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			int recordid = rs.getInt("id");//其中id为结果集字段名称
			int patientid= rs.getInt("patient");
			int doctorid= rs.getInt("doctor");
		    String disease= rs.getString("disease");//症状
		    Timestamp time=rs.getTimestamp("time");
		    String result= rs.getString("result");
		    String yuliu= rs.getString("yuliu");
			//把指针当前定位的记录信息存放到病例实体对象中
		    PatientDAO pa=new PatientDAO();
		    Patient patient=pa.findByPrimaryKey(patientid);
		    DoctorDAO doc=new DoctorDAO();
		    Doctor doctor=doc.findByPrimaryKey(doctorid);
			record = new Record (recordid,patient,doctor,disease,time,result,yuliu);
			//把实体对象存放到数组
	}
		super.closeConnection(conn);
		return record;
	}	
	
	
	
	    //分页查询病例表
		public List<Record> findAll(int currentPage,int PageSize) throws ClassNotFoundException, SQLException {
			List<Record> records = new ArrayList<Record>();
			Connection conn = super.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select * from record order by id limit ?,?");
			pstmt.setInt(1, (currentPage-1)*PageSize);
			pstmt.setInt(2, PageSize);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {	
				int patientid=rs.getInt("patient");
				int doctorid=rs.getInt("doctor");
				PatientDAO patientDAO=new PatientDAO();
				Patient patient=patientDAO.findByPrimaryKey(patientid);
				DoctorDAO doctorDAO=new DoctorDAO();
				Doctor doctor=doctorDAO.findByPrimaryKey(doctorid);
				records.add(new Record(rs.getInt("id"),patient, doctor,rs.getString("disease"),rs.getTimestamp("time"),
					rs.getString("result"),rs.getString("yuliu")));
			}	
			super.closeConnection(conn);
			return records;
		}
		
		
		
	
		
}
