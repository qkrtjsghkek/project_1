package com.member.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hosinsa.controller.HosinsaAction;
import com.hosinsa.dao.MemberDAO;
import com.hosinsa.dto.MemberVO;

public class MemberManageAction implements HosinsaAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String grade = request.getParameter("grade");
		System.out.println(id);
		System.out.println(name);
		System.out.println(grade);
		
		MemberVO vo = new MemberVO();
		vo.setId(request.getParameter("id"));
		vo.setName(request.getParameter("name"));
		vo.setGrade(request.getParameter("grade"));
		vo.setPoint(Integer.parseInt(request.getParameter("point")));
		
		MemberDAO dao = MemberDAO.getInstance();
		dao.memberManage(vo);
		new MemberListAction().execute(request, response);
	}
}

