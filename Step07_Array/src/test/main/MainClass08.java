package test.main;

import java.util.Random;

public class MainClass08 {
	public static void main(String[] args) {
		String[] items = { "cherry", "apple", "banana", "melon", "7" };
		// �ο��� ������ �̸� �迭�� �غ�
		int[] points = { 10, 20, 30, 40, 1000 };
		Random ran = new Random();

		int ranNum1 = ran.nextInt(5);
		int ranNum2 = ran.nextInt(5);
		int ranNum3 = ran.nextInt(5);

		String line = items[ranNum1] + " | " + items[ranNum2] + " | " + items[ranNum3];
		
		int jumsu=0;
		// ������ �������� ��� ���ٸ�
		if(ranNum1==ranNum2 && ranNum2==ranNum3) {
			// ������ �����Ѵ�.
			jumsu=points[ran.nextInt(5)];
			
		}
		
		System.out.println(line); // #2
		System.out.println(jumsu);
	}
}
