package com.member.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hosinsa.controller.HosinsaAction;
import com.hosinsa.dao.MemberDAO;

public class MemberIdCheckAction implements HosinsaAction{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		MemberDAO dao = MemberDAO.getInstance();
		int result = dao.confirmID(id);
		
		request.setAttribute("id", id);
		request.setAttribute("result", result);
		
		RequestDispatcher dis = request.getRequestDispatcher("/member/memberIdCheck.jsp");
		dis.forward(request, response);
	}

}
