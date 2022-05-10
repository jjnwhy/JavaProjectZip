package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import test.dto.MemberDto;
import test.util.DBConnect;

public class MainClass12 {
	public static void main(String[] args) {
		// �޼ҵ尡 �������ִ� ��ü ȸ���� ����� main�޼ҵ� �ȿ��� ����ϰ� �ʹٸ�?
		List<MemberDto> list = getList(); // �޼ҵ带 ȣ���ؼ� ��ü ȸ������� �޾ƿ´�.
		for (MemberDto tmp : list) {
			System.out.println(tmp.getNum() + " | " + tmp.getName() + " | " + tmp.getAddr());
		}

	}

	// ��ü ȸ���� ����� �������ִ� �޼ҵ�
	public static List<MemberDto> getList(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<MemberDto> info = new ArrayList<>();
		
		try {
			conn = new DBConnect().getConn();
			
			String sql = "SELECT num,name,addr FROM member" 
					+ " ORDER BY num DESC";
			
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
				if(rs != null)rs.close();
				if(pstmt != null)pstmt.close();
				if(conn != null)conn.close();
			} catch (Exception e) {

			}
		}
		
		return info;
	}
}
