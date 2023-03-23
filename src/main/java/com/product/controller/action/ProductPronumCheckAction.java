package com.product.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hosinsa.controller.HosinsaAction;

import com.hosinsa.dao.ProductDAO;

public class ProductPronumCheckAction implements HosinsaAction{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pronum = Integer.parseInt(request.getParameter("pronum"));
		System.out.println(pronum);
		ProductDAO dao = ProductDAO.getInstance();
		int result = dao.confirmPronum(pronum);
		
		request.setAttribute("pronum", pronum);
		request.setAttribute("result", result);
		
		RequestDispatcher dis = request.getRequestDispatcher("/product/product_pronum_check.jsp");
		dis.forward(request, response);
	}
}
