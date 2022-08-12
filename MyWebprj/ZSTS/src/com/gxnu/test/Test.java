package com.gxnu.test;

import com.gxnu.entity.Operator;
import com.gxnu.service.IOperatorService;
import com.gxnu.service.imp.OperatorService;
import com.gxnu.util.DesUtil;
import com.gxnu.util.SendMailUtil;

public class Test {

    public static void main(String[] args) throws Exception { 
    	// 做测试用
//    	SendMailUtil.sendMail("1986523538@qq.com","你好，这是一封测试邮件，无需回复。","测试邮件");
//        System.out.println("发送成功");
    	IOperatorService ios = new OperatorService();
		Operator op = ios.findrole("admin","1986523538@qq.com");	
		System.out.println(op);
    }

}

