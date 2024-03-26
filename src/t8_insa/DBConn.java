package t8_insa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
// DAO가 여러개일 경우를 위해 DB Connection을 따로 빼고 DAO에서 상속받아 사용한다
public class DBConn {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String sql = "";
	
	public DBConn() {
		String url = "jdbc:mysql://localhost:3306/javaclass";
		String user = "atom";
		String password = "1234";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 검색 실패"+e.getMessage());
		} catch (SQLException e) {
			System.out.println("데이터베이스 연동 실패"+e.getMessage());
		}
	}
	
	// conn Close()
	public void connClose() {
		try {
			conn.close();
		} catch (SQLException e) {}
	}
	
	//pstmtClose()
	public void pstmtClose() {
			try {
				if(pstmt != null)	pstmt.close();
			} catch (SQLException e) {}
	}
	
	// rsClose(){
	public void rsClose() {
		try {
			if(rs != null) rs.close();
				pstmt.close();
		} catch (SQLException e) {}
	}
	
}
