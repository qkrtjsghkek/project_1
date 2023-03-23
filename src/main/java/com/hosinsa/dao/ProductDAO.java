package com.hosinsa.dao;

import java.sql.*;
import java.util.*;

import com.hosinsa.dto.ProductVO;

import util.DBManager;

public class ProductDAO {
	private ProductDAO() {
	}
	
	private static ProductDAO instance = new ProductDAO();
	
	public static ProductDAO getInstance() {
		return instance;
	}
	//상품관리 페이지 카테고리 전체
	public List<ProductVO> selectAllProduct() {
		List<ProductVO> list = new ArrayList<ProductVO>();
		String sql = "SELECT * FROM HOSINSA_PRODUCT";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ProductVO vo = new ProductVO();
				vo.setCategory(rs.getString("category"));
				vo.setProname(rs.getString("proname"));
				vo.setProimgSmall(rs.getString("proimg_s"));
				vo.setProimgBig(rs.getString("proimg_b"));
				vo.setBrand(rs.getString("brand"));
				vo.setPronum(rs.getInt("pronum"));
				vo.setPrice(rs.getInt("price"));
				vo.setStock(rs.getInt("stock"));
				vo.setProview(rs.getInt("proview"));
				list.add(vo);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}		
		return list;
	}
	// 상품관리 페이지 카테고리 선택
	public List<ProductVO> selectOneProductByCategory(String category) {
		List<ProductVO> list = new ArrayList<ProductVO>();
		String sql = "SELECT * FROM HOSINSA_PRODUCT WHERE CATEGORY=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ProductVO vo = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, category);
			rs = pstmt.executeQuery();
		
			while(rs.next()) {
				vo = new ProductVO();
				vo.setCategory(rs.getString("category"));
				vo.setProname(rs.getString("proname"));
				vo.setProimgSmall(rs.getString("proimg_s"));
				vo.setProimgBig(rs.getString("proimg_b"));
				vo.setBrand(rs.getString("brand"));
				vo.setPronum(rs.getInt("pronum"));
				vo.setPrice(rs.getInt("price"));
				vo.setStock(rs.getInt("stock"));
				vo.setProview(rs.getInt("proview"));   
				list.add(vo);
			}
		
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	public ProductVO selectOneProductByPronum(String pronum) {
		String sql = "SELECT * FROM HOSINSA_PRODUCT WHERE PRONUM=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ProductVO vo = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pronum);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo = new ProductVO();
				vo.setCategory(rs.getString("category"));
				vo.setProname(rs.getString("proname"));
				vo.setProimgSmall(rs.getString("proimg_s"));
				vo.setProimgBig(rs.getString("proimg_b"));
				vo.setBrand(rs.getString("brand"));
				vo.setPronum(rs.getInt("pronum"));
				vo.setPrice(rs.getInt("price"));
				vo.setStock(rs.getInt("stock"));
				vo.setProview(rs.getInt("proview"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return vo;
	}
	
	public ProductVO selectOneProductByProname(String proname) {
		String sql = "SELECT * FROM HOSINSA_PRODUCT WHERE PRONAME=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ProductVO vo = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, proname);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo = new ProductVO();
				vo.setCategory(rs.getString("category"));
				vo.setProname(rs.getString("proname"));
				vo.setProimgSmall(rs.getString("proimg_s"));
				vo.setProimgBig(rs.getString("proimg_b"));
				vo.setBrand(rs.getString("brand"));
				vo.setPronum(rs.getInt("pronum"));
				vo.setPrice(rs.getInt("price"));
				vo.setStock(rs.getInt("stock"));
				vo.setProview(rs.getInt("proview"));	
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return vo;
	}
	// 제품 추가
	public void insertProduct(ProductVO pVo) {
		String sql = "insert into HOSINSA_PRODUCT(category,proname,PROIMG_S,PROIMG_B,brand,pronum,price,stock)"
				+ "VALUES(?,?,?,?,?,?,?,?)";
 		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn=DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);			
			pstmt.setString(1, pVo.getCategory());
			pstmt.setString(2, pVo.getProname());
			pstmt.setString(3, pVo.getProimgSmall());
			pstmt.setString(4, pVo.getProimgBig());
			pstmt.setString(5, pVo.getBrand());
			pstmt.setInt(6, pVo.getPronum());
			pstmt.setInt(7, pVo.getPrice());
			pstmt.setInt(8, pVo.getStock());			
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	// 제품 정보 수정
	public void productUpdate(ProductVO vo) {
		String sql = "UPDATE HOSINSA_PRODUCT SET CATEGORY=?,PRONAME=?,PROIMG_S=?,PROIMG_B=?,BRAND=?,PRICE=?,STOCK=? WHERE PRONUM=?";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getCategory());
			pstmt.setString(2, vo.getProname());
			pstmt.setString(3,vo.getProimgSmall());
			pstmt.setString(4, vo.getProimgBig());
			pstmt.setString(5, vo.getBrand());
			pstmt.setInt(6, vo.getPrice());
			pstmt.setInt(7, vo.getStock());
			pstmt.setInt(8, vo.getPronum());
			pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	public int confirmPronum(int pronum) {
		int result = -1;
		String sql = "SELECT pronum FROM HOSINSA_PRODUCT WHERE pronum =?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {	
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pronum);
			rs = pstmt.executeQuery();
			
			if(rs.next()) { result = 1; }
			else { result = -1; }			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}		
		return result;
	}
	
	// 제품삭제
	public void deleteProduct(String num) {
		String sql = "delete HOSINSA_PRODUCT where pronum = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	public void updateProviewCount(String pronum) {
		String sql = "UPDATE HOSINSA_PRODUCT set PROVIEW= PROVIEW+1 WHERE PRONUM=?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, pronum);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	// 메인페이지 상품리스트 인기
	public List<ProductVO> mainViewRanking() {
		List<ProductVO> list = new ArrayList<ProductVO>();
		String sql = "SELECT * FROM (SELECT*FROM HOSINSA_PRODUCT ORDER BY PROVIEW DESC) WHERE ROWNUM <= 90";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ProductVO vo = new ProductVO();
				vo.setCategory(rs.getString("category"));
				vo.setProname(rs.getString("proname"));
				vo.setProimgSmall(rs.getString("proimg_s"));
				vo.setProimgBig(rs.getString("proimg_b"));
				vo.setBrand(rs.getString("brand"));
				vo.setPronum(rs.getInt("pronum"));
				vo.setPrice(rs.getInt("price"));
				vo.setStock(rs.getInt("stock"));
				vo.setProview(rs.getInt("proview"));
				list.add(vo);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}		
		return list;
	}
	// 메인페이지 상품리스트 카테고리
	public List<ProductVO> mainViewCategory(String category) {
		List<ProductVO> list = new ArrayList<ProductVO>();
		String sql = "SELECT * FROM HOSINSA_PRODUCT WHERE CATEGORY=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, category);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductVO vo = new ProductVO(); 
				vo.setCategory(rs.getString("category"));
				vo.setProname(rs.getString("proname"));
				vo.setProimgSmall(rs.getString("proimg_s"));
				vo.setProimgBig(rs.getString("proimg_b"));
				vo.setBrand(rs.getString("brand"));
				vo.setPronum(rs.getInt("pronum"));
				vo.setPrice(rs.getInt("price"));
				vo.setStock(rs.getInt("stock"));
				vo.setProview(rs.getInt("proview"));
				list.add(vo);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}		
		return list;
	}
	// 검색어 입력시 리스트 불러오는 메소드 (제품번호 입력시)
	public List<ProductVO> selectOnePredouctByPronumSearch(String pronum) {
		List<ProductVO> list = new ArrayList<ProductVO>();
		String sql = "SELECT * FROM HOSINSA_PRODUCT WHERE PRONUM=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pronum);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ProductVO vo = new ProductVO();
				vo.setCategory(rs.getString("category"));
				vo.setProname(rs.getString("proname"));
				vo.setProimgSmall(rs.getString("proimg_s"));
				vo.setProimgBig(rs.getString("proimg_b"));
				vo.setBrand(rs.getString("brand"));
				vo.setPronum(rs.getInt("pronum"));
				vo.setPrice(rs.getInt("price"));
				vo.setStock(rs.getInt("stock"));
				vo.setProview(rs.getInt("proview"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
		
	// 검색어 입력시 리스트 불러오는 메소드 (제품이름 입력시)
	public List<ProductVO> selectOnePredouctByPronameSearch(String proname) {
		List<ProductVO> list = new ArrayList<ProductVO>();
		String sql = "SELECT * FROM HOSINSA_PRODUCT WHERE PRONAME LIKE ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + proname + "%");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ProductVO vo = new ProductVO();
				vo.setCategory(rs.getString("category"));
				vo.setProname(rs.getString("proname"));
				vo.setProimgSmall(rs.getString("proimg_s"));
				vo.setProimgBig(rs.getString("proimg_b"));
				vo.setBrand(rs.getString("brand"));
				vo.setPronum(rs.getInt("pronum"));
				vo.setPrice(rs.getInt("price"));
				vo.setStock(rs.getInt("stock"));
				vo.setProview(rs.getInt("proview"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
		
	// 검색어 입력시 리스트 불러오는 메소드 (브랜드 입력시)
	public List<ProductVO> selectOnePredouctByBrandSearch(String brand) {
		List<ProductVO> list = new ArrayList<ProductVO>();
		String sql = "SELECT * FROM HOSINSA_PRODUCT WHERE BRAND LIKE ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + brand + "%");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ProductVO vo = new ProductVO();
				vo.setCategory(rs.getString("category"));
				vo.setProname(rs.getString("proname"));
				vo.setProimgSmall(rs.getString("proimg_s"));
				vo.setProimgBig(rs.getString("proimg_b"));
				vo.setBrand(rs.getString("brand"));
				vo.setPronum(rs.getInt("pronum"));
				vo.setPrice(rs.getInt("price"));
				vo.setStock(rs.getInt("stock"));
				vo.setProview(rs.getInt("proview"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
}
