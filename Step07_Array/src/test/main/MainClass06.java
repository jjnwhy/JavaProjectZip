package test.main;

import java.util.Scanner;

public class MainClass06 {
	public static void main(String[] args) {
		/*
		 * Scanner ��ü�� �̿��ؼ� ���ڿ��� 5�� �Է¹޴´�. �Է� ���� ���ڿ��� ���ʴ�� �迭�� ����Ǿ�� �Ѵ�. ��� �� �Է¹�����
		 * for���� �̿��ؼ� �迭�� ����� ��� ���ڿ��� �ܼ�â�� ������� ����ϴ� �ڵ带 �ۼ��غ�����.
		 */
		Scanner scan = new Scanner(System.in);
		String[] str = new String[5];

		for (int i = 0; i < str.length; i++) {
			System.out.print("���ڿ� �Է�: ");
			String msg = scan.nextLine();
			str[i] = msg;

		}
		for (int i = 0; i < str.length; i++) {
			String tmp=str[i];
			System.out.print(tmp + " ");
		}

	}
}
