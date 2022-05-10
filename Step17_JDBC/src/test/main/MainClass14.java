package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import test.dto.MemberDto;
import test.util.DBConnect;

/*
 *  - hint
 *  SELECT num, name, addr
 *  FROM member
 *  WHERE num=?
 *  
 *  .setInt(1, num);
 */
public class MainClass14 {
	public static void main(String[] args) {
		// �޼ҵ带 ȣ���ؼ� ���ڷ� ������ ��ȣ�� �ش��ϴ� ȸ�� ������ ���ͼ�
		MemberDto dto = getData(6);
		if(dto != null) {
			// ����ϱ�
			System.out.println("��ȣ: "+dto.getNum()+", �̸�: "+dto.getName()+", �ּ�: "+dto.getAddr());			
		} else { // ���ϰ��� null�� ���
			System.out.println("�ش� ȸ���� �������� �ʽ��ϴ�.");
		}
	}
	
	// ���ڷ� ���޵� ��ȣ�� �ش��ϴ� ȸ�� �Ѹ��� ������ �����ϴ� �޼ҵ�
	public static MemberDto getData(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		// MemberDto ��ü�� ���� ���������� �̸� �����.
		// num=99ó�� select�� ���� ���� ��쿣 try������ ���� �ʰ� null�� ������ �� �ְ� �Ѵ�.
		MemberDto member = null;
		
		try {
			conn = new DBConnect().getConn();
			
			// SELECT���� �̿ϼ��� sql���� ���� ���ε��� �� �ִ�.
			String sql = "SELECT name,addr FROM member"
					+ " WHERE num=?";
			
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
				if(rs != null)rs.close();
				if(pstmt != null)pstmt.close();
				if(conn != null)conn.close();
			} catch (Exception e) {

			}
		}
		
		return member;
	}
}
