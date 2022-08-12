package com.gxnu.util;

public class Wrap {
	String message = "";
	
	public String PromptStart() {
		//提示
		message = "<div class=\"item item-center\"><span>会诊开始......</span></div>";
		
		return message;		
	}
	public String PromptStop() {
		//提示
		message = "<div class=\"item item-center\"><span>会诊结束......</span></div>";
		
		return message;		
	}
	public String sendWrap(String img, String info) {
		//发送消息后的HTML
		//src是头像全路径
		message = "<div class=\"bubble bubble-right\">"+info+"</div>"
				+ "<div class=\"avatar\">"
				+ 	"<img src="+/*Data.URL*/img +" />"
				+ "</div>";
		return message;		
	}
	
	public String receiveWrap(String img,String info) {
		//接收到消息后显示的HTML
		//src是头像全路径
		message =   "     <div class=\"avatar\">"+ 
					"	 	<img src="+/*Data.URL*/img +" />\"\r\n" + 
					"       </div>\r\n" + 
					"         <div class=\"bubble bubble-left\">"+info+"</div>\r\n" + 
					"     </div>";
		
		return message;		
	}
	
}
