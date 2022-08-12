package com.gxnu.service;
import java.util.List;

import com.gxnu.entity.Doctor;
import com.gxnu.entity.Operator;
/**
 * 	Ȩ�޲�����Ӧ��ҵ��ӿ�
 * @author johny
 *  ҵ��ӿ�
 */
public interface IDoctorService {
	//���Ȩ��
	public void add(Doctor doctor);
	//ɾ��Ȩ��
	public void remove(int id);
	//�޸�Ȩ��
	public void update(Doctor doctor);
	
	//��ѯ����Ȩ��
	public Doctor find(int id);
	//��ѯ����Ȩ��
	public List<Doctor> find();
	//通过科室查找医生信息
	public List<Doctor> findByUnit(int unitid);
	//查询某个用户名和密码的医生
	public Doctor find(String username,String password);
}
