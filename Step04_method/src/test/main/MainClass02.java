package test.main;

import test.mypac.Car;
import test.mypac.Messenger;

public class MainClass02 {
	public static void main(String[] args) {
		//Messenger 클래스에 만든 static 메소드 3개를 호출하는 code를 작성해보세요.
		Messenger.sendMessage("hi");
		Messenger.getMessage();
		Messenger.useCar(new Car());
	}
}
