package test.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	// 필드
	Connection conn;
	
	// 생성자
	public DBConnect() {
		// Connection 객체의 참조값을 얻어내서 필드에 저장하기
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "scott", "tiger");
			System.out.println("Oracle DB에 접속 성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Connection 객체를 리턴해주는 메소드
	public Connection getConn() {
		// 필드에 저장된 Connection 객체의 참조값을 리턴해주기
		return conn;
	}
}
