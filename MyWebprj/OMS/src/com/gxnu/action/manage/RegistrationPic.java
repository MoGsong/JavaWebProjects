package com.gxnu.action.manage;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.data.category.DefaultCategoryDataset;

import com.gxnu.entity.Doctor;
import com.gxnu.service.IDoctorService;
import com.gxnu.service.imp.DoctorService;

public class RegistrationPic {
	public static String getLineChart(HttpSession session) throws IOException { 
		
      	 DefaultCategoryDataset line_chart_dataset = new DefaultCategoryDataset(); 
      	Object Id = session.getAttribute("REGISTRATIONPIC");	//获取医生id
      	System.out.println(Id);
      	int id = Integer.parseInt(Id.toString());
      	System.out.println(id);
      	IDoctorService doctorService = new DoctorService();
      	Doctor doctor = doctorService.find(id);
      	//根据预约挂号表，调用排班信息表，显示三天预约人数情况，做统计图，每预约一个，对应时间段就会添加一条数据，统计图会随之变化
      	//目前没有实现该功能
      	   //9点到12点，下午3点到5点
      	
           line_chart_dataset.addValue( 7, doctor.getName(), "2022-08-10 上午" );
           line_chart_dataset.addValue( 9, doctor.getName(), "2022-08-10 下午" );
           line_chart_dataset.addValue( 6, doctor.getName(), "2022-08-11 上午" );
           line_chart_dataset.addValue( 7, doctor.getName(), "2022-08-11 下午" );
           line_chart_dataset.addValue( 8, doctor.getName(), "2022-08-12 上午" ); 
           line_chart_dataset.addValue( 8, doctor.getName(), "2022-08-12 下午" );

           JFreeChart chart = ChartFactory.createLineChart(
              "预约统计","预约时间",
              "人数",
              line_chart_dataset,PlotOrientation.VERTICAL,
              true,true,false);     	 
      	 String fileName=ServletUtilities.saveChartAsPNG(chart, 1000, 400, session);
      	 return fileName;    	 
       }  
}