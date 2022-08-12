package com.gxnu.action.patient;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.RestoreAction;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.config.AlipayConfig;
import com.gxnu.entity.Doctor;
import com.gxnu.entity.Patient;
import com.gxnu.entity.Registration;
import com.gxnu.entity.ReserveCase;
import com.gxnu.entity.Schedule;
import com.gxnu.service.imp.DoctorService;
import com.gxnu.service.imp.RegistrationService;
import com.gxnu.service.imp.ReserveCaseService;
import com.gxnu.service.imp.ScheduleService;
import com.gxnu.util.Data;



@WebServlet(urlPatterns = {"/RegistrationPayReturn"})
public class RegistrationPayReturn extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("测试一下。");
		//获取支付宝POST过来反馈信息
		Map<String,String> params = new HashMap<String,String>();
		Map<String,String[]> requestParams = req.getParameterMap();
		for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i]
						: valueStr + values[i] + ",";
			}
			//乱码解决，这段代码在出现乱码时使用
			valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
			params.put(name, valueStr);
			System.out.println("name:" + name + "---" + "value:" + valueStr);
		}
		
		try {
			boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type);
		} catch (AlipayApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //调用SDK验证签名
		
		//新建RegistrationService对象
		RegistrationService registrationService = new RegistrationService();
		//获取存储在params中的订单号
		Registration registration = registrationService.findByYuliu(params.get("out_trade_no"));
		//输出测试
		System.out.println("这是trade_no:"+ params.get("out_trade_no"));
		System.out.println("这是registration:"+ registration.toString());
		
		//更改Registration对象的Pay_time，用于后续修改
		registration.setPay_time(new Timestamp(new Date().getTime()));
		
		//新建ReserveCaseService,通过registration中的Doctorid获取对应的ReserveCase对象
		ReserveCaseService reserveCaseService = new ReserveCaseService();
		List<ReserveCase> reserveCases = reserveCaseService.findByDoctorId(registration.getDoctor().getId());
		
		int flag = 0;
		int number = 1;
		for (ReserveCase reserveCaseTime : reserveCases) {
			DateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			if(ft.format(registration.getReserve_time()).equals(ft.format(reserveCaseTime.getTime()))) {
				System.out.println("这是reserveCase:"+ reserveCaseTime.toString());
				number = reserveCaseTime.getAl_reserve() + 1;
				//由于患者预约成功，故可预约表中的已预约人数+1，然后更改Registration对象的Pay_time，用于后续修改
				reserveCaseTime.setAl_reserve(number);
				//更改Registration的记录
				reserveCaseService.update(reserveCaseTime);
				flag++;
				break;
			}
		}
		//flag=0代表可预约表中没有相关数据，需要添加
		if(flag == 0) {
			ReserveCase reserveCase = new ReserveCase(registration.getDoctor(),registration.getReserve_time(),1);
			System.out.println("这是准备写入数据库的：" + reserveCase.toString());
			reserveCaseService.add(reserveCase);
		}
		//更改Registration对象的Number，用于后续修改
		registration.setNumber(String.valueOf(number));
		//输出验证
		System.out.println("这是registration:"+ registration.toString());
		registrationService.update(registration);
	}
}
