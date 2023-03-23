package com.member.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hosinsa.controller.HosinsaAction;
import com.hosinsa.dao.MemberDAO;
import com.hosinsa.dto.MemberVO;


public class MemberViewAction implements HosinsaAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/member/memberView.jsp";
		String id = request.getParameter("id");
		MemberDAO dao = MemberDAO.getInstance();
		
		MemberVO vo = dao.selectOneMemberById(id);
		request.setAttribute("member", vo);
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
}
