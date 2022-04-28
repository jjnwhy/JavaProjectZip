package test.main;

import test.mypac.Weapon;

public class MainClass05 {
	// String str="kim" // non static field

	// static field
	static Weapon w1 = new Weapon() {

		@Override
		public void attack() {
			// TODO Auto-generated method stub
			System.out.println("어..어 일단 공격!");
		}

	};

	public static void main(String[] args) {

		useWeapon(w1);

		Weapon w2 = new Weapon() {

			@Override
			public void attack() {
				// TODO Auto-generated method stub
				System.out.println("익명의 공격2222");
			}

		};
		useWeapon(w2);

		useWeapon(new Weapon() {

			@Override
			public void attack() {
				System.out.println("어..어 일단 공격!");
			}

		});
	}

	public static void useWeapon(Weapon w) {
		w.prepare();
		w.attack();
	}
}
