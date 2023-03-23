package com.product.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hosinsa.controller.HosinsaAction;
import com.hosinsa.dao.ProductDAO;
import com.hosinsa.dto.ProductVO;


public class ProductUpdateFormAction implements HosinsaAction {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/product/productUpdate.jsp";

		String pronum = request.getParameter("num");

		ProductDAO Dao = ProductDAO.getInstance();

		ProductVO Vo = Dao.selectOneProductByPronum(pronum);

		request.setAttribute("product", Vo);

		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);

	}
}
