package frame08;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/*
 *  JTextField ��ü�� �޼ҵ带 �� Ȱ���ؼ� �޽����� �Է��ϰ� '��������'��ư�� ������
 *  �Է��� �޽����� �˸�â�� ��µǵ��� ���α׷��� �غ�����.
 */
public class MyFrame extends JFrame implements ActionListener {

	// �ʵ�
	JTextField inputMsg;

	// ������
	public MyFrame(String title) {
		super(title);

		// ���̾ƿ� ����
		setLayout(new FlowLayout());

		inputMsg = new JTextField(10);
		JButton btn = new JButton("��������");

		add(inputMsg);
		add(btn);

		btn.addActionListener(this);

		btn.setActionCommand("send");
	}

	public static void main(String[] args) {
		JFrame f = new MyFrame("���� ������");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(100, 100, 500, 500);
		f.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String msg = inputMsg.getText();
		JOptionPane.showMessageDialog(this, msg);

//		���� equals �޾ƿ� �ʿ����. �׼��� �ϳ��̹Ƿ�!
//		String command = e.getActionCommand();
//		if(command.equals("send")) {
//			JOptionPane.showMessageDialog(this, inputMsg.getText());
//		}

	}
}
