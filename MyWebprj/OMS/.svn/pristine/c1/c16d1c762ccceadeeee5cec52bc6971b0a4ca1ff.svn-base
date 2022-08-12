package com.gxnu.service.imp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gxnu.dao.DoctorDAO;
import com.gxnu.dao.OperatorDAO;
import com.gxnu.entity.Doctor;
import com.gxnu.entity.Operator;
import com.gxnu.service.IDoctorService;
/**
 * Ȩ�޲�����Ӧ��ҵ����
 * @author johny
 * ҵ����������ó־ò㷽������ɾ���ҵ����
 * �����쳣
 */
public class DoctorService implements IDoctorService{
	@Override
	public void add(Doctor doctor) {
		//�����־ò������
		DoctorDAO doctorDAO = new DoctorDAO();
		try {
			doctorDAO.add(doctor);
		} catch (ClassNotFoundException | SQLException e) {
			//�����쳣����ӡ�쳣�Ĺ켣
			e.printStackTrace();
		}
	}

	@Override
	public void remove(int id) {
		//�����־ò������
		DoctorDAO doctorDAO = new DoctorDAO();
		Doctor doctor = new Doctor(); //id=0
		doctor.setId(id);
		try {
			doctorDAO.delete(doctor);
		} catch (ClassNotFoundException | SQLException e) {
			//�����쳣����ӡ�쳣�Ĺ켣
			e.printStackTrace();
		}
	}

	@Override
	public void update(Doctor doctor) {
		//�����־ò������
		DoctorDAO doctorDAO = new DoctorDAO();
		try {
			doctorDAO.update(doctor);
		} catch (ClassNotFoundException | SQLException e) {
			//�����쳣����ӡ�쳣�Ĺ켣
			e.printStackTrace();
		}
	}

	@Override
	public Doctor find(int id) {
		//�����־ò������
		DoctorDAO doctorDAO = new DoctorDAO();
		Doctor doctor = new Doctor();
		try {
			doctor = doctorDAO.findByPrimaryKey(id);
		} catch (ClassNotFoundException | SQLException e) {
			//�����쳣����ӡ�쳣�Ĺ켣
			e.printStackTrace();
		}
		return doctor;
	}

	@Override
	public List<Doctor> find() {
		//�����־ò������
		DoctorDAO doctorDAO = new DoctorDAO();
		List<Doctor> doctors = new ArrayList<Doctor>();
		try {
			doctors = doctorDAO.findAll();
		} catch (ClassNotFoundException | SQLException e) {
			//�����쳣����ӡ�쳣�Ĺ켣
			e.printStackTrace();
		}
		return doctors;
	}


	@Override
	public List<Doctor> findByUnit(int unitid) {
		//�����־ò������
		DoctorDAO doctorDAO = new DoctorDAO();
		List<Doctor> doctors = new ArrayList<Doctor>();
		try {
			doctors = doctorDAO.findByUnitId(unitid);
		} catch (ClassNotFoundException | SQLException e) {
			//�����쳣����ӡ�쳣�Ĺ켣
			e.printStackTrace();
		}
		return doctors;
	}

	/**
	 * 表中的操作员id均大于0,若返回的op的id=0，表示该用户名和密码的操作员在表中不存在，该 用户不合法
	 */
	@Override
	public Doctor find(String username, String password) {
			// 遍历所有操作员，若存在对应用户名和密码的操作员，则说明该用户合法，返回
			DoctorDAO doctorDAO = new DoctorDAO();
			List<Doctor> doctors = new ArrayList<Doctor>();
			Doctor dr = new Doctor(); //{id=0,username=null,password=null...}
			try {
				doctors = doctorDAO.findAll(); //表中所有操作员
				for (Doctor doctor : doctors) {
					if(doctor.getUsername().equalsIgnoreCase(username) &&
							doctor.getPassword().equals(password)) {
						      dr = doctor;
						      break;
					}
				}
			} catch (ClassNotFoundException | SQLException e) {
				//处理异常，打印异常的轨迹
				e.printStackTrace();
			}
			return dr;
		}
	}