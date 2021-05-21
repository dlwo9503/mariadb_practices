package com.douzone.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.douzone.bookmall.vo.Order_bookVo;

public class Order_bookDao {
	public Boolean insert(Order_bookVo vo) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		try {
			conn = getConnection(); // url, 아이디, 비번

			String sql = "insert into order_book values(null, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);

//			pstmt.setLong(1, vo.getNo());
			pstmt.setLong(1, vo.getQuantity());
			pstmt.setLong(2, vo.getPrice());
			pstmt.setLong(3, vo.getBook_no());
			pstmt.setLong(4, vo.getOrder_no());

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
	
	public List<Order_bookVo> findAll() {
		List<Order_bookVo> result = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();

			String sql = "select * from order_book";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Long no = rs.getLong(1);
				Long quantity = rs.getLong(2);
				Long price = rs.getLong(3);
				Long book_no = rs.getLong(4);
				Long order_no = rs.getLong(5);

				Order_bookVo vo = new Order_bookVo();
				vo.setNo(no);
				vo.setQuantity(quantity);
				vo.setPrice(price);
				vo.setBook_no(book_no);
				vo.setOrder_no(order_no);
				
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
