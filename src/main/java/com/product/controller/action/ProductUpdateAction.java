package com.product.controller.action;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hosinsa.controller.HosinsaAction;
import com.hosinsa.dao.ProductDAO;
import com.hosinsa.dto.MemberVO;
import com.hosinsa.dto.ProductVO;


public class ProductUpdateAction implements HosinsaAction {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductVO vo = new ProductVO();
		String pronum = request.getParameter("num");
		vo.setCategory(request.getParameter("category"));
		vo.setProname(request.getParameter("proname"));
		vo.setProimgSmall(request.getParameter("proimgSmall"));
		vo.setProimgBig(request.getParameter("proimgBig"));		
		vo.setBrand(request.getParameter("brand"));
		vo.setPrice(Integer.parseInt(request.getParameter("price")));
		vo.setStock(Integer.parseInt(request.getParameter("stock")));
		vo.setPronum(Integer.parseInt(pronum));
		
		ProductDAO Dao = ProductDAO.getInstance();
		Dao.productUpdate(vo);
		new ProductListAction().execute(request, response);

	}
}
