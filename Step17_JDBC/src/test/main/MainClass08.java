package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Map;

import test.mypac.Member;
import test.util.DBConnect;

public class MainClass08 {
	public static void main(String[] args) {
		// 추가할 회원의 정보
		String name = "주뎅이";
		String addr = "봉천동";
		
		// HashMap 객체를 생성해서 추가할 회원정보를 담는다.
		Map<String, String> mem=new HashMap<>();
		mem.put("name", name);
		mem.put("addr", addr);
		insert(mem);
	}

	// 회원 한명의 정보를 추가하는 메소드
	public static void insert(Map<String, String> map) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = new DBConnect().getConn();

			String sql = "INSERT INTO member"
					+ " (num,name,addr)" 
					+ " VALUES (member_seq.NEXTVAL,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, map.get("name"));
			pstmt.setString(2, map.get("addr"));

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
