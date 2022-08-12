package com.gxnu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gxnu.entity.Doctor;
import com.gxnu.entity.Doctor;


/**
 * ����Ա��CURD����
 * @author ���Ӳ�¶С����
 *
 */
public class DoctorDAO extends C3P0BaseDAO {
	
	//��Ӳ���Ա
	/**
	 * ��Ӳ���Ա
	 * @param doctor ��ʾ���ӵĲ���Ա��Ϣ{id=1��name=�ÿ�}
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public void add(Doctor doctor) throws ClassNotFoundException, SQLException {
		//1.��������  2.����rbac���ݿ�
		Connection conn=super.getConnection();
		
		//3.�������ݿ����Ӷ���java.sql.Connection,�������ݿ��������java.sql.PreparedStatement,���һ��sql���
		//�˴��ģ���ʾ��ռλ�������±��1��ʼ����
		PreparedStatement pstmt=
				conn.prepareStatement("insert into doctor(name,sex,age,username,password,unit,post,tel,pic,yuliu,email) values(?,?,?,?,?,?,?,?,?,?,?)");
		
		//���õ�λ����ֵ��ע���������͵�ѡ��
		
		pstmt.setString(1,doctor.getName());
		pstmt.setString(2,doctor.getSex());
		pstmt.setInt(3,doctor.getAge());
		pstmt.setString(4,doctor.getUsername());
		pstmt.setString(5,doctor.getPassword());
		//pstmt.setInt(6,doctor.getUnit());//���
		pstmt.setInt(6,doctor.getUnit().getId());//������	
		pstmt.setInt(7,doctor.getPost().getId());	//������		
		pstmt.setString(8,doctor.getTel());		
		pstmt.setString(9,doctor.getPic());		
		pstmt.setString(10,doctor.getYuliu());				
		pstmt.setString(11,doctor.getEmail());	
			 
		//ִ��SQL��䣬�����ͬ����MySQL����
		pstmt.executeUpdate();
		
		//�ر����ݿ�����
		super.closeConnection(conn);
		
	}
	
	
	//�޸Ĳ���Ա
	/**
	 * �޸Ĳ���Ա
	 * @param doctor ��ʾ���ӵĲ���Ա��Ϣ{id=1��name=�ÿ�}
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public void update(Doctor doctor) throws ClassNotFoundException, SQLException {
		//1.��������  2.����rbac���ݿ�
		Connection conn=super.getConnection();
		
		//3.�������ݿ����Ӷ���java.sql.Connection,�������ݿ��������java.sql.PreparedStatement,���һ��sql���
		//�˴��ģ���ʾ��ռλ�������±��1��ʼ����
		PreparedStatement pstmt=
				conn.prepareStatement("update doctor set name=?,sex=?,age=?,username=?,password=?,unit=?,post=?,tel=?,pic=?,yuliu=?,email=? where id=?");
		
		//���õ�λ����ֵ��ע���������͵�ѡ��
		pstmt.setString(1,doctor.getName());
		pstmt.setString(2,doctor.getSex());
		pstmt.setInt(3,doctor.getAge());
		pstmt.setString(4,doctor.getUsername());
		pstmt.setString(5,doctor.getPassword());
		pstmt.setInt(6,doctor.getUnit().getId());	
		pstmt.setInt(7,doctor.getPost().getId());	//������						
		pstmt.setString(8,doctor.getTel());		
		pstmt.setString(9,doctor.getPic());		
		pstmt.setString(10,doctor.getYuliu());				
		pstmt.setString(11,doctor.getEmail());	
		pstmt.setInt(12,doctor.getId());	
		//pstmt.setInt(5,doctor.getRole().getId());  //�����������Ի�ȡ���������е���ϸ��Ϣ		
		//ִ��SQL��䣬�����ͬ����MySQL����
		pstmt.executeUpdate();
		
		//�ر����ݿ�����
		super.closeConnection(conn);
		
	}
	
	//ɾ������Ա
	/**
	 * ɾ������Ա
	 * @param doctor ��ʾ���ӵĲ���Ա��Ϣ{id=1��name=�ÿ�}
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public void delete(Doctor doctor) throws ClassNotFoundException, SQLException {
		//1.��������  2.����rbac���ݿ�
		Connection conn=super.getConnection();
		
		//3.�������ݿ����Ӷ���java.sql.Connection,�������ݿ��������java.sql.PreparedStatement,���һ��sql���
		//�˴��ģ���ʾ��ռλ�������±��1��ʼ����
		PreparedStatement pstmt=
				conn.prepareStatement("delete from doctor where id=?");
		
		//���õ�λ����ֵ��ע���������͵�ѡ��
		pstmt.setInt(1,doctor.getId());
		
		//ִ��SQL��䣬�����ͬ����MySQL����
		pstmt.executeUpdate();
		
		//�ر����ݿ�����
		super.closeConnection(conn);
		
	}
	
	//��ѯ����Ա
	/**
	 * ��ѯ����Ա��������
	 * @return �ѽ�����е����м�¼����װ��doctor�����ٴ�ŵ�������
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<Doctor> findAll() throws ClassNotFoundException, SQLException {
		//��������
		List<Doctor> doctors = new ArrayList<Doctor>();   //Ĭ��ÿ��Ԫ�ؾ�Ϊnull
		int i = 0;		
		Connection conn = super.getConnection();     			 //1���������� 2������rbacpro���ݿ�
		PreparedStatement pstmt = 								 //3���������ݿ����Ӷ��� java.sql.Connection,�������ݿ��������java.sql.PreparedStatement�����һ��SQL���
				conn.prepareStatement("select * from doctor"); 	 //�˴��ģ���ʾ��ռλ�������±��1��ʼ���������ں���������ֵ													
		ResultSet rs = pstmt.executeQuery();	    	//4���������ݲ�������java.sql.PreparedStatement���������ݿ���������java.sql.ResultSet
		
		//ͨ��ѭ�����������
		while(rs.next()) {
			//ÿѭ��һ�Σ���ȡָ�붨λ��ĳ����¼�ϵ�����
			/*
			int id = rs.getInt("id");  //idΪ�ֶ����� 
			String name = rs.getString("name"); //nameΪ�ֶ�����
			Doctor doctor = new Doctor(id, name); //�����ݰ�װ��Doctorʵ�����
			doctors[i] = doctor;
			i++;
			*/
			
