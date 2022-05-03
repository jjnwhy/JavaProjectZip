package frame10;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyFrame extends JFrame implements ActionListener {

	JTextField tf_num1;
	JTextField tf_num2;

	JButton plusBtn;
	JButton minusBtn;
	JButton multiBtn;
	JButton divideBtn;

	JLabel label_result;

	// 생성자
	public MyFrame(String title) {
		super(title);

		setLayout(new BorderLayout());

		// JPanel
		JPanel topPanel = new JPanel();
		topPanel.setBackground(Color.ORANGE);
		// Panel 을 북쪽에 배치하기
		add(topPanel, BorderLayout.NORTH);

		// JTextField 객체를 만들에서 JPanel 에 추가하기
		tf_num1 = new JTextField(10);
		topPanel.add(tf_num1);
		// 기능 버튼 객체를 만들어서 JPanel 에 추가하기
		plusBtn = new JButton("+");
		minusBtn = new JButton("-");
		multiBtn = new JButton("*");
		divideBtn = new JButton("/");
		topPanel.add(plusBtn);
		topPanel.add(minusBtn);
		topPanel.add(multiBtn);
		topPanel.add(divideBtn);
		// 두번째 JTextField 만들어서 페널에 추가 하기
		tf_num2 = new JTextField(10);
		topPanel.add(tf_num2);
		// JLabel
		JLabel label1 = new JLabel("=");
		label_result = new JLabel("0");
		// 페널에 레이블 추가하기
		topPanel.add(label1);
		topPanel.add(label_result);

		plusBtn.addActionListener(this);
		minusBtn.addActionListener(this);
		multiBtn.addActionListener(this);
		divideBtn.addActionListener(this);

		plusBtn.setActionCommand("+");
		minusBtn.setActionCommand("-");
		multiBtn.setActionCommand("*");
		divideBtn.setActionCommand("/");
	}

	public static void main(String[] args) {
		JFrame f = new MyFrame("나의 프레임");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(100, 100, 500, 500);
		f.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String command = e.getActionCommand();
		
		try {

			double num1 = Double.parseDouble(tf_num1.getText());
			double num2 = Double.parseDouble(tf_num2.getText());
			
			if (command.equals("+")) {
				String result = String.valueOf(num1 + num2);
				label_result.setText(result);

			} else if (command.equals("-")) {
				String result = String.valueOf(num1 - num2);
				label_result.setText(result);

			} else if (command.equals("*")) {
				String result = String.valueOf(num1 * num2);
				label_result.setText(result);

			} else if (command.equals("/")) {
				String result = String.valueOf(num1 / num2);
				label_result.setText(result);
				if (num2 == 0) {
					label_result.setText(" ");
					JOptionPane.showMessageDialog(this, "0으로 나눌 수 없습니다.");
				}
				/* *** 선생님 코드 ***
				 * //연산의 결과값을 담을 지역 변수 double result=0; //눌러진 버튼의 command 읽어오기 String
				 * command=e.getActionCommand(); 
				 * if(command.equals("plus")) { 
				 * 	result=num1+num2;
				 * }else if(command.equals("minus")) { 
				 * 		result=num1-num2; 
				 * }else if(command.equals("multi")) { 
				 * 		result=num1*num2; 
				 * }else if(command.equals("divide")) { 
				 * 		result=num1/num2; 
				 * } 
				 * //결과 값을 JLabel 에 출력하기
				 * label_result.setText(Double.toString(result));
				 * 
				 */
			}
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(this, "숫자를 입력하세요.");
		}

	}

}
