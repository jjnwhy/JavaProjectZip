package test.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sound.midi.Sequence;

import test.util.DBConnect;

public class MainClass06 {
	public static void main(String[] args) {
		// ������ member_seq�� Ȱ���ؼ� ȸ�� ������ �߰��غ�����.
		String name="�۹���";
		String addr="�б�����";
		
		// SELECT �۾��� ���ؼ� �ʿ��� ��ü�� �������� ���� �������� �̸� �����
		Connection conn=null;
		PreparedStatement pstmt = null;

		try {
			// DBConnect ��ü�� �̿��ؼ� Connection��ü�� �������� ���´�.
			conn = new DBConnect().getConn();
			// ������ sql��
			String sql = "INSERT INTO member"
					+ " (num,name,addr)"
					+ " VALUES(member_seq.NEXTVAL,?,?)";
			// PreparedStatement ��ü�� ������ ������
			pstmt = conn.prepareStatement(sql);
			
			
			pstmt.setString(1, name);
			pstmt.setString(2, addr);
			
			
			// sql�� �����ϱ�
			pstmt.executeUpdate();
			System.out.println("ȸ�������� �����߽��ϴ�.");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// �������� ���� �������� �ݾ��ָ� �ȴ�. 
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (Exception e) {
			}
		}
		
		System.out.println("main�޼ҵ尡 ����˴ϴ�.");
	}
}
