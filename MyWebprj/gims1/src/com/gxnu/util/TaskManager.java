package com.gxnu.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.log4j.Logger;

import com.gxnu.entity.Category;
import com.gxnu.entity.Message;
import com.gxnu.service.CategoryService;
import com.gxnu.service.imp.CategoryServiceImp;

/**
 * 任务管理器，用于
 * @author zyj
 *
 */
public class TaskManager {
	//定时器
	private Timer timer=null;
	//RSS助手
	private RSSHelper rssHelper=null;
	//业务类
	private CategoryService service=null;
	//rss源信息列表
	private List<Message> rssItem=null;
	//
	private String url;
	private int id;
	
	private static Logger log=Logger.getLogger(TaskManager.class.getName());
	public void startTimmer(){
		service=new CategoryServiceImp();
		List<Category> list=service.find();
		for (Category c : list) {
			final Category category=c;
			timer=new Timer();
			timer.schedule(new TimerTask() {
				@Override
				public void run() {
					//方法调用
					log.info("Thread Name:"+Thread.currentThread().getId());
					handleMessage(category);
				}
			}, 0,category.getRssDelayTime());
		}
	}
	
	public synchronized void cancel(){
		if(timer!=null){
			timer.cancel();
		}
	}
	
	private synchronized void handleMessage(Category category){
		rssItem=new ArrayList<Message>();
		url=category.getUrl();
		id=category.getId();
		
		rssHelper=new RSSHelper();
		rssItem=rssHelper.findMessage(url,id);
		
		if(rssItem!=null){
			service.compareAndUpdate(rssItem, id);
			category.setUpdateTime("2014-10-1");
			service.modify(category);
			return;
		}
	}
}
