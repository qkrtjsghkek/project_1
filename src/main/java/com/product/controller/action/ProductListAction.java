package com.product.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hosinsa.controller.HosinsaAction;
import com.hosinsa.dao.ProductDAO;
import com.hosinsa.dto.ProductVO;

public class ProductListAction implements HosinsaAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductVO vo = new ProductVO();
		ProductDAO dao = ProductDAO.getInstance();
		String category = request.getParameter("category");
		System.out.println(category);
		
		if (category.equals("전체") || category.equals("")) {
			List<ProductVO> list = dao.selectAllProduct();
			request.setAttribute("product_list", list);
			new ProductManageAction().execute(request, response);
		}
		else {
			vo.setCategory(category);
			List<ProductVO> list = dao.selectOneProductByCategory(category);
			request.setAttribute("product_list", list);
			new ProductManageAction().execute(request, response);
		}
	}
}
