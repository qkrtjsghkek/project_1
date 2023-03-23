package com.cart.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hosinsa.controller.HosinsaAction;
import com.hosinsa.dao.CartDAO;
import com.hosinsa.dto.MemberVO;
import com.hosinsa.dto.ProductVO;

public class CartPurchaseAction implements HosinsaAction{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "cart/purchase.jsp";
		String total = request.getParameter("total");
		HttpSession session=request.getSession();
		MemberVO vo=(MemberVO)session.getAttribute("loginUser");
		String id=vo.getId();
		CartDAO dao = CartDAO.getInstance();
		int point = dao.getPoint(id);
		String[] pronum = request.getParameterValues("pronum");
		List<ProductVO> list = dao.getListByPronum(pronum);
		String[] quantity=request.getParameterValues("quantity");
		request.setAttribute("total", total);
		request.setAttribute("point", point);
		request.setAttribute("list", list);
		request.setAttribute("quantity", quantity);
		
		RequestDispatcher rd=request.getRequestDispatcher(url);
		rd.forward(request, response);	
	}
}

