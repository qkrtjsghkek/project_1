package com.product.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hosinsa.controller.HosinsaAction;

public class ProductWriteFormAction implements HosinsaAction{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="/product/productWrite.jsp";		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request,  response);
	}
}
