package com.gxnu.service;

import java.util.List;

import com.gxnu.entity.Registration;

/**
 * 菜单业务接口
 * @author 胖子不露小酒窝
 *业务层通常调用持久层方法，完成具体的业务功能
 */
public interface IRegistrationService {
	//添加菜单
	public void add(Registration registration);
	//删除菜单
	public void remove(int id);
	//修改菜单
	public void update(Registration registration);
	//查询id字段查询单个菜单
	public Registration find(int id);
	//通过yuliu字段查询单个菜单
	public Registration findByYuliu(String yuliu);
	//查询菜单，所有
	public List<Registration> find();
	//根据doctor字段查询所有菜单信息
	public List<Registration> findByDoctorId(int doctorId);
	//根据patient字段查询所有菜单信息
	public List<Registration> findByPatientId(int patientId);
	//根据unit字段查询所有菜单信息
	public List<Registration> findByUnitId(int unitId);
}