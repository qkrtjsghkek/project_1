package com.product.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hosinsa.controller.HosinsaAction;
import com.hosinsa.dao.ProductDAO;
import com.hosinsa.dto.ProductVO;

public class ProductViewFormAction implements HosinsaAction {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/product/productView.jsp";
		String pronum = request.getParameter("num");
		System.out.println(pronum);
		ProductDAO dao = ProductDAO.getInstance();
		ProductVO vo = dao.selectOneProductByPronum(pronum);
		request.setAttribute("product", vo);
		
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
		
	}
}