			/*Role role=new Role();  //{id=0,name=null;}
			RoleDAO roleDAO=new RoleDAO();
			role=roleDAO.findByPrimaryKey(rs.getInt("role");
			*/
			//Role role=new RoleDAO().findByPrimaryKey(rs.getInt("role"));
			doctors.add( new Doctor(rs.getInt("id"),
					   rs.getString("name"),
					   rs.getString("sex"),
					   rs.getInt("age"),
					   rs.getString("username"),
					   rs.getString("password"),
					   new UnitDAO().findById(rs.getInt("unit")),
					   new PostDAO().findByPrimaryKey(rs.getInt("post")),					 
					   rs.getString("pic"),
					   rs.getString("tel"),
					   rs.getString("email"),
					   rs.getString("yuliu")));		
			
			
		}
		super.closeConnection(conn);
		return doctors;	//��������
	}
	
	/**
	 * ��ѯ����Ա���鵥��
	 * @return �ѽ�����е����м�¼����װ��doctor�����ٴ�ŵ�������
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Doctor findByPrimaryKey(int id) throws ClassNotFoundException, SQLException {
		Doctor doctor = new Doctor();
		//1���������� 2������rbacpro���ݿ�
		Connection conn = super.getConnection();
		
		//3���������ݿ����Ӷ��� java.sql.Connection,�������ݿ��������java.sql.PreparedStatement�����һ��SQL���
		//�˴��ģ���ʾ��ռλ�������±��1��ʼ���������ں���������ֵ
		PreparedStatement pstmt = conn.prepareStatement("select * from doctor where id=?");
		pstmt.setInt(1, id);
		
		//4���������ݲ�������java.sql.PreparedStatement���������ݿ���������java.sql.ResultSet
		ResultSet rs = pstmt.executeQuery();
		
		//��Ϊ�������ֻ��һ����¼������ѭ�������������ֻ��Ҫ��ָ���ƶ�һ�μ���
		if(rs.next()) {
		
			 doctor= new Doctor(rs.getInt("id"),
					   rs.getString("name"),
					   rs.getString("sex"),
					   rs.getInt("age"),
					   rs.getString("username"),
					   rs.getString("password"),
					   new UnitDAO().findById(rs.getInt("unit")),
					   new PostDAO().findByPrimaryKey(rs.getInt("post")),					 
					   rs.getString("pic"),
					   rs.getString("tel"),
					   rs.getString("email"),
					   rs.getString("yuliu"));		
			
			
			 //�����ݰ�װ��Doctorʵ�����
		}
		//��������
	return doctor;
	}
	
	
	/**
	 * 通过科室id查找医生
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<Doctor> findByUnitId(int unitId) throws ClassNotFoundException, SQLException {
		//��������
		List<Doctor> doctors = new ArrayList<Doctor>();   //Ĭ��ÿ��Ԫ�ؾ�Ϊnull
		int i = 0;		
		Connection conn = super.getConnection();     			 //1���������� 2������rbacpro���ݿ�
		PreparedStatement pstmt=
				conn.prepareStatement("select * from doctor where unit=?");
		pstmt.setInt(1,unitId);
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			doctors.add( new Doctor(rs.getInt("id"),
					   rs.getString("name"),
					   rs.getString("sex"),
					   rs.getInt("age"),
					   rs.getString("username"),
					   rs.getString("password"),
					   new UnitDAO().findById(rs.getInt("unit")),
					   new PostDAO().findByPrimaryKey(rs.getInt("post")),					 
					   rs.getString("pic"),
					   rs.getString("tel"),
					   rs.getString("email"),
					   rs.getString("yuliu")));		
			
			
		}
		super.closeConnection(conn);
		return doctors;	
	}


}
