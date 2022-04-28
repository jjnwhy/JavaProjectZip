package test.main;

import java.util.Scanner;

public class MainClass06 {
	public static void main(String[] args) {
		/*
		 * Scanner 객체를 이용해서 문자열을 5번 입력받는다. 입력 받은 문자열은 차례대로 배열에 저장되어야 한다. 모두 다 입력받은후
		 * for문을 이용해서 배열에 저장된 모든 문자열을 콘솔창에 순서대로 출력하는 코드를 작성해보세요.
		 */
		Scanner scan = new Scanner(System.in);
		String[] str = new String[5];

		for (int i = 0; i < str.length; i++) {
			System.out.print("문자열 입력: ");
			String msg = scan.nextLine();
			str[i] = msg;

		}
		for (int i = 0; i < str.length; i++) {
			String tmp=str[i];
			System.out.print(tmp + " ");
		}

	}
}
