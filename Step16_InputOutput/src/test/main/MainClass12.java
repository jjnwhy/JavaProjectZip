package test.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 	c:/acorn202203/myFolder/memo.txt ���Ͽ� ��ϵ� ���ڿ��� �о �ܼ�â�� ����غ�����.
 *  - hint
 *  FileReader ��ü�� �� Ȱ���غ�����.
 */

public class MainClass12 {
	public static void main(String[] args) {
		
		File memoFile = new File("C:/acorn202203/myFolder/memo.txt");

		try {
			// ���Ͽ��� ���ڿ��� �о���� �� �ִ� ��ü ����
			FileReader fr = new FileReader(memoFile);
			// �ݺ��� ���鼭
			while (true) {
				// ���� code �ϳ��� �о��.
				int code = fr.read();
				// ���� ���̻� ���� codr���� ������
				if (code == -1) {
					break; //�ݺ��� Ż��
				}
				// �ڵ尪�� ���ڷ� ��ȯ�ؼ� 
				char ch = (char) code;
				// �����ȣ ���� ����ϱ�
				System.out.print(ch);			
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
