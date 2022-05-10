package test.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sound.midi.Sequence;

import test.util.DBConnect;

public class MainClass06 {
	public static void main(String[] args) {
		// 시퀀스 member_seq을 활용해서 회원 정보를 추가해보세요.
		String name="멍뭉이";
		String addr="압구정동";
		
		// SELECT 작업을 위해서 필요한 객체의 참조값을 담을 지역변수 미리 만들기
		Connection conn=null;
		PreparedStatement pstmt = null;

		try {
			// DBConnect 객체를 이용해서 Connection객체의 참조값을 얻어온다.
			conn = new DBConnect().getConn();
			// 실행할 sql문
			String sql = "INSERT INTO member"
					+ " (num,name,addr)"
					+ " VALUES(member_seq.NEXTVAL,?,?)";
			// PreparedStatement 객체의 참조값 얻어오기
			pstmt = conn.prepareStatement(sql);
			
			
			pstmt.setString(1, name);
			pstmt.setString(2, addr);
			
			
			// sql문 실행하기
			pstmt.executeUpdate();
			System.out.println("회원정보를 저장했습니다.");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 참조값을 얻어온 역순으로 닫아주면 된다. 
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (Exception e) {
			}
		}
		
		System.out.println("main메소드가 종료됩니다.");
	}
}
