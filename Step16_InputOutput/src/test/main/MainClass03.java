package test.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainClass03 {
	public static void main(String[] args) {
		// 1byte ó�� ��Ʈ�� = 8bit
		InputStream is = System.in;

		// 2byte ó�� ��Ʈ��
		//InputStreamReader isr = new InputStreamReader(is);

		// ���ڿ� 1�پ� �Է¹��� �� �ִ� ��ü
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("���ڿ� �Է�: ");
		try {
			String line = br.readLine();
			System.out.println("line: " + line);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
