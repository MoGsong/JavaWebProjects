package gxnu.servlet;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import com.gxlq.entity.Operator;
@WebListener
public class LogListener implements HttpSessionAttributeListener{
	private String getTime() {
		SimpleDateFormat sdf =new SimpleDateFormat();//格式化时间
		sdf.applyPattern("yyyy年MM月dd日  a HH:mm:ss");// a为am/pm的标记
		Date date = new Date();//获取当前时间
		return sdf.format(date);//输出已经格式化的现在时间(24小时制)	
	}
	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		Object username = event.getValue();
		Object operator = event.getValue();
		System.out.println(username + getTime()+"登录系统");
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		Object username = event.getValue();
		System.out.println(username + getTime()+"退出系统");
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		Object username = event.getValue();
		Object operator = event.getValue();
		System.out.println("修改数据："+ username);
	}
	
}
