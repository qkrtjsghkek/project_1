package com.hosinsa.crwaling;

import java.sql.*;
import java.util.*;

import com.hosinsa.dto.ProductVO;

public class ProductDbSetting {
	private static String driver="oracle.jdbc.driver.OracleDriver";
	private static String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
	private static String user="scott";
	private static String pwd="1234";
	
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ArrayList<ProductVO> topList = Product_Crawling_top.product_crawling();
		ArrayList<ProductVO> outerList = Product_Crawling_outer.product_crawling();
		ArrayList<ProductVO> pantsList = Product_Crawling_pants.product_crawling();
		ArrayList<ProductVO> onepieceList = Product_Crawling_onepiece.product_crawling();
		ArrayList<ProductVO> skirtList = Product_Crawling_skirt.product_crawling();
		ArrayList<ProductVO> shoesList = Product_Crawling_shoes.product_crawling();

		try {
			Class.forName(driver);
			System.out.println("드라이브 로드 성공");
			
			conn = DriverManager.getConnection(url,user,pwd);
			System.out.println(conn);
			
			String sql = "INSERT INTO HOSINSA_PRODUCT VALUES(?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			for(ProductVO vo : topList) {
				pstmt.setString(1, vo.getCategory());
				pstmt.setString(2, vo.getProname());
				pstmt.setString(3, vo.getProimgSmall());
				pstmt.setString(4, vo.getProimgBig());
				pstmt.setString(5, vo.getBrand());
				pstmt.setInt(6, vo.getPronum());
				pstmt.setInt(7, vo.getPrice());
				pstmt.setInt(8, vo.getStock());
				pstmt.setInt(9, vo.getProview());
				pstmt.executeUpdate();		
			}
			for(ProductVO vo : outerList) {
				pstmt.setString(1, vo.getCategory());
				pstmt.setString(2, vo.getProname());
				pstmt.setString(3, vo.getProimgSmall());
				pstmt.setString(4, vo.getProimgBig());
				pstmt.setString(5, vo.getBrand());
				pstmt.setInt(6, vo.getPronum());
				pstmt.setInt(7, vo.getPrice());
				pstmt.setInt(8, vo.getStock());
				pstmt.setInt(9, vo.getProview());
				pstmt.executeUpdate();		
			}
			for(ProductVO vo : pantsList) {
				pstmt.setString(1, vo.getCategory());
				pstmt.setString(2, vo.getProname());
				pstmt.setString(3, vo.getProimgSmall());
				pstmt.setString(4, vo.getProimgBig());
				pstmt.setString(5, vo.getBrand());
				pstmt.setInt(6, vo.getPronum());
				pstmt.setInt(7, vo.getPrice());
				pstmt.setInt(8, vo.getStock());
				pstmt.setInt(9, vo.getProview());
				pstmt.executeUpdate();		
			}
			for(ProductVO vo : onepieceList) {
				pstmt.setString(1, vo.getCategory());
				pstmt.setString(2, vo.getProname());
				pstmt.setString(3, vo.getProimgSmall());
				pstmt.setString(4, vo.getProimgBig());
				pstmt.setString(5, vo.getBrand());
				pstmt.setInt(6, vo.getPronum());
				pstmt.setInt(7, vo.getPrice());
				pstmt.setInt(8, vo.getStock());
				pstmt.setInt(9, vo.getProview());
				pstmt.executeUpdate();		
			}
			for(ProductVO vo : skirtList) {
				pstmt.setString(1, vo.getCategory());
				pstmt.setString(2, vo.getProname());
				pstmt.setString(3, vo.getProimgSmall());
				pstmt.setString(4, vo.getProimgBig());
				pstmt.setString(5, vo.getBrand());
				pstmt.setInt(6, vo.getPronum());
				pstmt.setInt(7, vo.getPrice());
				pstmt.setInt(8, vo.getStock());
				pstmt.setInt(9, vo.getProview());
				pstmt.executeUpdate();		
			}
			for(ProductVO vo : shoesList) {
				pstmt.setString(1, vo.getCategory());
				pstmt.setString(2, vo.getProname());
				pstmt.setString(3, vo.getProimgSmall());
				pstmt.setString(4, vo.getProimgBig());
				pstmt.setString(5, vo.getBrand());
				pstmt.setInt(6, vo.getPronum());
				pstmt.setInt(7, vo.getPrice());
				pstmt.setInt(8, vo.getStock());
				pstmt.setInt(9, vo.getProview());
				pstmt.executeUpdate();		
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
