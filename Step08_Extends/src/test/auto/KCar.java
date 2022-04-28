package test.auto;

public class KCar extends Car {

	public KCar(Engine engine) {
		super(engine);
	}

	public void autoDriving() {
		System.out.println("자율주행모드");
	}

}
