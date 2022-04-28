package test.main;

import java.util.Scanner;

public class MainClass05 {
	public static void main(String[] args) {
		System.out.println("main메소드가 시작됩니다.");
		System.out.print("입력: ");
		// 키보드로부터 입력받을 수 있는 객체 생성
		Scanner scan = new Scanner(System.in);
		// 한줄 입력받고
		String str = scan.nextLine();
		// 입력 받은 문자열을 콘솔에 출력하고
		System.out.println(str);
		// 종료
		System.out.println("main메소드가 종료됩니다.");
	}
}
