package test.main;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class MainClass04 {
	public static void main(String[] args) {
		PrintStream ps = System.out;
		// 학습을 위해서 PrintStream객체를 부모type OutputStream으로 받아보기
		// OutputStream도 1bype 처리스트림
		OutputStream os = ps;

		try {
			os.write(97);
			os.write(98);
			os.write(99);
			os.flush(); // 방출 == 출력이 되게 함
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
