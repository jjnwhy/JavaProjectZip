package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.DefaultListSelectionModel;

import test.util.DBConnect;

public class MainClass11 {
	public static void main(String[] args) {
		// ������ ȸ���� ��ȣ��� ����.
		int num = 4;

		delete(num);
	}

	public static void delete(int num) {
		// ������ primary key�� num�� ������ �����ǹǷ� dto �ʿ����.
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = new DBConnect().getConn();
			String sql = "DELETE FROM member" 
					+ " WHERE num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			pstmt.executeUpdate();

			System.out.println("ȸ�������� �����߽��ϴ�.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null)pstmt.close();
				if(conn != null)conn.close();
			} catch (Exception e) {

			}
		}
		
		
	}
}
