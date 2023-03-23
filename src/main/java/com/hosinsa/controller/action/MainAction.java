package com.hosinsa.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hosinsa.controller.HosinsaAction;
import com.hosinsa.dao.ProductDAO;
import com.hosinsa.dto.ProductVO;

public class MainAction implements HosinsaAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductVO vo = new ProductVO();
		ProductDAO dao = ProductDAO.getInstance();
		String category = request.getParameter("category");
		if(category.equals("") || category.equals("인기")) {
			List<ProductVO> list = dao.mainViewRanking();
			request.setAttribute("productView_list", list);
		}
		else {
			vo.setCategory(category);
			List<ProductVO> list = dao.mainViewCategory(category);
			request.setAttribute("productView_list", list);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/main.jsp");
		dispatcher.forward(request, response);
	}
}
