package com.gxnu.service.imp;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gxnu.dao.ConfigDAO;
import com.gxnu.entity.Config;
import com.gxnu.service.IConfigService;

public class ConfigService implements IConfigService {
	//实现服务器接口中的方法
	@Override
	public void modify(Config config) {
		 ConfigDAO configDAO = new ConfigDAO();
		 try {
			configDAO.modify(config);
		 } catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 }
	}
<<<<<<< .mine

	@Override
	public Config find() {
		 ConfigDAO configDAO = new ConfigDAO();
		 Config config = new Config();
		 try {
			 config = configDAO.find();
			 } catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();	 
			 }
		 return config;
	}
||||||| .r33
=======


	@Override
	public List<Config> find() {
		 ConfigDAO configDAO = new ConfigDAO();
		 List<Config> configs = new ArrayList<Config>();
		 try {
			 configs = configDAO.find();
			 } catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();	 
			 }
		 return configs;
	}

	@Override
	public Config find(int id) {
		ConfigDAO configDAO = new ConfigDAO();
		Config config = new Config();
		try {
			config = configDAO.find(id);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		 return config;
	}
>>>>>>> .r48
	
}
