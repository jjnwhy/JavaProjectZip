package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import test.util.DBConnect;

public class MainClass15 {
	public static void main(String[] args) {
		// ������ ȸ���� ��ȣ�� �Է¹޴´�.
		Scanner scan = new Scanner(System.in);
		System.out.print("������ ȸ�� ��ȣ �Է�: ");
		int num = scan.nextInt();

		boolean isSuccess = delete(num);

		if (isSuccess) {
			System.out.println(num+"�� ȸ�������� �����߽��ϴ�.");
		} else {
			System.out.println(num+"�� ȸ�������� �����ϴ�.");
		}

	}

	/*
	 * ���ڷ� ���޵� ��ȣ�� �ش��ϴ� ȸ�� ������ �����ϰ� �۾��� ���� ���θ� �����ϴ� �޼ҵ� �۾��� �������θ� �����ϴ� �޼ҵ�� ����� ������!
	 */
	public static boolean delete(int num) {
		// ������ primary key�� num�� ������ �����ǹǷ� dto �ʿ����.
		Connection conn = null;
		PreparedStatement pstmt = null;

		int updatedRowCount = 0;

		try {
			conn = new DBConnect().getConn();
			String sql = "DELETE FROM member" 
					+ " WHERE num=?";
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

}
