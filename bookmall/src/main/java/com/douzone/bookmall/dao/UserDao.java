package com.douzone.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.douzone.bookmall.vo.CategoryVo;
import com.douzone.bookmall.vo.UserVo;

public class UserDao {
	public Boolean insert(UserVo vo) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		try {
			conn = getConnection(); // url, 아이디, 비번

			String sql = "insert into user values(null, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);

//			pstmt.setLong(1, vo.getNo());
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPhone_no());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getPw());

			int count = pstmt.executeUpdate();
			result = count == 1;

		} catch (SQLException e) {
			System.out.println("error : " + e);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public List findAll() {
		List<UserVo> result = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();

			String sql = "select * from user";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Long no = rs.getLong(1);
				String name = rs.getString(2);
				String phone_no = rs.getString(3);
				String email = rs.getString(4);
				String pw = rs.getString(5);

				UserVo vo = new UserVo();
				vo.setNo(no);
				vo.setName(name);
				vo.setPhone_no(phone_no);
				vo.setEmail(email);
				vo.setPw(pw);
				
				result.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("error : " + e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");

			String url = "jdbc:mysql://192.168.254.31:3307/bookmall";
			conn = DriverManager.getConnection(url, "bookmall", "bookmall"); // url, 아이디, 비번

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패 : " + e);
		}
		return conn;
	}
}
