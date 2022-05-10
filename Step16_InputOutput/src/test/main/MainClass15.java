package test.main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainClass15 {
	public static void main(String[] args) {
		// �ʿ��� �������� ���� ���������� �̸� �����.
		FileInputStream fis=null;
		FileOutputStream fos=null;
		try {
			fis=new FileInputStream("C:/acorn202203/myFolder/1.jpg");
			fos=new FileOutputStream("C:/acorn202203/myFolder/copied.jpg");

			// �о int ���� �״�� ���
			
			while(true) {
				// 1 byte�� �о��
				int data=fis.read();
				// ���̻� ���� �����Ͱ� ������ Ż��
				if(data==-1) {
					break;
				}
				fos.write(data);
				fos.flush();
			}
			System.out.println("copy ����");			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(fis!=null)fis.close();
				if(fos!=null)fos.close();
			} catch (IOException e) { 
				e.printStackTrace();
			}
			
			
		}
		
	}
}
