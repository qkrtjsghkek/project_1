package com.member.controller.action;

import java.io.IOException;
import java.time.LocalDate;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hosinsa.controller.HosinsaAction;
import com.hosinsa.dao.MemberDAO;
import com.hosinsa.dto.MemberVO;



public class UserInfoUpdateAction implements HosinsaAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberVO vo = new MemberVO();	
		String birthday = request.getParameter("birthday");
		LocalDate ld = LocalDate.parse(birthday);
		Date date = java.sql.Date.valueOf(ld);
		
		vo.setId(request.getParameter("id"));
		vo.setPw(request.getParameter("pw"));
		vo.setName(request.getParameter("name"));
		vo.setGender(request.getParameter("gender"));
		vo.setBirthday(date);
		vo.setEmail(request.getParameter("email"));
		vo.setPhone(request.getParameter("phone"));
		vo.setZipcode(Integer.parseInt(request.getParameter("zipcode")));
		vo.setAddress(request.getParameter("address"));
		vo.setIntroducer(request.getParameter("introducer"));

		MemberDAO dao = MemberDAO.getInstance();
		dao.userInfoUpdate(vo);
		new UserInfoViewAction().execute(request, response);
	}


}
