package test.main;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;

public class MainClass06 {
	public static void main(String[] args) {
		PrintStream ps = System.out;
		// 학습을 위해서 PrintStream객체를 부모type OutputStream으로 받아보기
		// OutputStream도 1bype 처리스트림
		OutputStream os = ps;

		OutputStreamWriter osw = new OutputStreamWriter(os);
		BufferedWriter bw = new BufferedWriter(osw);
		try {
			bw.write("하나");
			bw.newLine(); //개행기호를 출력
			bw.write("두울");
			bw.write("\r\n");
			bw.write("세엣");
			bw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
