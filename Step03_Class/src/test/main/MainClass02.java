package test.main;

import test.mypac.MyUtil;

public class MainClass02 {

	public static String myName = "김구라";

	public static void test() {
		System.out.println("test() 호출됨");
	}

	public static void main(String[] args) {
		MyUtil.send();
		MyUtil.version = "1.0";
		// new MainClass02().test(); //객체를 생성해서 참조값으로 불러와야 사용 가능하다.
		System.out.println(MainClass02.myName);
		test(); // 같은 클래스에 static으로 선언되어있기 때문에 MainClass02. 생략가능
	}
}
