package test.main;

import test.mypac.Remocon;

public class MainClass03 {
	// 내부 클래스
	static class YourRemocon implements Remocon {

		@Override
		public void up() {
			System.out.println("** UP");
		}

		@Override
		public void down() {
			System.out.println("** DOWN");
		}

	}

	public static void main(String[] args) {
		Remocon r1 = new YourRemocon();
		useRemocon(r1);

	}

	public static void useRemocon(Remocon r) {
		r.up();
		r.down();
	}
}
