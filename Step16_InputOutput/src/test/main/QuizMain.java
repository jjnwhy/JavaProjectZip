package test.main;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class QuizMain {
	public static void main(String[] args) {
		/*
		 * Scanner ��ü�� �̿��ؼ� ���ڿ� ������ �Է¹��� ���� c:/acorn202203/myFolder/quiz.txt ������ ���� �ش�
		 * ���Ͽ� ���ڿ��� �����غ�����.
		 */
		Scanner scan = new Scanner(System.in);
		System.out.print("���ڿ� �Է�: ");
		String str = scan.nextLine();

		FileWriter fw = null;
		try { 
			// new FileWriter(�ؽ�Ʈ ������ ��ġ, append ��� ����(�����))
			fw = new FileWriter("c:/acorn202203/myFolder/quiz.txt",true);
			fw.write(str);
			fw.write("\r\n");
			fw.flush();
			System.out.println("���Ͽ� �����߽��ϴ�.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
