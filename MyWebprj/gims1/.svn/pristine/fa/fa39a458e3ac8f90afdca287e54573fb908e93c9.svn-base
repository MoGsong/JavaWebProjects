package com.gxnu.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.log4j.Logger;

import com.gxnu.util.TaskManager;

@WebListener
public class RSSListener implements ServletContextListener {
	private static Logger log=Logger.getLogger(RSSListener.class.getName());
	private TaskManager taskManager=null;
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		if(taskManager!=null){
			taskManager.cancel();
		}
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		log.info("监听器开始...");
		taskManager=new TaskManager();
		taskManager.startTimmer();
	}

}
