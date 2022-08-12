package com.gxnu.action.manage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gxnu.entity.Recipe;
import com.gxnu.service.IRecipeService;
import com.gxnu.service.imp.RecipeService;
import com.gxnu.util.Data;

@WebServlet(urlPatterns = { "/recipes" })
public class RecipeAction extends HttpServlet {
	// 继承父类javax.servlet.http.HttpServlet
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 不论get、post请求，均执行dopost方法
		doPost(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String op = req.getParameter("OP");

		if (op != null && "delete".equals(op)) {
			// 获取页面传递过来的请求参数，即删除的记录id信息
			String strid = req.getParameter("id");
			System.out.println(strid);
			int id = 0;
			if (strid != null) {
				id = Integer.parseInt(strid);
			}

			// 调用业务方法，实现删除某条处方记录
			IRecipeService recipeService = new RecipeService();
			recipeService.remove(id);

			// 刷新页面
			resp.sendRedirect(Data.URL + "/Manage/Recipe.jsp");

		}
	}
}
