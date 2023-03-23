package com.cart.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hosinsa.controller.HosinsaAction;
import com.hosinsa.dao.CartDAO;
import com.hosinsa.dto.CartVO;


public class CartInAction implements HosinsaAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pronum = request.getParameter("pronum");
		String quantity = request.getParameter("quantity");

		CartVO vo=new CartVO();
		vo.setId(id);
		vo.setPronum(Integer.parseInt(pronum));
		vo.setQuantity(Integer.parseInt(quantity));
		
		CartDAO dao = CartDAO.getInstance();
		
		//카트에 같은 물건이 있는지 확인
		int cartnum=dao.getSpareCart(id,Integer.parseInt(pronum));
		if(cartnum==0) {
			//카트에 같은 물건이 없을 경우
			dao.addToCart(vo);
		}else {
			//카트에 같은 물건이 있을 경우
			dao.plusQuantity(cartnum,Integer.parseInt(quantity));
		}
		
				
		response.sendRedirect("HosinsaServlet?command=goods_view&pronum="+pronum);
	}
}
