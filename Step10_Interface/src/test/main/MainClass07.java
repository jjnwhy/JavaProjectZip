package test.main;

import test.mypac.Joinner;

public class MainClass07 {
	public static void main(String[] args) {
		Joinner j1 = new Joinner() {

			@Override
			public String join(String one, String two) {
				return one + two;
			}
		};

		Joinner j2 = (one, two) -> {
			return one + two;
		};

		Joinner j3 = (one, two) -> one + two;
		
		String result1=j1.join("kim", "gura");
		String result2=j2.join("kim", "gura");
		String result3=j3.join("kim", "gura");
		
		// 문자열은 내용이 같아도 참조값은 다를 수 있다.(같을수도 있다.)
		boolean isEqual = result1 == result2; //false , but 자바에서 이런 문법 사용 X
		// 문자열의 내용비교 할때는 String 객체의 메소드를 활용해야한다.
		boolean isEqual1 = result1.equals(result2);
		boolean isEqual2 = result1.equals("kimgura");
		boolean isEqual3 ="kimgura".equals(result3);
	}
}
