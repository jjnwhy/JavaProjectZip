package test.main;

import test.mypac.HandPhone;
import test.mypac.SmartPhone;

public class MainClass05 {
	public static void main(String[] args) {

		// 자식에게 사준 일반 핸드폰(인터넷이 안됨)
		HandPhone p1 = new HandPhone();

		// Smart폰으로 바꾸고싶다. => 새로운 설명서를 가지고 와서 smart phone으로 바꿨다.
		SmartPhone p2 = (SmartPhone) p1;

		p2.doInternet(); // error
		// 캐스팅할때 상속관계 주의!! ※
	}
}
