package com.product.controller.action;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hosinsa.controller.HosinsaAction;
import com.hosinsa.dao.ProductDAO;
import com.hosinsa.dto.ProductVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class ProductWriteAction implements HosinsaAction{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String encType = "UTF-8";
		ServletContext context = request.getSession().getServletContext();
		
		MultipartRequest multi = null;
		String path = context.getRealPath("/product/images");
		int sizeLimit = 20 * 1024 * 1024;
		
		try {
			multi = new MultipartRequest(request, path, sizeLimit, "UTF-8", new DefaultFileRenamePolicy()); 

		} catch(Exception e) {
			e.printStackTrace();
		}
		
		String category = multi.getParameter("category");
		String proname = multi.getParameter("proname");
		String proimgSmall = multi.getFilesystemName("proimg");
		String proimgBig = multi.getFilesystemName("proimg");
		String brand = multi.getParameter("brand");
		int pronum = Integer.parseInt(multi.getParameter("pronum"));
		int price = Integer.parseInt(multi.getParameter("price"));
		int stock = Integer.parseInt(multi.getParameter("stock"));
		
		System.out.println(proimgBig);
		System.out.println(pronum);
		ProductVO vo = new ProductVO();		
		vo.setCategory(category);
		vo.setProname(proname);
		vo.setProimgSmall(proimgSmall);
		vo.setProimgBig(proimgBig);
		vo.setBrand(brand);
		vo.setPronum(pronum);
		vo.setPrice(price);
		vo.setStock(stock);
		
		ProductDAO dao = ProductDAO.getInstance();
		dao.insertProduct(vo);
		response.sendRedirect("HosinsaServlet?command=product_list&category");
	}
}
