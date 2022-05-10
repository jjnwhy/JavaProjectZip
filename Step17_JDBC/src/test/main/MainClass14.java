package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import test.dto.MemberDto;
import test.util.DBConnect;

/*
 *  - hint
 *  SELECT num, name, addr
 *  FROM member
 *  WHERE num=?
 *  
 *  .setInt(1, num);
 */
public class MainClass14 {
	public static void main(String[] args) {
		// 메소드를 호출해서 인자로 전달한 번호에 해당하는 회원 정보를 얻어와서
		MemberDto dto = getData(6);
		if(dto != null) {
			// 사용하기
			System.out.println("번호: "+dto.getNum()+", 이름: "+dto.getName()+", 주소: "+dto.getAddr());			
		} else { // 리턴값이 null인 경우
			System.out.println("해당 회원은 존재하지 않습니다.");
		}
	}
	
	// 인자로 전달된 번호에 해당하는 회원 한명의 정보를 리턴하는 메소드
	public static MemberDto getData(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		// MemberDto 객체를 담을 지역변수를 미리 만든다.
		// num=99처럼 select된 값이 없는 경우엔 try문으로 들어가지 않고 null을 리턴할 수 있게 한다.
		MemberDto member = null;
		
		try {
			conn = new DBConnect().getConn();
			
			// SELECT문도 미완성된 sql문에 값을 바인딩할 수 있다.
			String sql = "SELECT name,addr FROM member"
					+ " WHERE num=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);			
			
			rs = pstmt.executeQuery(); // executeQuery()-ResultSet 짝꿍
			
			// 만일 select된 row가 있다면 MemberDto 객체에 정보를 추출하기! 
			// select문의 조건이 primary key를 기준으로 해서 추출될 값이 only 한개이다. 그러므로 굳이 while문 안써도된다.
			if (rs.next()) {
				// select된 값이 있을때 객체 생성
				member = new MemberDto();
				
				member.setNum(num);
				member.setName(rs.getString("name"));
				member.setAddr(rs.getString("addr"));
				
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
		
		return member;
	}
}
