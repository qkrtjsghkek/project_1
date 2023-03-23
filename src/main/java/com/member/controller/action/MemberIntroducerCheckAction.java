package com.member.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hosinsa.controller.HosinsaAction;
import com.hosinsa.dao.MemberDAO;

public class MemberIntroducerCheckAction implements HosinsaAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String introducer = request.getParameter("introducer");
		
		MemberDAO dao = MemberDAO.getInstance();
		int result = dao.confirmIntroducer(introducer);
		
		request.setAttribute("introducer", introducer);
		request.setAttribute("result", result);
		
		RequestDispatcher dis = request.getRequestDispatcher("/member/memberIntroducerCheck.jsp");
		dis.forward(request, response);
	}
}
