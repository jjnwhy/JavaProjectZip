package test.main;

import java.util.Scanner;

public class MainClass05 {
	public static void main(String[] args) {
		System.out.println("main�޼ҵ尡 ���۵˴ϴ�.");
		System.out.print("�Է�: ");
		// Ű����κ��� �Է¹��� �� �ִ� ��ü ����
		Scanner scan = new Scanner(System.in);
		// ���� �Է¹ް�
		String str = scan.nextLine();
		// �Է� ���� ���ڿ��� �ֿܼ� ����ϰ�
		System.out.println(str);
		// ����
		System.out.println("main�޼ҵ尡 ����˴ϴ�.");
	}
}
