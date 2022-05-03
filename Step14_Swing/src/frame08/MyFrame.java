package frame08;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/*
 *  JTextField 객체의 메소드를 잘 활용해서 메시지를 입력하고 '눌러보셈'버튼을 누르면
 *  입력한 메시지가 알림창에 출력되도록 프로그래밍 해보세요.
 */
public class MyFrame extends JFrame implements ActionListener {

	// 필드
	JTextField inputMsg;

	// 생성자
	public MyFrame(String title) {
		super(title);

		// 레이아웃 설정
		setLayout(new FlowLayout());

		inputMsg = new JTextField(10);
		JButton btn = new JButton("눌러보셈");

		add(inputMsg);
		add(btn);

		btn.addActionListener(this);

		btn.setActionCommand("send");
	}

	public static void main(String[] args) {
		JFrame f = new MyFrame("나의 프레임");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(100, 100, 500, 500);
		f.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String msg = inputMsg.getText();
		JOptionPane.showMessageDialog(this, msg);

//		굳이 equals 받아올 필요없다. 액션이 하나이므로!
//		String command = e.getActionCommand();
//		if(command.equals("send")) {
//			JOptionPane.showMessageDialog(this, inputMsg.getText());
//		}

	}
}
