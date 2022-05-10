package test.main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainClass15 {
	public static void main(String[] args) {
		// 필요한 참조값을 담을 지역변수를 미리 만든다.
		FileInputStream fis=null;
		FileOutputStream fos=null;
		try {
			fis=new FileInputStream("C:/acorn202203/myFolder/1.jpg");
			fos=new FileOutputStream("C:/acorn202203/myFolder/copied.jpg");

			// 읽어낸 int 값을 그대로 출력
			
			while(true) {
				// 1 byte씩 읽어내고
				int data=fis.read();
				// 더이상 읽을 데이터가 없으면 탈출
				if(data==-1) {
					break;
				}
				fos.write(data);
				fos.flush();
			}
			System.out.println("copy 성공");			
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
