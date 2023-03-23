package com.cart.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hosinsa.controller.HosinsaAction;
import com.hosinsa.dao.CartDAO;
import com.hosinsa.dto.MemberVO;
import com.hosinsa.dto.ProductVO;

public class CartPurchaseCompleteAction implements HosinsaAction{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "cart/purchaseComplete.jsp";
		String[] pronum= request.getParameterValues("pronum");
		String[] quantity=request.getParameterValues("quantity");
		String id = request.getParameter("id");
		int use_pnt = Integer.parseInt(request.getParameter("use_pnt"));
		CartDAO dao = CartDAO.getInstance();
		//주문 중복 요청 방지 기능
		HttpSession session=request.getSession();
		boolean flag=(boolean) session.getAttribute("flag");
		if(flag) {
			dao.minusPoint(id,use_pnt);
			dao.minusStock(pronum,quantity);
			dao.resetCart(id);
			flag=false;
			session.setAttribute("flag", flag);
		}
		
		String total=request.getParameter("total_cash");
		dao.saveOrder(id,total);
		List<ProductVO> list = dao.getListByPronum(pronum);
		int point=dao.getPoint(id);
		request.setAttribute("quantity", quantity);
		request.setAttribute("point", point);
		request.setAttribute("list", list);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
