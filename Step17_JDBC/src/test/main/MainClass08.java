package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Map;

import test.mypac.Member;
import test.util.DBConnect;

public class MainClass08 {
	public static void main(String[] args) {
		// �߰��� ȸ���� ����
		String name = "�ֵ���";
		String addr = "��õ��";
		
		// HashMap ��ü�� �����ؼ� �߰��� ȸ�������� ��´�.
		Map<String, String> mem=new HashMap<>();
		mem.put("name", name);
		mem.put("addr", addr);
		insert(mem);
	}

	// ȸ�� �Ѹ��� ������ �߰��ϴ� �޼ҵ�
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
