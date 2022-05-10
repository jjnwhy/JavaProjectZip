package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;

import test.mypac.Member;
import test.util.DBConnect;

public class MainClass07 {
	public static void main(String[] args) {
		// 추가할 회원의 정보
		String name = "주뎅이";
		String addr = "봉천동";
		// 회원 한명의 정보를 Member 객체에 담는다.
		Member m1 = new Member();
		m1.name = name;
		m1.addr = addr;
		// 메소드 호출하면서 회원 정보가 들어있는 Member 객체를 전달한다.
		insert(m1);
	}

	// 회원 한명의 정보를 추가하는 메소드
	public static void insert(Member mem) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = new DBConnect().getConn();

			String sql = "INSERT INTO member"
					+ " (num,name,addr)" 
					+ " VALUES (member_seq.NEXTVAL,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mem.name);
			pstmt.setString(2, mem.addr);

			pstmt.executeUpdate();

			System.out.println("회원정보를 저장했습니다.");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)pstmt.close();
				if (conn != null)conn.close();
			} catch (Exception e) {

			}

		}

	}
}
