package test.main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainClass16 {
	public static void main(String[] args) {
		// �ʿ��� �������� ���� ���������� �̸� �����.
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			fis = new FileInputStream("C:/acorn202203/myFolder/1.jpg");
			fos = new FileOutputStream("C:/acorn202203/myFolder/copied.jpg");

			// byte �˰��̸� �о byte[] ��ü ����
			byte[] buffer = new byte[1024];
			while (true) {
				// byte[] ��ü�� �����ؼ� �о�� ���ϵǴ� �����ʹ� ���� byte�� ������ ���ϵȴ�.
				int readByte = fis.read(buffer);
				System.out.println(readByte);
				if (readByte == -1) {
					break;
				}
				fos.write(buffer, 0, readByte); // buffer�� �ۼ��Ұǵ� 0~readByteũ�⸸ŭ write�Ѵ�.
				fos.flush();
			}
			System.out.println("copy ����");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null)
					fis.close();
				if (fos != null)
					fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}
}
