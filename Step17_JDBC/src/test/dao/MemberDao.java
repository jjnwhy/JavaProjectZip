package test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import test.dto.MemberDto;
import test.util.DBConnect;

public class MemberDao {
	
	// 회원 정보를 저장하는 메소드
	public boolean insert(MemberDto dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		int updatedRowCount = 0;

		try {
			conn = new DBConnect().getConn();

			String sql = "INSERT INTO member" + " (num,name,addr)" + " VALUES (member_seq.NEXTVAL,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getAddr());

			updatedRowCount = pstmt.executeUpdate();

			// System.out.println("회원정보를 저장했습니다.");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {

			}

		}
		if (updatedRowCount > 0) {
			return true;
		} else {
			return false;
		}
	}

	// 회원 정보를 수정하는 메소드
	public boolean update(MemberDto dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		int updatedRowCount = 0;

		try {
			conn = new DBConnect().getConn();

			String sql = "UPDATE member" + " SET name=?, addr=?" + " WHERE num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getAddr());
			pstmt.setInt(3, dto.getNum());

			updatedRowCount = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {

			}

		}
		if (updatedRowCount > 0) {
			return true;
		} else {
			return false;
		}

	}

	// 회원 한명의 정보를 삭제하는 메소드
	public boolean delete(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		int updatedRowCount = 0;

		try {
			conn = new DBConnect().getConn();
			String sql = "DELETE FROM member" + " WHERE num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);

			// sql문 실행하고 수정된(추가, 수정, 삭제) row의 갯수 리턴 받기
			updatedRowCount = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {

			}
		}

		if (updatedRowCount > 0) {
			// 성공인 경우
			return true;
		} else {
			// 실패인 경우
			return false;
		}

	}

	// 회원 한명의 정보를 리턴하는 메소드
	public MemberDto getData(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// MemberDto 객체를 담을 지역변수를 미리 만든다.
		// num=99처럼 select된 값이 없는 경우엔 try문으로 들어가지 않고 null을 리턴할 수 있게 한다.
		MemberDto member = null;

		try {
			conn = new DBConnect().getConn();

			// SELECT문도 미완성된 sql문에 값을 바인딩할 수 있다.
			String sql = "SELECT name,addr FROM member" + " WHERE num=?";

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
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {

			}
		}

		return member;
	}

	// 회원 목록을 리턴하는 메소드
	public List<MemberDto> getList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<MemberDto> info = new ArrayList<>();

		try {
			conn = new DBConnect().getConn();

			String sql = "SELECT num,name,addr FROM member" + " ORDER BY num ASC";

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
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {

			}
		}

		return info;
	}
}
