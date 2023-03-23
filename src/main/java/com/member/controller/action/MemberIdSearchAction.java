package com.member.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hosinsa.controller.HosinsaAction;
import com.hosinsa.dao.MemberDAO;
import com.hosinsa.dto.MemberVO;

public class MemberIdSearchAction implements HosinsaAction{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String search = request.getParameter("search_first");
		String value = request.getParameter("search_last");
		System.out.println(search);
		System.out.println(value);
		
		MemberVO vo = new MemberVO();
		MemberDAO dao = MemberDAO.getInstance();
		
		if (search.equals("아이디")) {
			vo.setId(value);
			List<MemberVO> list = dao.selectOneMemberByIdSearch(value);
			request.setAttribute("member_list", list);
			new MemberListFormAction().execute(request, response);
		}
		else if (search.equals("이름")) {
			vo.setName(value);
			List<MemberVO> list = dao.selectOneMemberByNameSearch(value);
			request.setAttribute("member_list", list);
			new MemberListFormAction().execute(request, response);
		}
		else {
			List<MemberVO> list = dao.selectAllMembers();
			request.setAttribute("member_list", list);
			new MemberListFormAction().execute(request, response);
		}
	}
}
