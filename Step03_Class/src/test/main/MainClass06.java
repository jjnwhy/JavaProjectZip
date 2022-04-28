package test.main;

import test.mypac.Car;
import test.mypac.CarFactory;

/*
 * 	CarFactory��� �̸��� Ŭ������ ��������.
 * 
 * 	CarFactory ��ü�� getCar()��� �޼ҵ尡 �ְ�
 * 	�ش� �޼ҵ带 ȣ���ϸ� Car type��ü�� �������� �����ϵ��� �޼ҵ带 ��������.
 */
public class MainClass06 {
	public static void main(String[] args) {
		// CarFactory ��ü�� �̿��ؼ� Car ��ü�� �������� ���ͼ�
		CarFactory car = new CarFactory();
		Car c1 = car.getCar();
		// ���� �̸��� �ְ�
		c1.name = "Benz-GLC";

		// drive() �޼ҵ带 ȣ���غ�����.
		c1.drive();
	}
}
