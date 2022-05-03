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

	// ������
	public MyFrame(String title) {
		super(title);

		setLayout(new BorderLayout());

		// JPanel
		JPanel topPanel = new JPanel();
		topPanel.setBackground(Color.ORANGE);
		// Panel �� ���ʿ� ��ġ�ϱ�
		add(topPanel, BorderLayout.NORTH);

		// JTextField ��ü�� ���鿡�� JPanel �� �߰��ϱ�
		tf_num1 = new JTextField(10);
		topPanel.add(tf_num1);
		// ��� ��ư ��ü�� ���� JPanel �� �߰��ϱ�
		plusBtn = new JButton("+");
		minusBtn = new JButton("-");
		multiBtn = new JButton("*");
		divideBtn = new JButton("/");
		topPanel.add(plusBtn);
		topPanel.add(minusBtn);
		topPanel.add(multiBtn);
		topPanel.add(divideBtn);
		// �ι�° JTextField ���� ��ο� �߰� �ϱ�
		tf_num2 = new JTextField(10);
		topPanel.add(tf_num2);
		// JLabel
		JLabel label1 = new JLabel("=");
		label_result = new JLabel("0");
		// ��ο� ���̺� �߰��ϱ�
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
		JFrame f = new MyFrame("���� ������");
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
					JOptionPane.showMessageDialog(this, "0���� ���� �� �����ϴ�.");
				}
				/* *** ������ �ڵ� ***
				 * //������ ������� ���� ���� ���� double result=0; //������ ��ư�� command �о���� String
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
				 * //��� ���� JLabel �� ����ϱ�
				 * label_result.setText(Double.toString(result));
				 * 
				 */
			}
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(this, "���ڸ� �Է��ϼ���.");
		}

	}

}
