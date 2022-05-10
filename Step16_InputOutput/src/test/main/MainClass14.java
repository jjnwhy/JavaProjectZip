package test.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 	c:/acorn202203/myFolder/memo.txt 파일에 기록된 문자열을 읽어서 콘솔창에 출력해보세요.
 *  - hint
 *  FileReader 객체를 잘 활용해보세요.
 */

public class MainClass14 {
	public static void main(String[] args) {

		File memoFile = new File("C:/acorn202203/myFolder/memo.txt");
		// 필요한 객체의 참조값을 담을 지역 변수를 미리 만든다.
		FileReader fr = null;
		BufferedReader br = null;

		try {
			// 파일에서 문자열을 읽어들일 객체의 참조값을 얻어내서 미리 만들어둔 지역 변수에 담는다.
			fr = new FileReader(memoFile);
			br = new BufferedReader(fr);

			// 반복문 돌면서
			while (true) {
				// 한줄씩 읽어내고
				String line = br.readLine();
				// 만약 더이상 읽을 문자열이 없다면
				if (line == null) {
					break;
				}
				// 읽어낸 문자열 콘솔에 출력하기
				System.out.println(line);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally { // 예외가 발생하든 안하든 실행이 반드시 보장되는 블럭
			// 마무리 작업을 한다.
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
