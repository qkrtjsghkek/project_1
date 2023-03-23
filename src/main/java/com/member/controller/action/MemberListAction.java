package com.member.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hosinsa.controller.HosinsaAction;
import com.hosinsa.dao.MemberDAO;
import com.hosinsa.dto.MemberVO;



public class MemberListAction implements HosinsaAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberVO vo = new MemberVO();
		MemberDAO dao = MemberDAO.getInstance();
		String grade = request.getParameter("grade");
		
		if (grade.equals("전체") || grade.equals("")) {
			List<MemberVO> list = dao.selectAllMembers();
			request.setAttribute("member_list", list);
			new MemberListFormAction().execute(request, response);
		}
		
		else {
			vo.setGrade(grade);
			List<MemberVO> list = dao.selectOneMemberByGrade(grade);
			request.setAttribute("member_list", list);
			new MemberListFormAction().execute(request, response);
		}
	}
}
