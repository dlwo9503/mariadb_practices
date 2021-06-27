package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectTest02 {

	public static void main(Long emp_no, String birth_date, String last_name, String first_name) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// 1. JDBC Driver 로딩
			Class.forName("org.mariadb.jdbc.Driver");

			// 2. 연결하기
			String url = "jdbc:mysql://192.168.0.96:3307/employees";
			conn = DriverManager.getConnection(url, "hr", "hr"); // url, 아이디, 비번

			// 3. SQL문 준비
			String sql = "select ?, ?, ? from employees where ? like \\\"pat%\\\"";
			pstmt = conn.prepareStatement(sql);
			
			// 4. 바인딩(Binding)
			pstmt.setLong(1, emp_no);
			pstmt.setString(2, birth_date);
			pstmt.setString(3, last_name);
			pstmt.setString(4, first_name);
			
			// 5. SQL문을 실행
			rs = pstmt.executeQuery();
			
			// 6. 결과 가져오기
			while(rs.next()) {
				Long empNo = rs.getLong(1);
				String birthDate = rs.getString(2);
				String lastName = rs.getString(3);
				
				System.out.println(empNo + ":" + birthDate + ":" + lastName);
			}
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패 : " + e);
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
	}
}