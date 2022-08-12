package com.gxnu.test;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import com.gxnu.entity.Menu;
import com.gxnu.entity.Operator;
import com.gxnu.entity.Role;
import com.gxnu.service.IMenuService;
import com.gxnu.service.IOperatorService;
import com.gxnu.service.imp.MenuService;
import com.gxnu.service.imp.OperatorService;

public class Test {
	
	  public void getPath() throws IOException {
		URL cl = this.getClass().getClassLoader().getResource("");
	    System.out.println("cl = " + cl);

	    String clp = cl.getPath().substring(1);
	    clp = clp.substring(0, clp.length()-14) + "src/" +"chat.properties";
	    
	    clp = clp.replace("%20", " ");
	    System.out.println("clp = " + clp);
	}


	public static void main(String[] args) throws IOException {
		Test t =new Test();
		t.getPath();
	}

}
