package test.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainClass07 {
	public static void main(String[] args) {
		/*
		 * HashMap<key���� type, value���� type>
		 * key�� Generic class�� String���� �����ϴ� ���� �Ϲ����̴�.
		 * value�� Generic class�� ���� ������ type�� �����ϸ� �ȴ�.
		 * ���� ���� type�� ��� �����Ÿ� Object�� �����ϸ� �ȴ�.
		 * 
		 */
		final Map<String, Object> map1 = new HashMap<>();
		
		
		/*
		 *  ������ ������ HashMap ��ü�� ������ ���� ���� 3������ ��ƺ�����.
		 *  ��ȣ : 1
		 *  �̸� : �豸��
		 *  �������� ���� : true
		 */
		map1.put("num", 1);
		map1.put("name", "�豸��");
		map1.put("isMan", true);
		
		// map1�� ��� ��ȣ�� num, �̸��� name, �������� ���δ� isMan �̶�� ���������� ��ƺ�����.
		int num = (int) map1.get("num");
		String name = (String) map1.get("name");
		boolean isMan = (boolean) map1.get("isMan");
		
		// ������ key������ �ٽ� ������ ����
		map1.put("name", "������");
		
		// Ư�� key������ ��� ���� ����, �����ϸ� true, �����ϸ� false return;
		map1.remove("isMan");
		
		// ��� ����
		map1.clear();
		
	}
}
