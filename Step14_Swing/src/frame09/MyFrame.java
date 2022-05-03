package frame09;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class MyFrame extends JFrame implements ActionListener, KeyListener {

	JTextField inputMsg;
	JLabel lab1;

	// 생성자
	public MyFrame(String title) {
		super(title);

		setLayout(new FlowLayout());

		inputMsg = new JTextField(10);
		JButton sendBtn = new JButton("전송");
		lab1 = new JLabel("JLabel입니다.");

		add(inputMsg);
		add(sendBtn);
		add(lab1);

		// 버튼에 리스너 등록하기
		sendBtn.addActionListener(this);
		// 텍스트필드에 키리스너 등록하기
		inputMsg.addKeyListener(this);
	}

	public static void main(String[] args) {
		JFrame f = new MyFrame("나의 프레임");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(100, 100, 500, 500);
		f.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		send();
	}

	// 메소드 추가
	public void send() {
		// 1. JTextField에 입력한 문자열 읽어오기
		String msg = inputMsg.getText();
		// 2. 입력한 문자열을 JLabel에 출력하기
		lab1.setText(msg);
		// 3. 입력한 후에 입력창 비우기
		inputMsg.setText("");
		// 4. 포커스 주기(잡고있기)
		inputMsg.grabFocus();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// 눌려진 키의 코드값이 엔터키의 코드값이면 send() 실행
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			send();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// 키를 입력(누를때)할 때마다 반응
		// 구체적이지 않음

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
