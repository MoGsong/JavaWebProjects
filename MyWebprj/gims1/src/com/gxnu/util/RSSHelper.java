package com.gxnu.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom.JDOMException;

import com.gxnu.entity.Message;

public class RSSHelper {
	public List<Message> findMessage(String url,int id){
		List<Message> list=new ArrayList<Message>();
		try {
			RSSViewer viewer=new RSSViewer(url,id);
			list=viewer.getRssItem();
		} catch (JDOMException e) {
			System.out.println("解析xml文件發生錯誤:" + e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("打開url發生錯誤" + e.getMessage());
			e.printStackTrace();
		}
		return list;
	}
}
