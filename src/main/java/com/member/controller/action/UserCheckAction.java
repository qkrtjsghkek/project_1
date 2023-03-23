package com.member.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hosinsa.controller.HosinsaAction;
import com.hosinsa.dao.MemberDAO;
import com.hosinsa.dto.MemberVO;

public class UserCheckAction implements HosinsaAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "member/memberLogin.jsp";
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		MemberDAO dao = MemberDAO.getInstance();
		int result = dao.userCheck(id, pw);
		if (result == 1) {
			MemberVO vo = dao.getNameMember(id);
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", vo);
			request.setAttribute("message", "회원 가입에 성공했습니다.");
			url = "/HosinsaServlet?command=main&category";
		}
		else if (result == 0) {
			request.setAttribute("message", "비밀번호가 맞지 않습니다.");
		}
		else if (result == -1) {
			request.setAttribute("message", "존재하지 않는 회원입니다.");
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
