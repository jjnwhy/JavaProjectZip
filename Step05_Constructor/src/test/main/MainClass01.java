package test.main;

import test.mypac.Member;
import test.mypac.Student;

public class MainClass01 {
	public static void main(String[] args) {
		Student s1=new Student();
		s1.Study();
		new Student().goSchool();
		new Student().Study();
		
		Member m1 = new Member(1, "�豸��", "�뷮��");
		Member m2 = new Member(2, "�ذ�", "��ŵ�");
		
	}
}
