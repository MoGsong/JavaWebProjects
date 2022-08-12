package com.gxnu.util;

public class Formater {
	public static String formate(String downloadLink){
		String ret="";
		if(downloadLink!=null){
			downloadLink=downloadLink.trim();
			int index =downloadLink.lastIndexOf('.');
			String str=downloadLink.substring(index+1);
			if ("doc".equalsIgnoreCase(str)||"xls".equalsIgnoreCase(str)||"docx".equalsIgnoreCase(str)||"xlsx".equalsIgnoreCase(str)||"pdf".equalsIgnoreCase(str)) {
				ret=downloadLink;
			}
		}
		return ret;
	}
}
