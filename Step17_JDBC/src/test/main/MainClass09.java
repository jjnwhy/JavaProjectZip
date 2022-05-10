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
		// �߰��� ȸ���� ����
		String name = "���";
		String addr = "�󵵵�";
		
		// MemberDto ��ü�� �����ؼ� setter �޼ҵ带 �̿��ؼ� ȸ�������� ���
		MemberDto mem=new MemberDto();
		mem.setName(name);
		mem.setAddr(addr);
		// �޼ҵ� ȣ���ϸ鼭 MemberDto ��ü�� ������ �����ϱ�
		insert(mem);
	}

	// ȸ�� �Ѹ��� ������ �߰��ϴ� �޼ҵ�
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

			System.out.println("ȸ�������� �����߽��ϴ�.");

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
