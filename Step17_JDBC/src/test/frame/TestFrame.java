package test.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import test.dao.MemberDao;
import test.dto.MemberDto;

public class TestFrame extends JFrame implements ActionListener {
	// �ʵ�
	JTextField inputName, inputAddr;
	DefaultTableModel model;
	JTable table;

	// ������
	public TestFrame() {
		setLayout(new BorderLayout());

		JLabel label1 = new JLabel("�̸�");
		inputName = new JTextField(10);

		JLabel label2 = new JLabel("�ּ�");
		inputAddr = new JTextField(10);

		JButton saveBtn = new JButton("����");
		saveBtn.setActionCommand("save");
		saveBtn.addActionListener(this);
		// ���� ��ư �߰�
		JButton deleteBtn = new JButton("����");
		deleteBtn.setActionCommand("delete");
		deleteBtn.addActionListener(this);

		JPanel panel = new JPanel();
		panel.add(label1);
		panel.add(inputName);
		panel.add(label2);
		panel.add(inputAddr);
		panel.add(saveBtn);
		panel.add(deleteBtn);
		panel.setBackground(Color.ORANGE);

		add(panel, BorderLayout.NORTH);

		// ǥ�������� ������ ����ϱ� ���� JTable
		table = new JTable();
		// Į������ String[] �� ������� �غ�
		String[] colNames = { "��ȣ", "�̸�", "�ּ�" };
		// ���̺� ����� ������ ������ �ִ� �� ��ü (Į����, row ����)
		model = new DefaultTableModel(colNames, 0);
		// ���� ���̺� �����Ѵ�.
		table.setModel(model);
		// ��ũ���� ���� �ϵ��� ���̺��� JScrollPane �� ���Ѵ�.
		JScrollPane scroll = new JScrollPane(table);
		// JScrollPane �� �������� ����� ��ġ�ϱ�
		add(scroll, BorderLayout.CENTER);

		displayMember();
	}

	// ���̺� �����͸� ����ϴ� �޼ҵ�
	public void displayMember() {

		model.setRowCount(0); // ���̺� ��µ� �����͸� reset

		MemberDao dao = new MemberDao();
		MemberDto dto = new MemberDto();

		List<MemberDto> list = dao.getList();
		for (MemberDto tmp : list) {
			Object[] row = { tmp.getNum(), tmp.getName(), tmp.getAddr() };
			model.addRow(row);
		}

	}

	// main �޼ҵ�
	public static void main(String[] args) {
		TestFrame f = new TestFrame();

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(100, 100, 800, 500);
		f.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		MemberDao dao = new MemberDao();
		MemberDto dto = new MemberDto();

		String command = e.getActionCommand();
		String name = inputName.getText();
		String addr = inputAddr.getText();

		try {
			if (command.equals("save")) {
				if (name.isEmpty() || addr.isEmpty()) {
					JOptionPane.showMessageDialog(this, "�̸��� �ּҸ� �Է��ϼ���.");
				} else {
					dto.setName(name);
					dto.setAddr(addr);

					dao.insert(dto);

					JOptionPane.showMessageDialog(this, "ȸ�� �߰� �Ϸ�");
					inputName.setText("");
					inputAddr.setText("");

					displayMember();
				}

			} else if (command.equals("delete")) {
				int number = table.getSelectedRow();
				int num = (int) model.getValueAt(number, 0);

				model.removeRow(number);
				dao.delete(num);
				JOptionPane.showMessageDialog(this, "ȸ�� ���� �Ϸ�");

				displayMember();

				
			}
		} catch (ArrayIndexOutOfBoundsException e2) {
			JOptionPane.showMessageDialog(this, "������ ȸ���� �����ϼ���.");
			//e2.printStackTrace();
		} 

	}

}
