package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import test.util.DBConnect;

public class MainClass15 {
	public static void main(String[] args) {
		// 삭제할 회원의 번호를 입력받는다.
		Scanner scan = new Scanner(System.in);
		System.out.print("삭제할 회원 번호 입력: ");
		int num = scan.nextInt();

		boolean isSuccess = delete(num);

		if (isSuccess) {
			System.out.println(num+"번 회원정보를 삭제했습니다.");
		} else {
			System.out.println(num+"번 회원정보가 없습니다.");
		}

	}

	/*
	 * 인자로 전달된 번호에 해당하는 회원 정보를 삭제하고 작업의 성공 여부를 리턴하는 메소드 작업의 성공여부를 리턴하는 메소드로 만들어 보세요!
	 */
	public static boolean delete(int num) {
		// 삭제는 primary key인 num만 있으면 삭제되므로 dto 필요없다.
		Connection conn = null;
		PreparedStatement pstmt = null;

		int updatedRowCount = 0;

		try {
			conn = new DBConnect().getConn();
			String sql = "DELETE FROM member" 
					+ " WHERE num=?";
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

}
