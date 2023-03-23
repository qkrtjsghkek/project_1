package com.hosinsa.dao;

import java.sql.*;
import java.util.*;
import util.DBManager;

import com.hosinsa.dto.MemberVO;


public class MemberDAO {
	private MemberDAO() {
	}
	
	private static MemberDAO instance = new MemberDAO();
	
	public static MemberDAO getInstance() {
		return instance;
	}
	
	//기존 회원여부 확인
	public int userCheck(String id, String pw) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT PW FROM HOSINSA_MEMBER WHERE ID=?";
		int result = -1;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) { //아이디가 있다.
				if(rs.getString("pw") != null && rs.getString("pw").equals(pw)) {
					result = 1; //아이디가 존재하고, 비밀번호도 존재한다.
				}
				else {
					result = 0; //아이디가 존재하고, 비밀번호 틀리다.
				}
			}			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}		
		return result;
	}
	// 로그인 유저 이름,등급 가져오는 메소드
	public MemberVO getNameMember(String id) {
		MemberVO vo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM HOSINSA_MEMBER WHERE ID=?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
				vo.setGrade(rs.getString("grade"));
			}			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return vo;
	}
	// 아이디 중복체크 메소드
	public int confirmID(String id) {
		int result = -1;
		String sql = "SELECT ID FROM HOSINSA_MEMBER WHERE ID =?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {	
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
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
	// Create r u d (회원가입 메소드)
	public int insertMember(MemberVO vo) {
		String sql = "INSERT INTO HOSINSA_MEMBER VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
		int result = -1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getGender());
			pstmt.setDate(5, vo.getBirthday());
			pstmt.setString(6, vo.getEmail());
			pstmt.setString(7, vo.getPhone());
			pstmt.setInt(8, vo.getZipcode());
			pstmt.setString(9, vo.getAddress());
			pstmt.setString(10, vo.getIntroducer());
			pstmt.setString(11, vo.getGrade());
			pstmt.setInt(12, vo.getPoint());
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return result;
	}
	// c Read u d
	public List<MemberVO> selectAllMembers() {
		List<MemberVO> list = new ArrayList<MemberVO>();
		String sql = "SELECT * FROM HOSINSA_MEMBER";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
				vo.setGrade(rs.getString("grade"));
				vo.setPoint(rs.getInt("point"));
				list.add(vo);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}		
		return list;
	}
	// c Read u d
	public MemberVO selectOneMemberById(String id) {
		String sql = "SELECT * FROM HOSINSA_MEMBER WHERE ID=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVO vo = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setPw(rs.getString("pw"));
				vo.setName(rs.getString("name"));
				vo.setGender(rs.getString("gender"));
				vo.setBirthday(rs.getDate("birthday"));
				vo.setEmail(rs.getString("email"));
				vo.setPhone(rs.getString("phone"));
				vo.setZipcode(rs.getInt("zipcode"));
				vo.setAddress(rs.getString("address"));
				vo.setIntroducer(rs.getString("introducer"));				
				vo.setGrade(rs.getString("grade"));
				vo.setPoint(rs.getInt("point"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return vo;
	}
	// c r Update d
	public void memberManage(MemberVO vo) {
		String sql = "UPDATE HOSINSA_MEMBER SET GRADE=?,POINT=? WHERE ID=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getGrade());
			pstmt.setInt(2, vo.getPoint());
			pstmt.setString(3, vo.getId());
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	public void userInfoUpdate(MemberVO vo) {
		String sql = "UPDATE HOSINSA_MEMBER SET PW=?,NAME=?,BIRTHDAY=?,GENDER=?,EMAIL=?,PHONE=?,ZIPCODE=?,ADDRESS=?,INTRODUCER=? WHERE ID=?";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getPw());
			pstmt.setString(2, vo.getName());
			pstmt.setDate(3,vo.getBirthday());
			pstmt.setString(4, vo.getGender());
			pstmt.setString(5, vo.getEmail());
			pstmt.setString(6, vo.getPhone());
			pstmt.setInt(7, vo.getZipcode());
			pstmt.setString(8, vo.getAddress());
			pstmt.setString(9, vo.getIntroducer());
			pstmt.setString(10, vo.getId());
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	// 아이디 중복체크 메소드
	public int confirmIntroducer(String introducer) {
		int result = -1;
		String sql = "SELECT ID FROM HOSINSA_MEMBER WHERE ID =?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {	
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, introducer);
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
	// 검색어 입력시 회원 정보 불러오는 메소드 (등급 입력시)
	public List<MemberVO> selectOneMemberByGrade(String grade) {
		List<MemberVO> list = new ArrayList<MemberVO>();
		String sql = "SELECT * FROM HOSINSA_MEMBER WHERE GRADE=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, grade);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {				
				MemberVO vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setPw(rs.getString("pw"));
				vo.setName(rs.getString("name"));
				vo.setGender(rs.getString("gender"));
				vo.setBirthday(rs.getDate("birthday"));
				vo.setEmail(rs.getString("email"));
				vo.setPhone(rs.getString("phone"));
				vo.setZipcode(rs.getInt("zipcode"));
				vo.setAddress(rs.getString("address"));
				vo.setIntroducer(rs.getString("introducer"));				
				vo.setGrade(rs.getString("grade"));
				vo.setPoint(rs.getInt("point"));
				list.add(vo);				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}	
	// 검색어 입력시 회원 정보 불러오는 메소드 (아이디 입력시)
	public List<MemberVO> selectOneMemberByIdSearch(String id) {
		List<MemberVO> list = new ArrayList<MemberVO>();
		String sql = "SELECT * FROM HOSINSA_MEMBER WHERE ID LIKE ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + id + "%");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setPw(rs.getString("pw"));
				vo.setName(rs.getString("name"));
				vo.setGender(rs.getString("gender"));
				vo.setBirthday(rs.getDate("birthday"));
				vo.setEmail(rs.getString("email"));
				vo.setPhone(rs.getString("phone"));
				vo.setZipcode(rs.getInt("zipcode"));
				vo.setAddress(rs.getString("address"));
				vo.setIntroducer(rs.getString("introducer"));				
				vo.setGrade(rs.getString("grade"));
				vo.setPoint(rs.getInt("point"));
				list.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}		
		return list;
	}
	
	// 검색어 입력시 회원 정보 불러오는 메소드 (이름 입력시)
	public List<MemberVO> selectOneMemberByNameSearch(String name) {
		List<MemberVO> list = new ArrayList<MemberVO>();
		String sql = "SELECT * FROM HOSINSA_MEMBER WHERE NAME LIKE ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + name + "%");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setPw(rs.getString("pw"));
				vo.setName(rs.getString("name"));
				vo.setGender(rs.getString("gender"));
				vo.setBirthday(rs.getDate("birthday"));
				vo.setEmail(rs.getString("email"));
				vo.setPhone(rs.getString("phone"));
				vo.setZipcode(rs.getInt("zipcode"));
				vo.setAddress(rs.getString("address"));
				vo.setIntroducer(rs.getString("introducer"));				
				vo.setGrade(rs.getString("grade"));
				vo.setPoint(rs.getInt("point"));
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
