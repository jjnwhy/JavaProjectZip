package test.main;

import test.mypac.Genie;
import test.mypac.Remocon;

public class MainClass02 {	
	public static void main(String[] args) {
		// ���� Ŭ������ test.mypac ��Ű���� ���� useRemocon() �޼ҵ带 ���⼭ ȣ���غ�����.
		Remocon r1=new Genie();
		useRemocon(r1);
	}
	
	public static void useRemocon(Remocon r) {
		r.up();
		r.down();
	}
}
