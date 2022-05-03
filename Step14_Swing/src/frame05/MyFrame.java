package frame05;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MyFrame extends JFrame {
	// ������
	public MyFrame(String title) {
		super(title);
		// MyFrame�� ���̾ƿ� �Ŵ��� �����ϱ�
		setLayout(new FlowLayout());
		// ��ư
		JButton sendBtn = new JButton("����");
		JButton removeBtn = new JButton("����");
		// �����ӿ� ��ư �߰��ϱ�(FlowLayout�� ������ �޴´�.)
		add(sendBtn);
		add(removeBtn);

		ActionListener listener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("����?");
				JOptionPane.showMessageDialog(MyFrame.this, "�����մϴ�~"); // 'MyFrame.this' == 'MyFrame a=this'
			}
		};
		sendBtn.addActionListener(listener);

		removeBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("����?!");
				JOptionPane.showMessageDialog(MyFrame.this, "�����ƾ��..");
				// ���⼭ ����Ű�� this�� ActionListener�̴�.
			}
		});

	}

	public static void main(String[] args) {
		JFrame f = new MyFrame("���� ������");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(100, 100, 500, 500);
		f.setVisible(true);
	}

}
