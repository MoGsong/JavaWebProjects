package com.gxnu.service.imp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gxnu.dao.RegistrationDAO;
import com.gxnu.entity.Registration;
import com.gxnu.service.IRegistrationService;

public class RegistrationService implements IRegistrationService {
	public void add(Registration registration) {
		//创建菜单持久层对象
		RegistrationDAO registrationDAO=new RegistrationDAO();
		try {
			registrationDAO.add(registration);
		} catch (ClassNotFoundException | SQLException e) {
			// 把异常轨迹进行打印显示
			e.printStackTrace();
		}
	}

	public void remove(int id) {
		// 创建菜单持久层对象
		RegistrationDAO registrationDAO=new RegistrationDAO();
		Registration registration=new Registration();
		registration.setId(id);
		try {
			registrationDAO.delete(registration);
		} catch (ClassNotFoundException | SQLException e) {
			// 把异常轨迹进行打印显示
			e.printStackTrace();
		}
		
	}

	public void update(Registration registration) {
		// 创建菜单持久层对象
				RegistrationDAO registrationDAO=new RegistrationDAO();
				try {
					registrationDAO.merge(registration);
				} catch (ClassNotFoundException | SQLException e) {
					// 把异常轨迹进行打印显示
					e.printStackTrace();
				}
		
	}

	public Registration find(int id) {
		// 创建菜单持久层对象
				RegistrationDAO registrationDAO=new RegistrationDAO();
				Registration registration=new Registration();
				try {
					registration=registrationDAO.findByPrimaryKey(id);
				} catch (ClassNotFoundException | SQLException e) {
					//把异常轨迹进行打印显示
					e.printStackTrace();
				}
		return registration;
	}

	public List<Registration> find() {
		// 创建菜单持久层对象
		RegistrationDAO registrationDAO=new RegistrationDAO();
		List<Registration> registrations = new ArrayList<Registration>();
		try {
			registrations=registrationDAO.findAll();
		} catch (ClassNotFoundException | SQLException e) {
			// 把异常轨迹进行打印显示
			e.printStackTrace();
		}
		return registrations;
	}


	@Override
	public List<Registration> findByDoctorId(int doctorId) {
		RegistrationDAO registrationDAO = new RegistrationDAO();
		List<Registration> registrationAll = new RegistrationService().find();
		List<Registration> registrations = new ArrayList<Registration>();
		
		for (Registration registration : registrationAll) {
			if(registration.getDoctor().getId() == doctorId) {
				registrations.add(registration);
			}
		}
		return registrations;
	}

	@Override
	public List<Registration> findByPatientId(int patientId) {
		RegistrationDAO registrationDAO = new RegistrationDAO();
		List<Registration> registrationAll = new RegistrationService().find();
		List<Registration> registrations = new ArrayList<Registration>();
		
		for (Registration registration : registrationAll) {
			if(registration.getPatient().getId() == patientId) {
				registrations.add(registration);
				System.out.println("Service测试:"+ registration.toString());
			}
		}
		return registrations;
	}

	@Override
	public List<Registration> findByUnitId(int unitId) {
		RegistrationDAO registrationDAO = new RegistrationDAO();
		List<Registration> registrationAll = new RegistrationService().find();
		List<Registration> registrations = new ArrayList<Registration>();
		
		for (Registration registration : registrationAll) {
			if(registration.getDoctor().getUnit().getId() == unitId) {
				registrations.add(registration);
			}
		}
		return registrations;
	}

	@Override
	public Registration findByYuliu(String yuliu) {
		RegistrationDAO registrationDAO = new RegistrationDAO();
		List<Registration> registrationAll = new RegistrationService().find();
		
		for (Registration registration : registrationAll) {
			if(yuliu.equals(registration.getYuliu())) {
				return registration;
			}
		}
		return null;
	}
}