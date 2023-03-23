package com.member.controller.action;

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
import com.hosinsa.dto.OrderVO;

public class OrderListAction implements HosinsaAction{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "member/memberOrderList.jsp";
		CartDAO dao = CartDAO.getInstance();
		HttpSession session = request.getSession();
		MemberVO vo = (MemberVO)session.getAttribute("loginUser");
		String id = vo.getId();
		List<OrderVO> list = dao.getOrder(id);
		request.setAttribute("list",list);		
		
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);
	}
}
