package com.hosinsa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hosinsa.dto.CartVO;
import com.hosinsa.dto.OrderVO;
import com.hosinsa.dto.ProductVO;

import util.DBManager;

public class CartDAO {
	private CartDAO() {} //싱글톤 패턴
	private static CartDAO instance=new CartDAO();
	public static CartDAO getInstance() {
		return instance;
	}
	
	public List<ProductVO> SelectAllCart(String id){
		List<ProductVO> list=new ArrayList<>();
		DBManager.getConnection();
		String sql="SELECT * FROM HOSINSA_PRODUCT WHERE PRONUM IN (SELECT PRONUM FROM HOSINSA_CART where id=?) ORDER BY PRONUM";		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,id);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				ProductVO vo=new ProductVO();
				vo.setCategory(rs.getString("CATEGORY"));
				vo.setProname(rs.getString("PRONAME"));
				vo.setProimgSmall(rs.getString("PROIMG_S"));
				vo.setProimgBig(rs.getString("PROIMG_B"));
				vo.setBrand(rs.getString("BRAND"));
				vo.setPronum(rs.getInt("PRONUM"));
				vo.setPrice(rs.getInt("PRICE"));
				vo.setStock(rs.getInt("STOCK"));
				vo.setProview(rs.getInt("PROVIEW"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn,pstmt,rs);
		}
		return list;
	}
	
	public List<CartVO> selectAllCart2(String id) {
		List<CartVO> list=new ArrayList<>();
		String sql="SELECT * FROM HOSINSA_CART WHERE ID=? ORDER BY PRONUM";		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,id);
			rs=pstmt.executeQuery();
			while(rs.next()) {
			CartVO vo=new CartVO();
			vo.setCartnum(rs.getInt("CARTNUM"));
			vo.setId(rs.getString("ID"));
			vo.setPronum(rs.getInt("PRONUM"));
			vo.setQuantity(rs.getInt("QUANTITY"));
			list.add(vo);					
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn,pstmt,rs);
		}
		return list;
	}
	
	public void resetCart(String id) {
		String sql="DELETE FROM HOSINSA_CART WHERE ID=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn,pstmt);
		}
	}
	
	public void deleteItem(String cartnum) {
		String sql="DELETE FROM HOSINSA_CART WHERE CARTNUM=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, cartnum);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn,pstmt);
		}
	}
	
	public void modifyValue(String cartnum,String value) {
		String sql="UPDATE HOSINSA_CART SET QUANTITY=? WHERE CARTNUM=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,value);
			pstmt.setString(2,cartnum);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	public void addToCart(CartVO vo) {
		String sql="INSERT INTO HOSINSA_CART VALUES(CART_SEQ.NEXTVAL,?,?,?)";
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,vo.getId());
			pstmt.setInt(2,vo.getPronum());
			pstmt.setInt(3,vo.getQuantity());
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	public int getPoint (String id) {
		int point =0;
		String sql="SELECT point FROM HOSINSA_member WHERE ID=?";		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,id);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				point=rs.getInt("point");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn,pstmt,rs);
		}
		return point;
	}
	
	public void minusPoint(String id,int use_pnt) {
		String sql ="update hosinsa_member set point = point-? where id=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,use_pnt);
			pstmt.setString(2,id);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn,pstmt);
		}
	}
	
	public List<ProductVO> getListByPronum(String[] pronum){
		List<ProductVO> list=new ArrayList<>();
		for(int i=0;i<pronum.length;i++) {
			String sql="SELECT * FROM HOSINSA_PRODUCT WHERE PRONUM=?";		
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			try {
				conn=DBManager.getConnection();
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1,pronum[i]);
				rs=pstmt.executeQuery();
				while(rs.next()) {
				ProductVO vo=new ProductVO();
				vo.setPronum(rs.getInt("PRONUM"));
				vo.setProname(rs.getString("PRONAME"));
				vo.setStock(rs.getInt("STOCK"));
				vo.setPrice(rs.getInt("PRICE"));				
				list.add(vo);					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				DBManager.close(conn,pstmt,rs);
			}
		}
		return list;
	}
	
	public void minusStock(String[] pronum, String[] quantity) {
		int num=pronum.length;
		for(int i=0;i<num;i++) {
			String sql="UPDATE HOSINSA_PRODUCT SET STOCK=STOCK-? WHERE PRONUM=?";
			Connection conn=null;
			PreparedStatement pstmt=null;			
			try {
				conn=DBManager.getConnection();
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1,quantity[i]);
				pstmt.setString(2,pronum[i]);
				pstmt.executeUpdate();				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				DBManager.close(conn,pstmt);
			}
			
		}
		
	}
	
	public void saveOrder(String id,String total) {
		String sql="INSERT INTO HOSINSA_ORDER VALUES(ORDER_SEQ.NEXTVAL,?,SYSDATE,?)";
		Connection conn=null;
		PreparedStatement pstmt=null;		
		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,id);
			pstmt.setString(2,total);
			pstmt.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn,pstmt);
		}
	}
	
	public List<OrderVO> getOrder(String id){
		List<OrderVO> list=new ArrayList<>();
		String sql="SELECT * FROM HOSINSA_ORDER WHERE ID=?";		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,id);
			rs=pstmt.executeQuery();
			while(rs.next()) {
			OrderVO vo=new OrderVO();
			vo.setOrdernum(rs.getInt("ORDERNUM"));
			vo.setId(rs.getString("ID"));
			vo.setOrderdate(rs.getString("ORDERDATE"));
			vo.setPrice(rs.getInt("PRICE"));
			list.add(vo);					
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn,pstmt,rs);
		}
		return list;
	}
	
	public int getSpareCart(String id,int Pronum) {
		String sql="SELECT CARTNUM FROM HOSINSA_CART WHERE ID=? AND PRONUM=?";
		int result=0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,id);
			pstmt.setInt(2, Pronum);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				result=rs.getInt("CARTNUM");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn,pstmt,rs);
		}
		return result;
	}
	
	public void plusQuantity(int cartnum,int quantity) {
		String sql="UPDATE HOSINSA_CART SET QUANTITY=QUANTITY+? WHERE CARTNUM=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,quantity);
			pstmt.setInt(2,cartnum);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
}
