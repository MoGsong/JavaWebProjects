package com.gxnu.test;

import java.util.ArrayList;
import java.util.List;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import com.gxnu.entity.User;
import com.gxnu.service.IUserService;
import com.gxnu.service.imp.UserService;

public class Test {

	public static void main(String[] args) throws ScriptException {
		ScriptEngineManager scriptManager = new ScriptEngineManager();

		ScriptEngine scriptEngine = scriptManager.getEngineByName("js");
		System.out.println((Integer)scriptEngine.eval("1+2"));
		
	}

}
