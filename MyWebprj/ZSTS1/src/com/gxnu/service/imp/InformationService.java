package com.gxnu.service.imp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gxnu.dao.lnformationDAO;
import com.gxnu.entity.lnformation;
import com.gxnu.service.IInformationService;
/**
 * �ʼ���Ϣҵ����
 * @author johny
 * ҵ���ͨ�����ó־ò㷽������ɾ���ҵ����
 * ���쳣������д���
 */
public class InformationService implements IInformationService {
	@Override
	public void add(lnformation information) {
		//�����ʼ���Ϣ�־ò���� 
		lnformationDAO informationDAO = new lnformationDAO();
		try {
			informationDAO.add(information);
		} catch (ClassNotFoundException | SQLException e) {
			// ���쳣�켣���д�ӡ��ʾ
			e.printStackTrace();
		}
	}

	@Override
	public void remove(int id) {
		//�����ʼ���Ϣ�־ò���� 
		lnformationDAO informationDAO = new lnformationDAO();
		lnformation information = new lnformation(); //{id=0}
		information.setId(id);
		try {
			informationDAO.delete(information);
		} catch (ClassNotFoundException | SQLException e) {
			// ���쳣�켣���д�ӡ��ʾ
			e.printStackTrace();
		}
	}

	@Override
	public void update(lnformation information) {
		//�����ʼ���Ϣ�־ò���� 
		lnformationDAO informationDAO = new lnformationDAO();
		try {
			informationDAO.merge(information);
		} catch (ClassNotFoundException | SQLException e) {
			// ���쳣�켣���д�ӡ��ʾ
			e.printStackTrace();
		}
	}

	@Override
	public lnformation find(int id) {
		//�����ʼ���Ϣ�־ò���� 
		lnformationDAO informationDAO = new lnformationDAO();
		lnformation information = new lnformation(); //{id=0,name=null}
		try {
			information = informationDAO.findByPrimaryKey(id);
		} catch (ClassNotFoundException | SQLException e) {
			// ���쳣�켣���д�ӡ��ʾ
			e.printStackTrace();
		}
		return information;
	}

	@Override
	public List<lnformation> find() {
		//�����ʼ���Ϣ�־ò���� 
		lnformationDAO informationDAO = new lnformationDAO();
		List<lnformation> informations = new ArrayList<lnformation>();
		try {
			informations =informationDAO.findAll();
		} catch (ClassNotFoundException | SQLException e) {
			// ���쳣�켣���д�ӡ��ʾ
			e.printStackTrace();
		}
		return informations;
	}

	@Override
	public List<lnformation> find(int currentPage, int pageSize) {
		//�����ʼ���Ϣ�־ò���� 
		lnformationDAO informationDAO = new lnformationDAO();
		List<lnformation> informations = new ArrayList<lnformation>();
		try {
			informations =informationDAO.findAll();
		} catch (ClassNotFoundException | SQLException e) {
			// ���쳣�켣���д�ӡ��ʾ
			e.printStackTrace();
		}
		return informations;
	}

}
