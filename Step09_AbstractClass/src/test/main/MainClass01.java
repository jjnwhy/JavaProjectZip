package test.main;

import test.mypac.Weapon;
import test.mypac.myWeapon;
/*
 * [ �߻�Ŭ����(abstract Class) ]
 * - class ����� �տ� abstract�� ����ؼ� Ŭ������ �����Ѵ�.
 * - ���¸� ���ǵǰ� ���� ������ ���� ���� �޼ҵ尡 ������ �� �ִ�.
 * - ���¸� ���ǵ� �޼ҵ带 ���鶧�� abstract ���� �ٿ��� �޼ҵ带 �����Ѵ�.
 * - �����ڴ� ���������� �ܵ����� ��ü ������ �Ұ��ϴ�.
 * - �߻� Ŭ���� type�� id�� �ʿ��ϴٸ� �߻�Ŭ������ ��ӹ��� �ڽ�Ŭ������ �����ؼ� ��ü �����Ѵ�.
 * - �߻�Ŭ������ ��ӹ��� �ڽ�Ŭ������ �θ��� �߻�޼ҵ带 ��� �������̵�(������) �ؾ��Ѵ�.
 */
public class MainClass01 {
	public static void main(String[] args) {
		Weapon w1=new myWeapon();
		w1.prepare();
		w1.attack();
	}
}
