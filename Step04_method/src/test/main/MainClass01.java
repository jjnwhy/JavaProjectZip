package test.main;

import test.mypac.Car;
import test.mypac.MyObject;
import test.mypac.Radio;
import test.mypac.Speaker;

public class MainClass01 {
	public static void main(String[] args) {
		// MyObject Ŭ������ ���ǵ� 3���� �޼ҵ带 ���ʷ� ȣ���ϴ� code�� �ۼ��غ�����.
		MyObject obj = new MyObject();
		obj.walk(); // void���� ���ϰ� ����
		int num = obj.getNumber();
		String greet = obj.getGreeting();
		Car car = obj.getCar();
		
		// .setNum()	.setName()	.useCar() �޼ҵ� 3���� ȣ���ϴ� code�� �ۼ��غ�����.
		car.name="benz";
		obj.setNum(10);
		obj.setName("������");
		obj.useCar(new Car());
		
		// .listenMusic() �޼ҵ带 ȣ���ϴ� code�� �ۼ��غ�����.
		Radio r = new Radio();
		Speaker s = new Speaker();
		obj.listenMusic(r, s);
	}
}
