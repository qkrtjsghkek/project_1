package com.member.controller.action;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hosinsa.controller.HosinsaAction;
import com.hosinsa.dao.MemberDAO;
import com.hosinsa.dto.MemberVO;

public class MemberJoinAction implements HosinsaAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 입력한 회원정보를 받아와 DB에 값을 넣어줌
		MemberVO vo = new MemberVO();
		// 날짜 데이터 변환
		String birthday = request.getParameter("birthday");
		LocalDate ld = LocalDate.parse(birthday);
		Date date = java.sql.Date.valueOf(ld);
		// 핸드폰 번호
		String phone = request.getParameter("phone_first") + "-" + request.getParameter("phone_center") + "-" + request.getParameter("phone_last");
		
		vo.setId(request.getParameter("id"));
		vo.setPw(request.getParameter("pw"));
		vo.setName(request.getParameter("name"));
		vo.setGender(request.getParameter("gender"));
		vo.setBirthday(date);
		vo.setPhone(phone);
		vo.setZipcode(Integer.parseInt(request.getParameter("zipcode")));
		vo.setAddress(request.getParameter("address"));
		vo.setGrade(request.getParameter("grade"));
		
		// 이메일 선택하는 곳 에서 "직접입력"이란 값이 들어오면 직접입력한 메일 주소의 값이 들어오고
		// 선택한 이메일 주소가 오면 선택한 이메일 그대로 보내준다.
		String mail = request.getParameter("email_site");
		String mailWrite = request.getParameter("email_write");
		if(mail.equals("직접입력")) {
			vo.setEmail(request.getParameter("email_id") + "@" + mailWrite);
		}
		else {
			vo.setEmail(request.getParameter("email_id") + "@" + mail);
		}

		// 추천인이 있을시 point에 20000을 더하고,
		// 공백이면 그대로 50000을 넘겨준다.
		String intro = request.getParameter("introducer");
		if(intro.equals("") ) {
			vo.setIntroducer(request.getParameter("introducer"));
			vo.setPoint(Integer.parseInt(request.getParameter("point")));
		} else {
			vo.setIntroducer(request.getParameter("introducer"));
			vo.setPoint(Integer.parseInt(request.getParameter("point")) + 20000);
		}
		
		MemberDAO dao = MemberDAO.getInstance();
		int result = dao.insertMember(vo);
		
		// 회원가입에 성공하면 memberLogin.jsp화면에 회원가입 성공이라는 메세지 출력
		// 실패시 회원가입 실패 출력
		if(result == 1) {
			HttpSession session = request.getSession();
			session.setAttribute("id", vo.getId());
			request.setAttribute("message", "회원가입에 성공했습니다.");
		} else {
			request.setAttribute("message", "회원가입에 실패하였습니다.");
		}
		
		RequestDispatcher dis = request.getRequestDispatcher("HosinsaServlet?command=login");
		dis.forward(request, response);
	}
}
