package com.product.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hosinsa.controller.HosinsaAction;
import com.hosinsa.dao.ProductDAO;
import com.hosinsa.dto.ProductVO;

public class ProductCategorySearchAction implements HosinsaAction{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String search = request.getParameter("search_first");
		String value = request.getParameter("search_last");
		
		ProductVO vo = new ProductVO();
		ProductDAO dao = ProductDAO.getInstance();
		
		if (search.equals("제품번호")) { // 선택란에 제품번호를 선택했을때
			vo.setPronum(Integer.parseInt(value));
			List<ProductVO> list = dao.selectOnePredouctByPronumSearch(value);
			request.setAttribute("product_list", list);
			new ProductManageAction().execute(request, response);
		} else if (search.equals("제품이름")) { // 선택란에 제품이름을 선택했을때
			vo.setProname(value);
			List<ProductVO> list = dao.selectOnePredouctByPronameSearch(value);
			request.setAttribute("product_list", list);
			new ProductManageAction().execute(request, response);
		} else if (search.equals("브랜드")) {
			vo.setBrand(value);
			List<ProductVO> list = dao.selectOnePredouctByBrandSearch(value);
			request.setAttribute("product_list", list);
			new ProductManageAction().execute(request, response);
		} else {
			List<ProductVO> list = dao.selectAllProduct();
			request.setAttribute("product_list", list);
			new ProductManageAction().execute(request, response);
		}
	}
}
