package test.main;

import test.auto.CampingCar;
import test.auto.Engine;
import test.auto.KCar;

public class MainClass07 {
	public static void main(String[] args) {
		CampingCar car1= new CampingCar(new Engine());
		car1.drive();
		car1.sleepInCar();
		
		KCar car2=new KCar(new Engine());
		car2.autoDriving();
		car2.drive();
		
		
	}
}
