package test.main;

import test.mypac.Car;
import test.mypac.MyObject;
import test.mypac.Radio;
import test.mypac.Speaker;

public class MainClass01 {
	public static void main(String[] args) {
		// MyObject 클래스에 정의된 3개의 메소드를 차례로 호출하는 code를 작성해보세요.
		MyObject obj = new MyObject();
		obj.walk(); // void형은 리턴값 없음
		int num = obj.getNumber();
		String greet = obj.getGreeting();
		Car car = obj.getCar();
		
		// .setNum()	.setName()	.useCar() 메소드 3개를 호출하는 code를 작성해보세요.
		car.name="benz";
		obj.setNum(10);
		obj.setName("무지개");
		obj.useCar(new Car());
		
		// .listenMusic() 메소드를 호출하는 code를 작성해보세요.
		Radio r = new Radio();
		Speaker s = new Speaker();
		obj.listenMusic(r, s);
	}
}
