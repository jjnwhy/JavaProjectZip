package test.main;

import test.mypac.MyUtil;

public class MainClass02 {

	public static String myName = "�豸��";

	public static void test() {
		System.out.println("test() ȣ���");
	}

	public static void main(String[] args) {
		MyUtil.send();
		MyUtil.version = "1.0";
		// new MainClass02().test(); //��ü�� �����ؼ� ���������� �ҷ��;� ��� �����ϴ�.
		System.out.println(MainClass02.myName);
		test(); // ���� Ŭ������ static���� ����Ǿ��ֱ� ������ MainClass02. ��������
	}
}
