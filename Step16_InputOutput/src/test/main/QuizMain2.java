package test.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/*
 *  1. JTextField�� ���ڿ��� �Է��ϰ� �߰� ��ư�� ������
 *  �Է��� ���ڿ��� myFolder/memo.txt ���Ͽ� append �ǵ��� �غ�����.
 *  
 *  2. �ҷ����� ��ư�� ������ myFolder/memo.txt ���Ͽ� �ִ� ��� ���ڿ���
 *  JTextArea�� ����ϵ��� �غ�����.
 */
public class QuizMain2 extends JFrame implements ActionListener {
	// �ʵ�
	JTextField tf_msg;
	JTextArea area;
	FileWriter fw = null;
	FileReader fr = null;
	BufferedReader br = null;
	

	// ������
	public QuizMain2() {
		setTitle("���� ������");
		setLayout(new BorderLayout());

		JPanel topPanel = new JPanel();
		JPanel bottomPanel = new JPanel();

		// JTextField ��ü�� �������� �ʵ忡 ����
		tf_msg = new JTextField(10);

		JButton appendBtn = new JButton("�߰��ϱ�");
		JButton loadBtn = new JButton("�ҷ�����");
		JButton removeBtn = new JButton("�ҷ��� ���� �����");
		appendBtn.setActionCommand("append");
		loadBtn.setActionCommand("load");
		removeBtn.setActionCommand("remove");
		appendBtn.addActionListener(this);
		loadBtn.addActionListener(this);
		removeBtn.addActionListener(this);

		topPanel.add(tf_msg);
		topPanel.add(appendBtn);
		topPanel.add(loadBtn);
		bottomPanel.add(removeBtn);

		add(topPanel, BorderLayout.NORTH);
		add(bottomPanel, BorderLayout.SOUTH);
		topPanel.setBackground(Color.ORANGE);
		bottomPanel.setBackground(Color.LIGHT_GRAY);

		// JTextArea
		area = new JTextArea();
		// �������� ����� JTextArea ��ġ�ϱ�
		//rightPanel.add(scroll);
		add(area, BorderLayout.CENTER);

	}

	public static void main(String[] args) {
		QuizMain2 f = new QuizMain2();
		f.setBounds(100, 100, 500, 500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	public void append() {
		String message = tf_msg.getText();
		try {
			fw = new FileWriter("C:/acorn202203/myFolder/memo.txt", true);
			if (message.equals("")) {
				JOptionPane.showMessageDialog(this, "������ �Է��ϼ���");
			} else {
				fw.write("\r\n");
				fw.write(message);
				fw.flush();
				tf_msg.setText("");
				JOptionPane.showMessageDialog(this, "���� �߰� �Ϸ�");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void load() {
		try {
			fr = new FileReader("C:/acorn202203/myFolder/memo.txt");
			br = new BufferedReader(fr);
			while (true) {
				String line = br.readLine();
				if (line == null) {
					break;
				}
				area.append(line);
				area.append("\r\n");

			}
			area.append("---------------------------------------------------\r\n");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void remove() {
		area.setText("");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();

		try {
			if (command.equals("append")) {
				append();
			} else if (command.equals("load")) {
				load();
			} else if (command.equals("remove")) {
				remove();
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
				if (fr != null)
					fr.close();
				if (fw != null)
					fw.close();
			} catch (Exception e3) {
				e3.printStackTrace();
			}

		}

	}

}