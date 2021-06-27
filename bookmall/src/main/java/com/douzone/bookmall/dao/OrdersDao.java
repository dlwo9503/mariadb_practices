package com.douzone.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.douzone.bookmall.vo.BookVo;
import com.douzone.bookmall.vo.OrdersVo;

public class OrdersDao {
	public Boolean insert(OrdersVo vo) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		try {
			conn = getConnection(); // url, 아이디, 비번

			String sql = "insert into orders values(null, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);

//			pstmt.setLong(1, vo.getNo());
			pstmt.setString(1, vo.getOrder_no());
			pstmt.setLong(2, vo.getPayment_amount());
			pstmt.setString(3, vo.getAddress());
			pstmt.setLong(4, vo.getUser_no());

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
	
	public List<OrdersVo> findAll() {
		List<OrdersVo> result = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();

			String sql = "select a.no, a.order_no, b.name, b.email, a.price, a.address from orders a, user b where a.user_no = b.no";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Long no = rs.getLong(1);
				String order_no = rs.getString(2);
				String name = rs.getString(3);
				String email = rs.getString(4);
				Long payment_amount = rs.getLong(5);
				String address = rs.getString(6);

				OrdersVo vo = new OrdersVo();
				vo.setNo(no);
				vo.setOrder_no(order_no);
				vo.setUser_name(name);
				vo.setUser_email(email);
				vo.setPayment_amount(payment_amount);
				vo.setAddress(address);
				
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

			String url = "jdbc:mysql://192.168.0.96:3307/bookmall";
			conn = DriverManager.getConnection(url, "bookmall", "bookmall"); // url, 아이디, 비번

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패 : " + e);
		}
		return conn;
	}
}
