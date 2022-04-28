package test.mypac;

public class Rect {
	// 필드
	public int width;
	public int height;

	// 메소드
	public void showArea() {
		int area = width * height;
		System.out.println("넓이: " + area);
	}

	// 면적을 메소드로 호출한 곳으로 리턴해주는 메소드
	public int getArea() {
		int area = width * height;
		return area;
	}
}
