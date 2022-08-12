package com.gxnu.util;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
public class ConfigModify {
		
	public static void main(String[] args) throws DocumentException {
		//use saxReader.read get xml file and generate DOM tree Object
				SAXReader saxReader = new SAXReader();
				 try {
			            //Document document = saxReader.read(ConfigModify.class.getClassLoader().getResource("D:\\apache-tomcat-9.0.45\\conf\\server.xml"));
					 	Document document = saxReader.read("D:/apache-tomcat-9.0.45/conf/server.xml");   
					 	Element rootElement = document.getRootElement();
			            System.out.println("根:"+rootElement.getName());
			            List<Element> SubElementList = rootElement.elements();
			            System.out.println(SubElementList.get(6).getName());    
			            Element conn = SubElementList.get(6);
			            String port = ((List<Element>) conn).get(0).attributeValue("port");
			            System.out.println( conn + ":"+port);
			        } catch (DocumentException e) {
			            e.printStackTrace();
			}

	}
}
