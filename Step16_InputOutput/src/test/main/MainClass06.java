package test.main;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;

public class MainClass06 {
	public static void main(String[] args) {
		PrintStream ps = System.out;
		// �н��� ���ؼ� PrintStream��ü�� �θ�type OutputStream���� �޾ƺ���
		// OutputStream�� 1bype ó����Ʈ��
		OutputStream os = ps;

		OutputStreamWriter osw = new OutputStreamWriter(os);
		BufferedWriter bw = new BufferedWriter(osw);
		try {
			bw.write("�ϳ�");
			bw.newLine(); //�����ȣ�� ���
			bw.write("�ο�");
			bw.write("\r\n");
			bw.write("����");
			bw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
