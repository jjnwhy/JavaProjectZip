package frame02;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame extends JFrame {
	// ������
	public MyFrame(String title) {
		super(title);
		setBounds(100, 100, 500, 500); // setBounds = setLocation + setSize
		setDefaultCloseOperation(EXIT_ON_CLOSE); // JFrame.EXIT_ON_CLOSE�ε� JFrame�� �θ�� ���� ����
		// �������� ���̾ƿ� �Ŵ����� ������� �ʱ� ������ UI�� ������ǥ�� ���� ��ġ�ؾ� �Ѵ�.
		setLayout(new FlowLayout(FlowLayout.LEFT)); // default�� CENTER�̴�. ��, ����, ��

		JButton btn1 = new JButton("��ư1");
		add(btn1); // �����ӿ� btn1 �߰�

		JButton btn2 = new JButton("��ư2");
		add(btn2); // �����ӿ� btn2 �߰�

		JButton btn3 = new JButton("��ư3");
		add(btn3); // �����ӿ� btn3 �߰�

		setVisible(true);
	}

	public static void main(String[] args) {
		new MyFrame("���� ������");
	}

}
