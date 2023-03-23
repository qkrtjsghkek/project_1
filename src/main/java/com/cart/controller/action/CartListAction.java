package com.cart.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hosinsa.controller.HosinsaAction;
import com.hosinsa.dao.CartDAO;
import com.hosinsa.dto.CartVO;
import com.hosinsa.dto.ProductVO;

public class CartListAction implements HosinsaAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="cart/cartList.jsp";
		String id=request.getParameter("id");
		CartDAO dao=CartDAO.getInstance();
		List<ProductVO> list=dao.SelectAllCart(id);
		CartDAO dao2=CartDAO.getInstance();
		List<CartVO> list2=dao2.selectAllCart2(id);
		request.setAttribute("list", list);
		request.setAttribute("list2",list2);
		
		RequestDispatcher rd=request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
	
}
