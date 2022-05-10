package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.DefaultListSelectionModel;

import test.util.DBConnect;

public class MainClass11 {
	public static void main(String[] args) {
		// 삭제할 회원의 번호라고 하자.
		int num = 4;

		delete(num);
	}

	public static void delete(int num) {
		// 삭제는 primary key인 num만 있으면 삭제되므로 dto 필요없다.
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = new DBConnect().getConn();
			String sql = "DELETE FROM member" 
					+ " WHERE num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			pstmt.executeUpdate();

			System.out.println("회원정보를 삭제했습니다.");
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
