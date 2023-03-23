package com.member.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hosinsa.controller.HosinsaAction;
import com.hosinsa.dao.MemberDAO;
import com.hosinsa.dto.MemberVO;


public class UserPwCheckAction implements HosinsaAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = null;
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		MemberDAO dao = MemberDAO.getInstance();
		MemberVO vo = dao.selectOneMemberById(id);
		
		if(vo.getPw().equals(pw)) { // 비밀번호 일치
			url = "/member/userPwCheckSuccess.jsp";
		}
		else { // 비밀번호 불일치
			url = "/member/userPwCheck.jsp";
			request.setAttribute("message", "비밀번호가 틀렸습니다.");
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
}
