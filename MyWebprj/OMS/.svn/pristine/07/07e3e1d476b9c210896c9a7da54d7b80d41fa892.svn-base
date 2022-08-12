package com.gxnu.action.manage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gxnu.entity.InDetail;
import com.gxnu.service.IInDetailService;
import com.gxnu.service.imp.InDetailService;
import com.gxnu.service.imp.InStoreService;
import com.gxnu.service.imp.InventoryService;
import com.gxnu.util.Data;

@WebServlet(urlPatterns = { "/indetail" })
public class IndetailAction extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String op = req.getParameter("OP");
		String idString = req.getParameter("ID");
		int id = 0;
		if (idString != null) {
			id = Integer.parseInt(idString);
		}

		if (op != null && op.equals("add")) {

			HttpSession hs = req.getSession();
			Object inStoreObject = hs.getAttribute("InStoreId");
			int inStoreId = 0;
			if (inStoreObject != null) {
				inStoreId = Integer.parseInt(String.valueOf(inStoreObject));
			}

			String inventoryString = req.getParameter("INVENTORY");
			int inventoryId = 0;
			if (inventoryString != null) {
				inventoryId = Integer.parseInt(inventoryString);
			}
			String numString = req.getParameter("NUM");
			int num = 0;
			if (numString != null) {
				num = Integer.parseInt(numString);
			}
			String priceString = req.getParameter("PRICE");
			int price = 0;
			if (priceString != null) {
				price = Integer.parseInt(priceString);
			}

//			IInventoryService iis = new InventoryService();

			// 调用业务层add方法，添加一条记录
			IInDetailService ids = new InDetailService();
			InDetail inDetail = new InDetail(new InStoreService().find(inStoreId), new InventoryService().find(inventoryId), price, num,
					"");
			ids.add(inDetail);

			//弃用，已用mysql触发器解决
//			// 调用业务层findAll方法，返回一个集合，包含所有的入库明细记录
//			List<InDetail> inDetails = ids.findAll();
//			// 生成一个集合对象
//			List<InDetail> inDetails2 = new ArrayList<InDetail>();
//			// 初始化库存药品的总进价以及总数量
//			int tprice = 0, tnum = 0;
//			// 通过循环遍历进行逻辑判断，若遍历对象的inventory的id等于新增记录的inventoryId，则放入inDetails2集合中
//			for (InDetail inDetail2 : inDetails) {
//				if (inDetail2.getInventory().getId() == inventoryId) {
//					inDetails2.add(inDetail2);
//					tprice += inDetail2.getPrice() * inDetail2.getNum();
//					tnum += inDetail2.getNum();
//				}
//			}
//			Inventory inventory = iis.find(inventoryId);
//			Inventory updateInventory = new Inventory(inventoryId, inventory.getDrugInfo(), inventory.getMeasur(),
//					(int) (tprice / tnum), tnum);
//			iis.update(updateInventory);

			resp.sendRedirect(Data.URL + "/Manage/InStore.jsp");
		} else if (op != null && op.equals("delete")) {
			IInDetailService ids = new InDetailService();
			ids.remove(id);
			resp.sendRedirect(Data.URL + "/Manage/InStore.jsp");
		} else if (op != null && op.equals("update")) {
			HttpSession hs = req.getSession();
			Object inStoreObject = hs.getAttribute("InStoreId");
			int inStoreId = 0;
			if (inStoreObject != null) {
				inStoreId = Integer.parseInt(String.valueOf(inStoreObject));
			}

			String inventoryString = req.getParameter("INVENTORY");
			int inventoryId = 0;
			if (inventoryString != null) {
				inventoryId = Integer.parseInt(inventoryString);
			}
			String numString = req.getParameter("NUM");
			int num = 0;
			if (numString != null) {
				num = Integer.parseInt(numString);
			}
			String priceString = req.getParameter("PRICE");
			int price = 0;
			if (priceString != null) {
				price = Integer.parseInt(priceString);
			}

			IInDetailService ids = new InDetailService();
			InDetail inDetail = new InDetail(id, new InStoreService().find(inStoreId),
					new InventoryService().find(inventoryId), price, num, "");
			ids.update(inDetail);
			resp.sendRedirect(Data.URL + "/Manage/InStore.jsp");
		}
	}
}
