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

public class MainClass12 {
	public static void main(String[] args) {
		
		File memoFile = new File("C:/acorn202203/myFolder/memo.txt");

		try {
			// 파일에서 문자열을 읽어들일 수 있는 객체 생성
			FileReader fr = new FileReader(memoFile);
			// 반복문 돌면서
			while (true) {
				// 문자 code 하나씩 읽어낸다.
				int code = fr.read();
				// 만약 더이상 읽을 codr값이 없으면
				if (code == -1) {
					break; //반복문 탈출
				}
				// 코드값을 문자로 변환해서 
				char ch = (char) code;
				// 개행기호 없이 출력하기
				System.out.print(ch);			
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
