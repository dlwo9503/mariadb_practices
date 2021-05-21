package com.douzone.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.douzone.bookmall.vo.BookVo;
import com.douzone.bookmall.vo.CartVo;

public class CartDao {
	public Boolean insert(CartVo vo) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		try {
			conn = getConnection(); // url, 아이디, 비번

			String sql = "insert into cart values(null, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);

//			pstmt.setLong(1, vo.getNo());
			pstmt.setLong(1, vo.getQuantity());
			pstmt.setLong(2, vo.getUser_no());
			pstmt.setLong(3, vo.getBook_no());

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
	
	public List<CartVo> findAll() {
		List<CartVo> result = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();

			String sql = "select b.name, a.quantity, b.price from cart a, book b where a.book_no = b.no";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String name = rs.getString(1);
				Long quantity = rs.getLong(2);
				Long price = rs.getLong(3);

				CartVo vo = new CartVo();
				vo.setName(name);
				vo.setQuantity(quantity);
				vo.setPrice(price);
				
//				Long no = rs.getLong(1);
//				String name = rs.getString(2);
//				Long quantity = rs.getLong(3);
//				Long user_no = rs.getLong(4);
//				Long book_no = rs.getLong(5);
//
//				CartVo vo = new CartVo();
//				vo.setNo(no);
//				vo.setName(name);
//				vo.setQuantity(quantity);
//				vo.setUser_no(user_no);
//				vo.setBook_no(book_no);
				
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
