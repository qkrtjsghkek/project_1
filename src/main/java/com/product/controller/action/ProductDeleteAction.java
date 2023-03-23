package com.product.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hosinsa.controller.HosinsaAction;
import com.hosinsa.dao.ProductDAO;

public class ProductDeleteAction implements HosinsaAction{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num = request.getParameter("num");
		ProductDAO Dao = ProductDAO.getInstance();
		Dao.deleteProduct(num);
		
		new ProductManageAction().execute(request, response);
	}
}
