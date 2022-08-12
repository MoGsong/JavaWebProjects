package com.gxnu.service;

import java.util.List;

import com.gxnu.entity.AboutUs;

public interface IAboutUsService {

	public void add(AboutUs aboutUs);

	public void remove(int id);

	public void update(AboutUs aboutUs);

	public AboutUs find(int id);
	

	public List<AboutUs> find_all_list();

	public AboutUs find(String name, String address);
	

	public List<AboutUs> find(int currentPage,int pageSize);

}
