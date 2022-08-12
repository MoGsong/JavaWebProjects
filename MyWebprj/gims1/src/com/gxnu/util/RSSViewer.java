package com.gxnu.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import com.gxnu.entity.Message;

public class RSSViewer {
	private String rss_url;
	private String rss_root_title;
	private List<Message> rssItem;
	static int id=0;
	private boolean isValid=false;// 檢查rss有效性，默認為無效,解析方法成功時再設置為真值
	
	
	public String getRss_root_title() {
		return rss_root_title;
	}


	public void setRss_root_title(String rss_root_title) {
		this.rss_root_title = rss_root_title;
	}


	public List<Message> getRssItem() {
		return rssItem;
	}


	public void setRssItem(List<Message> rssItem) {
		this.rssItem = rssItem;
	}


	public RSSViewer(String url,int id) throws JDOMException, IOException{
		this.rss_url=url;
		this.id=id;
		this.rssItem=new ArrayList<Message>();
		this.rssParse();
	}
	
	private void rssParse() throws JDOMException, IOException{
		SAXBuilder factory = new SAXBuilder();
		Document document=factory.build(this.rss_url);
		Element root = document.getRootElement();
		
		this.rss_root_title=root.getText();
		if (this.rss_root_title==null) {
			throw new JDOMException();
		}
		
		List Channel_child = root.getChildren();
		Element element_channel = (Element) Channel_child.iterator().next();
		List list_items = element_channel.getChildren();
		Iterator itx = list_items.iterator();
		
		while (itx.hasNext()) {
			Element child = (Element) itx.next();
			if (child.getName().equals("title")){
				this.rss_root_title = child.getText();
			}
			if (child.getName().equals("item")) {
				List item_child = child.getChildren();
				Iterator itx_item = item_child.iterator();
				Message message = new Message();

				while (itx_item.hasNext()) {// 遍曆每一個item對象的每一個節點
					Element item_obj = (Element) itx_item.next();
					message.setCategory(id);
					if (item_obj.getName().equals("title")) {
						List item_child_title = item_obj.getChildren();
						Iterator itx_item_title = item_child_title.iterator();
						if(itx_item_title.hasNext()){
							Element item_obj_title = (Element) itx_item_title.next();
							if(item_obj_title.getName().equals("font")){
								message.setTitle(item_obj_title.getText().replaceAll("\"", "“"));
							}
						}else{
							message.setTitle(item_obj.getText().replaceAll("\"", "“"));
						}
					}
					if (item_obj.getName().equals("link")) {
						message.setLink(item_obj.getText());
						message.setDownLink(Formater.formate(item_obj.getText()));
					}
					if (item_obj.getName().equals("pubDate")) {
						message.setPublishTime(item_obj.getText());
					}

					if (item_obj.getName().equals("source")) {
						message.setSource(item_obj.getText());
					}
					if (item_obj.getName().equals("description")) {
										
						String bbbString = item_obj.getTextTrim().trim();
						bbbString = bbbString.replaceAll(" ", "");
						//bbbString = bbbString.replaceAll("　　", "");
						//System.out.println("description--->"+bbbString);
						
						String aaaa = bbbString.replaceAll("[ \n ]+", "<br>");
						aaaa=aaaa.replaceAll("[\t]+", "");
						aaaa=aaaa.replaceAll("\" ", "\'&nbsp;&nbsp;&nbsp;");
						aaaa=aaaa.replaceAll(" ", "");
					 
						aaaa=aaaa.replaceAll("<BR>", "<br>");
						aaaa=aaaa.replaceAll("<br><br><br>", "<br>");
						aaaa=aaaa.replaceAll("<br><br><br><br>", "<br>");
						aaaa=aaaa.replaceAll("<br><br><br>", "<br>");

						if(!bbbString.contains("　　")){
							bbbString = "　　"+bbbString;
						}
						message.setDescription(aaaa);
					}
					
					if (item_obj.getName().equals("docId")) {
						message.setDocId(Integer.parseInt(item_obj.getTextTrim()));
					}
					
					if (item_obj.getName().equals("hitCount")) {
						message.setHitCount(Integer.parseInt(item_obj.getTextTrim()));
					}
					
					if (item_obj.getName().equals("image")) {
						message.setImage(item_obj.getTextTrim());
					}
				}
				this.addChildItem(message);// 將rsschild對象壓入list對象中
			}
		}
	}
	
	public boolean checkRss() {// 檢測輸入的地址是否為有效的url
		return this.isValid;
	}
	
	private void addChildItem(Message message){
		this.rssItem.add(message);
	}
}
