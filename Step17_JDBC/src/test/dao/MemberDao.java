package test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import test.dto.MemberDto;
import test.util.DBConnect;

public class MemberDao {
	
	// ȸ�� ������ �����ϴ� �޼ҵ�
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

			// System.out.println("ȸ�������� �����߽��ϴ�.");

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

	// ȸ�� ������ �����ϴ� �޼ҵ�
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

	// ȸ�� �Ѹ��� ������ �����ϴ� �޼ҵ�
	public boolean delete(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		int updatedRowCount = 0;

		try {
			conn = new DBConnect().getConn();
			String sql = "DELETE FROM member" + " WHERE num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);

			// sql�� �����ϰ� ������(�߰�, ����, ����) row�� ���� ���� �ޱ�
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
			// ������ ���
			return true;
		} else {
			// ������ ���
			return false;
		}

	}

	// ȸ�� �Ѹ��� ������ �����ϴ� �޼ҵ�
	public MemberDto getData(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// MemberDto ��ü�� ���� ���������� �̸� �����.
		// num=99ó�� select�� ���� ���� ��쿣 try������ ���� �ʰ� null�� ������ �� �ְ� �Ѵ�.
		MemberDto member = null;

		try {
			conn = new DBConnect().getConn();

			// SELECT���� �̿ϼ��� sql���� ���� ���ε��� �� �ִ�.
			String sql = "SELECT name,addr FROM member" + " WHERE num=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);

			rs = pstmt.executeQuery(); // executeQuery()-ResultSet ¦��

			// ���� select�� row�� �ִٸ� MemberDto ��ü�� ������ �����ϱ�!
			// select���� ������ primary key�� �������� �ؼ� ����� ���� only �Ѱ��̴�. �׷��Ƿ� ���� while�� �Ƚᵵ�ȴ�.
			if (rs.next()) {
				// select�� ���� ������ ��ü ����
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

	// ȸ�� ����� �����ϴ� �޼ҵ�
	public List<MemberDto> getList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<MemberDto> info = new ArrayList<>();

		try {
			conn = new DBConnect().getConn();

			String sql = "SELECT num,name,addr FROM member" + " ORDER BY num ASC";

			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery(); // ResultSet�̶� ¦��

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
