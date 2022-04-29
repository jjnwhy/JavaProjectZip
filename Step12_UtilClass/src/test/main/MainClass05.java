package test.main;

import java.util.ArrayList;
import java.util.List;

import test.mypac.Car;

public class MainClass05 {
	public static void main(String[] args) {
		// 1. Car type�� ������ �� �ִ� ArrayList ��ü�� �����ؼ� �������� List �������̽� type �������� cars�� ��ƺ�����.
		List<Car> cars = new ArrayList<>();
		
		// 2. Car ��ü(3��)�� �����ؼ� List ��ü�� �����غ�����.
		cars.add(new Car("GV60"));
		cars.add(new Car("GV70"));
		cars.add(new Car("GV80"));
		
		// 3. �ݺ��� for���� �̿��ؼ� List ��ü�� ����� ��� Car ��ü�� drive() �޼ҵ带 ������� ȣ���غ�����.
		for(int i=0;i<cars.size();i++) {
			cars.get(i).drive();
		}
	}
}
