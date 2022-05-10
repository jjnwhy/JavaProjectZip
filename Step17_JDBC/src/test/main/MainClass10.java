package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;

import test.dto.MemberDto;
import test.util.DBConnect;

public class MainClass10 {
	public static void main(String[] args) {
		// 수정할 회원정보
		int num = 1;
		String name = "호빵";
		String addr = "분식집";

		// MemberDto 객체에 수정할 회원의 정보를 담고
		MemberDto dto = new MemberDto();
		dto.setNum(num);
		dto.setName(name);
		dto.setAddr(addr);
		// 메소드를 호출하면서 전달하기
		update(dto);
	}

	// 회원 1명의 정보를 수정하는 메소드
	public static void update(MemberDto dto) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = new DBConnect().getConn();
			String sql = "UPDATE member" 
					+ " SET name=?, addr=?" 
					+ " WHERE num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getAddr());
			pstmt.setInt(3, dto.getNum());

			pstmt.executeUpdate();

			System.out.println("회원정보를 수정했습니다.");
			
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
