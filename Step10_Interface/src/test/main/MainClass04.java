package test.main;

import test.mypac.Drill;
import test.mypac.MultiObject;
import test.mypac.Remocon;

public class MainClass04 {
	public static void main(String[] args) {
		
		// �͸� Ŭ����
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
		
		//������ ���� �ʰ� ���� �����
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
