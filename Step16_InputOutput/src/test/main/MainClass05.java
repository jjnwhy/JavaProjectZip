package test.main;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;

public class MainClass05 {
	public static void main(String[] args) {
		PrintStream ps = System.out;
		
		OutputStream os = ps;

		OutputStreamWriter osw = new OutputStreamWriter(os);
		try {
			osw.write(48148);
			osw.write(48372);
			osw.write("гоюл");
			osw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
