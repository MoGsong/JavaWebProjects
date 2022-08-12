package com.gxnu.service;

import java.util.List;

import com.gxnu.entity.Config;

public interface IConfigService {
	//配置接口，修改配置方法
	void modify(Config config);
<<<<<<< .mine
	
	Config find();
||||||| .r33
=======
	
	Config find(int id);
	List<Config> find();
>>>>>>> .r48
}
