package test.main;

import test.mypac.Drill;
import test.mypac.MultiObject;
import test.mypac.Remocon;

public class MainClass04 {
	public static void main(String[] args) {
		
		// 익명 클래스
		Remocon r1 = new Remocon() {
			
			@Override
			public void up() {
				System.out.println("UP!!!");
			}
			
			@Override
			public void down() {
				System.out.println("DOWN!!!");
			}
		};		
		useRemocon(r1);
		
		//변수에 담지 않고 직접 만들기
		useRemocon(new Remocon() {
			
			@Override
			public void up() {
				System.out.println("UP 222");	
			}
			
			@Override
			public void down() {
				System.out.println("DOWN 222");
			}
		});
		
	}
	public static void useRemocon(Remocon r) {
		r.up();
		r.down();
	}
}
