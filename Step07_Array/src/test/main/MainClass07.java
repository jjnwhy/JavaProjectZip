package test.main;

import java.util.Random;

/*
 * 	1. cherry, apple, banana, melon, 7
 * 		5���� ���ڿ� �߿��� 1���� �����ϰ� ��µǰ� �غ�����.
 * 
 * 	2. 5���� ���ڿ� �߿��� 3���� ���ٿ� �ѹ��� �����ϰ� ��µǰ� �غ�����.
 * 		��) cherry | apple | cherry
 * 			7	|	apple	| melon
 * 			7	|	7	|	7
 * 
 * 	- hint
 * 	
 * 	String[] items={"cherry","apple","banana","melon","7"};
 * 	Random ran=new Random();
 * 	int ranNum=ran.nextInt();
 * 
 */
public class MainClass07 {
	public static void main(String[] args) {
		String[] items = { "cherry", "apple", "banana", "melon", "7" };
		Random ran = new Random();

		int ranNum = ran.nextInt(items.length);
		String tmp = items[ranNum];
		System.out.println(tmp); // #1

		// 0~4 ������ ���� �߿��� ������ ���� 3�� ����
		int ranNum1 = ran.nextInt(5);
		int ranNum2 = ran.nextInt(5);
		int ranNum3 = ran.nextInt(5);
		String line = items[ranNum1] + " | " + items[ranNum2] + " | " + items[ranNum3];
		System.out.println(line); // #2

	}
}
