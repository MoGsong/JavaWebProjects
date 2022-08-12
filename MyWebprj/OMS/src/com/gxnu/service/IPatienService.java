package com.gxnu.service;
import java.util.List;
import com.gxnu.entity.Patient;
/**
 * 	Ȩ�޲�����Ӧ��ҵ��ӿ�
 * @author johny
 *  ҵ��ӿ�
 */
public interface IPatienService {
	//����Ȩ��
	public void add(Patient patien);
	//ɾ��Ȩ��
	public void remove(int id);
	//�޸�Ȩ��
	public void update(Patient patien);
	
	//��ѯ����Ȩ��
	public Patient find(int id);
	//��ѯ����Ȩ��
	public List<Patient> find();
	
	//���ݽ�ɫ����ѯȨ��
	public List<Patient> findByRole(int roleid);
}