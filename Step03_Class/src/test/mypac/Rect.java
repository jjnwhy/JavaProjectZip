package test.mypac;

public class Rect {
	// �ʵ�
	public int width;
	public int height;

	// �޼ҵ�
	public void showArea() {
		int area = width * height;
		System.out.println("����: " + area);
	}

	// ������ �޼ҵ�� ȣ���� ������ �������ִ� �޼ҵ�
	public int getArea() {
		int area = width * height;
		return area;
	}
}
