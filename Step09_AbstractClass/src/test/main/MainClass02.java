package test.main;

import test.mypac.Gun;
import test.mypac.Weapon;

public class MainClass02 {
	public static void main(String[] args) {
		// �������� ���� Ŭ������ ����� ��ü ������ �ؼ� �Ʒ��� useWeapon() �޼ҵ带 ȣ���غ�����.
		Weapon wp = new Gun();
		useWeapon(wp);
	}
	// �� �޼ҵ�� ���� ������ ������ �ϴ� �޼ҵ��� ����
	public static void useWeapon(Weapon w) { //�߻�Ŭ�������� ������Ÿ�� ��� ����
		w.prepare();
		w.attack();
	}
}
