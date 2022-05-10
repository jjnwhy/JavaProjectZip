package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import test.dto.MemberDto;
import test.util.DBConnect;

public class MainClass12 {
	public static void main(String[] args) {
		// 메소드가 리턴해주는 전체 회원의 목록을 main메소드 안에서 사용하고 싶다면?
		List<MemberDto> list = getList(); // 메소드를 호출해서 전체 회원목록을 받아온다.
		for (MemberDto tmp : list) {
			System.out.println(tmp.getNum() + " | " + tmp.getName() + " | " + tmp.getAddr());
		}

	}

	// 전체 회원의 목록을 리턴해주는 메소드
	public static List<MemberDto> getList(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<MemberDto> info = new ArrayList<>();
		
		try {
			conn = new DBConnect().getConn();
			
			String sql = "SELECT num,name,addr FROM member" 
					+ " ORDER BY num DESC";
			
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery(); // ResultSet이랑 짝꿍
			
			while (rs.next()) {
				MemberDto dto = new MemberDto();
				int num = rs.getInt("num");
				String name = rs.getString("name");
				String addr = rs.getString("addr");
				
				dto.setNum(num);
				dto.setName(name);
				dto.setAddr(addr);
				
				info.add(dto);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null)rs.close();
				if(pstmt != null)pstmt.close();
				if(conn != null)conn.close();
			} catch (Exception e) {

			}
		}
		
		return info;
	}
}
