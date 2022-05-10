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

public class MainClass14 {
	public static void main(String[] args) {

		File memoFile = new File("C:/acorn202203/myFolder/memo.txt");
		// �ʿ��� ��ü�� �������� ���� ���� ������ �̸� �����.
		FileReader fr = null;
		BufferedReader br = null;

		try {
			// ���Ͽ��� ���ڿ��� �о���� ��ü�� �������� ���� �̸� ������ ���� ������ ��´�.
			fr = new FileReader(memoFile);
			br = new BufferedReader(fr);

			// �ݺ��� ���鼭
			while (true) {
				// ���پ� �о��
				String line = br.readLine();
				// ���� ���̻� ���� ���ڿ��� ���ٸ�
				if (line == null) {
					break;
				}
				// �о ���ڿ� �ֿܼ� ����ϱ�
				System.out.println(line);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally { // ���ܰ� �߻��ϵ� ���ϵ� ������ �ݵ�� ����Ǵ� ��
			// ������ �۾��� �Ѵ�.
			try {
				if (br != null)
					br.close();
				if (fr != null)
					fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
