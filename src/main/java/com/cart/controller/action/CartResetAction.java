package com.cart.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hosinsa.controller.HosinsaAction;
import com.hosinsa.dao.CartDAO;

public class CartResetAction implements HosinsaAction{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		CartDAO dao=CartDAO.getInstance();
		dao.resetCart(id);
		
		System.out.println(id);
		response.sendRedirect("HosinsaServlet?command=cart_list&id="+id);
	}

}
