package com.gxnu.service;
import java.util.List;
import com.gxnu.entity.Patient;
/**
 * 	权限操作对应的业务接口
 * @author johny
 *  业务接口
 */
public interface IPatienService {
	//添加权限
	public void add(Patient patien);
	//删除权限
	public void remove(int id);
	//修改权限
	public void update(Patient patien);
	
	//查询单个权限
	public Patient find(int id);
	//查询所有权限
	public List<Patient> find();
	
	//根据角色，查询权限
	public List<Patient> findByRole(int roleid);
}
