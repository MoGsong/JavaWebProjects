package com.gxnu.action.manage;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gxnu.entity.InStore;
import com.gxnu.entity.Operator;
import com.gxnu.service.IInStoreService;
import com.gxnu.service.imp.InStoreService;
import com.gxnu.service.imp.OperatorService;
import com.gxnu.util.Data;

@WebServlet(urlPatterns = { "/instore" })
public class InstoreAction extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession hs = req.getSession();
		Object operObject = hs.getAttribute(Data.OPERATOR);
		Operator operator = new Operator();
		if (operObject != null) {
			operator = (Operator) operObject;
		}
		Date date = new Date();
		Timestamp nousedate = new Timestamp(date.getTime());
		IInStoreService iis = new InStoreService();
		InStore inStore = new InStore(new OperatorService().find(3), nousedate);
		iis.add(inStore);
		List<InStore> inStores = iis.findAll();
		List<Integer> idList = new ArrayList<Integer>();

		// 循环遍历集合，拿到每个InStore对象的id，存入idList集合中
		for (InStore is : inStores) {
			idList.add(is.getId());
		}
		// 通过Collections工具类，拿到集合中的最大值并存入会话中
		int maxId = Collections.max(idList);
		hs.setAttribute("InStoreId", maxId);
		resp.sendRedirect(Data.URL + "/Manage/InStore.jsp");
	}
}
