package test.main;

import test.mypac.HandPhone;
import test.mypac.SmartPhone;

public class MainClass05 {
	public static void main(String[] args) {

		// �ڽĿ��� ���� �Ϲ� �ڵ���(���ͳ��� �ȵ�)
		HandPhone p1 = new HandPhone();

		// Smart������ �ٲٰ�ʹ�. => ���ο� ������ ������ �ͼ� smart phone���� �ٲ��.
		SmartPhone p2 = (SmartPhone) p1;

		p2.doInternet(); // error
		// ĳ�����Ҷ� ��Ӱ��� ����!! ��
	}
}
