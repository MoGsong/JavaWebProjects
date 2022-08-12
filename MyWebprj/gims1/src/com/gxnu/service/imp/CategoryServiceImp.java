package com.gxnu.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.gxnu.entity.Category;
import com.gxnu.entity.Message;
import com.gxnu.entity.Rss;
import com.gxnu.service.CategoryService;
import com.gxnu.service.IRssService;

public class CategoryServiceImp implements CategoryService {
    private static Logger log=Logger.getLogger(CategoryServiceImp.class.getName());
	@Override
	public List<Category> find() {
		List<Category> list = new ArrayList<Category>();
		Category c = new Category();
		c.setId(1);
		c.setUrl("http://rss.yule.sohu.com/rss/yuletoutiao.xml");
		c.setRssDelayTime(1000000000);
		list.add(c);
		Category b = new Category();
		b.setId(2);
		b.setUrl("https://www.zjhuiwan.cn/feed.xml");
		b.setRssDelayTime(1000000000);
		list.add(b);
		return list;
	}

	@Override
	public void compareAndUpdate(List<Message> list, int id) {
		for (Message message : list) {
//			log.info("栏目："+message.getCategory());
//			log.info("download链接："+message.getDownLink());
//			log.info("标题："+message.getTitle());
//			log.info("链接："+message.getLink());
//			log.info("发布时间："+message.getPublishTime());
//			log.info("源："+message.getSource());
//			log.info("内容"+message.getDescription());
			
//			Rss rss = new Rss(message.getTitle(),message.getLink(),message.getDescription(),message.getPublishTime());
//			IRssService irs = new RssService();
//			irs.add(rss);
		}
	}

	@Override
	public void modify(Category category) {
		
	}
}
