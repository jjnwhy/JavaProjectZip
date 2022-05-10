package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Map;

import test.dto.MemberDto;
import test.mypac.Member;
import test.util.DBConnect;

public class MainClass09 {
	public static void main(String[] args) {
		// 추가할 회원의 정보
		String name = "덩어리";
		String addr = "상도동";
		
		// MemberDto 객체를 생성해서 setter 메소드를 이용해서 회원정보를 담고
		MemberDto mem=new MemberDto();
		mem.setName(name);
		mem.setAddr(addr);
		// 메소드 호출하면서 MemberDto 객체의 참조값 전달하기
		insert(mem);
	}

	// 회원 한명의 정보를 추가하는 메소드
	public static void insert(MemberDto dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = new DBConnect().getConn();

			String sql = "INSERT INTO member"
					+ " (num,name,addr)" 
					+ " VALUES (member_seq.NEXTVAL,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getAddr());

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
