package test.main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainClass16 {
	public static void main(String[] args) {
		// 필요한 참조값을 담을 지역변수를 미리 만든다.
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			fis = new FileInputStream("C:/acorn202203/myFolder/1.jpg");
			fos = new FileOutputStream("C:/acorn202203/myFolder/copied.jpg");

			// byte 알갱이를 읽어낼 byte[] 객체 생성
			byte[] buffer = new byte[1024];
			while (true) {
				// byte[] 객체를 전달해서 읽어내고 리턴되는 데이터는 읽은 byte의 갯수가 리턴된다.
				int readByte = fis.read(buffer);
				System.out.println(readByte);
				if (readByte == -1) {
					break;
				}
				fos.write(buffer, 0, readByte); // buffer를 작성할건데 0~readByte크기만큼 write한다.
				fos.flush();
			}
			System.out.println("copy 성공");
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
