package test.mypac;

public class Member {
	public int num;
	public String name;
	public String addr;

	/*
	 * �⺻ �����ڴ� �ʿ��ϴٸ� ������ �� �ִ�.
	 * �����ڴ� �������ǰ� �����ϴ�.
	 * ���� � ��ü�� �����ϴ� ����� ���������� �ɼ��� �ִٴ� ���̴�.
	 */
	public Member() {
		
	}
	
	// �ʵ忡 ������ ���� ���޹޴� ������
	public Member(int num, String name, String addr) {
		this.num = num;
		this.name = name;
		this.addr = addr;
	}
}