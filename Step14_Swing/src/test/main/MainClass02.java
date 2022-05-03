package test.main;

import javax.swing.JFrame;

import test.mypac.TestFrame;

public class MainClass02 {
	public static void main(String[] args) {
		JFrame f = new TestFrame("Hello Frame");
		// TestFrame에서 부르고(setVisible) 메인에서는 생성만 해도 됨!
		
		// f.setVisible(true); 여기서 불러도됨!

	}
}
