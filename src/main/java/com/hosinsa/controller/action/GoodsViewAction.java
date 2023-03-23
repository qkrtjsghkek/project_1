package com.hosinsa.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hosinsa.controller.HosinsaAction;
import com.hosinsa.dao.ProductDAO;
import com.hosinsa.dto.ProductVO;

public class GoodsViewAction implements HosinsaAction{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "goodsView.jsp";
		String pronum = request.getParameter("pronum");
		
		ProductDAO dao = ProductDAO.getInstance();
		ProductVO vo = dao.selectOneProductByPronum(pronum);
		request.setAttribute("goodsView", vo);
		
		dao.updateProviewCount(pronum);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
