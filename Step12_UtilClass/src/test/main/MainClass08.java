package test.main;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainClass08 {
	public static void main(String[] args) {
		// sample������
		Map<String, String> dic = new HashMap<>();
		dic.put("house", "��");
		dic.put("phone", "��ȭ��");
		dic.put("car", "�ڵ���");
		dic.put("pencil", "����");
		dic.put("eraser", "���찳");

		/*
		 * �˻��� �ܾ �Է��ϼ���: house 
		 * house�� ���� ���Դϴ�.
		 * 
		 * �˻��� �ܾ �Է��ϼ���: gura 
		 * gura�� ��Ͽ� �����ϴ�.
		 */

		System.out.print("�˻��� �ܾ �Է��ϼ���: ");
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		
		// Map��ü�� �ش� Ű������ ����� ���� �ִ��� �о�ͺ���.
		String mean = dic.get(str);
		
		if(mean == null) { // ã�� �ܾ ���� ���
			System.out.println(str + "�� ��Ͽ� �����ϴ�.");
		}else {
			System.out.println(str + "�� ���� " + mean + "�Դϴ�.");
		}
		
		//�޼ҵ� Ȱ���ؼ� ����ϱ�
//		if (dic.containsKey(str)) {
//			System.out.println(str + "�� ���� " + mean + "�Դϴ�.");
//		} else {
//			System.out.println(str + "�� ��Ͽ� �����ϴ�.");
//		}

	}
}
