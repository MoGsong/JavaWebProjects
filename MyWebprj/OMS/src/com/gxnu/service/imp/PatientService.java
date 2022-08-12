package com.gxnu.service.imp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gxnu.dao.PatientDAO;
import com.gxnu.entity.Patient;
import com.gxnu.service.IPatientService;
/**
 * Ȩ�޲�����Ӧ��ҵ����
 * @author johny
 * ҵ����������ó־ò㷽������ɾ���ҵ����
 * �����쳣
 */
public class PatientService implements IPatientService{
	@Override
	public void add(Patient patient) {
		//�����־ò������
		PatientDAO patientDAO = new PatientDAO();
		try {
			patientDAO.add(patient);
		} catch (ClassNotFoundException | SQLException e) {
			//�����쳣����ӡ�쳣�Ĺ켣
			e.printStackTrace();
		}
	}

	@Override
	public void remove(int id) {
		//�����־ò������
		PatientDAO patientDAO = new PatientDAO();
		Patient patient = new Patient(); //id=0
		patient.setId(id);
		try {
			patientDAO.delete(patient);
		} catch (ClassNotFoundException | SQLException e) {
			//�����쳣����ӡ�쳣�Ĺ켣
			e.printStackTrace();
		}
	}

	@Override
	public void update(Patient patient) {
		//�����־ò������
		PatientDAO patientDAO = new PatientDAO();
		try {
			patientDAO.update(patient);
		} catch (ClassNotFoundException | SQLException e) {
			//�����쳣����ӡ�쳣�Ĺ켣
			e.printStackTrace();
		}
	}

	@Override
	public Patient find(int id) {
		//�����־ò������
		PatientDAO patientDAO = new PatientDAO();
		Patient patient = new Patient();
		try {
			patient = patientDAO.findByPrimaryKey(id);
		} catch (ClassNotFoundException | SQLException e) {
			//�����쳣����ӡ�쳣�Ĺ켣
			e.printStackTrace();
		}
		return patient;
	}

	@Override
	public List<Patient> find() {
		//�����־ò������
		PatientDAO patientDAO = new PatientDAO();
		List<Patient> patients = new ArrayList<Patient>();
		try {
			patients = patientDAO.findAll();
		} catch (ClassNotFoundException | SQLException e) {
			//�����쳣����ӡ�쳣�Ĺ켣
			e.printStackTrace();
		}
		return patients;
	}

	@Override
	public List<Patient> findByRole(int roleid) {
		//�����־ò������
		PatientDAO patientDAO = new PatientDAO();
		List<Patient> patients = new ArrayList<Patient>();
		try {
			patients = patientDAO.findAll();
		} catch (ClassNotFoundException | SQLException e) {
			//�����쳣����ӡ�쳣�Ĺ켣
			e.printStackTrace();
		}
		return patients;
	}

	//根据用户账号和密码查找用户
	@Override
	public Patient find(String username, String password) {
		// 调用业务方法查找
		PatientDAO patientDAO = new PatientDAO();
		List<Patient> patients = new ArrayList<>();
		Patient pat = new Patient();
		try {
			patients = patientDAO.findAll();
			//循环遍历集合
			for (Patient patient : patients) {
				if(patient.getUsername().equalsIgnoreCase(username) && patient.getPassword().equals(password)) {
					pat = patient;
					break;
				}
			}
		} catch (ClassNotFoundException | SQLException e) { 
			e.printStackTrace();
		}
		return pat;
	}

	@Override
	public Patient findrole(String username, String email) {
		// 调用业务方法查找
		PatientDAO patientDAO = new PatientDAO();
		List<Patient> patients = new ArrayList<>();
		Patient pat = new Patient();
		try {
			patients = patientDAO.findAll();
			//循环遍历集合
			for (Patient patient : patients) {
				if(patient.getUsername().equalsIgnoreCase(username) && patient.getEmail().equals(email)) {
					pat = patient;
					break;
				}
			}
		} catch (ClassNotFoundException | SQLException e) { 
			e.printStackTrace();
		}
		return pat;
	}

	@Override
	public Patient findrole(String tel) {
        // 调用业务方法查找
		PatientDAO patientDAO = new PatientDAO();
		List<Patient> patients = new ArrayList<>();
		Patient pat = new Patient();
		try {
			patients = patientDAO.findAll();
			//循环遍历集合
			for (Patient patient : patients) {
				if(patient.getTel().equals(tel)) {
					pat = patient;
					break;
				}
			}
		} catch (ClassNotFoundException | SQLException e) { 
			e.printStackTrace();
		}
		return pat;
	}
}