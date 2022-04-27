package com.lec.ex4_supermarket;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CustomerGUI extends JFrame implements ActionListener{

	private Container contanPane;
	private JPanel jp1;
	private JPanel jp2;
	private JButton btnId;
	private JButton btnTel;
	private JButton btnName;
	private JButton btnBuyPoint;
	private JButton btnBuy;
	private JButton btnLvOut;
	private JButton btnAllOut;
	private JButton btnInsert;
	private JButton btnUpdateTel;
	private JButton btnDelete;
	private JButton btnExit;
	private JComboBox<String> comLevel;
	private JTextField txtId;
	private JTextField txtTel;
	private JTextField txtName;
	private JTextField txtPoint;
	private JTextField txtAmount;
	private JTextArea jta;
	private JScrollPane scrollPane;
	
	private Vector<String> levels;
	private CustomerDao dao = CustomerDao.getIntance();
	private CustomerDto dto;
	private ArrayList<CustomerDto> customers;
	
	public CustomerGUI(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contanPane = getContentPane();
		contanPane.setLayout(new FlowLayout());
		jp1 = new JPanel(new GridLayout(6, 3));
		jp2 = new JPanel();
		
		btnId = new JButton("���̵� �˻�");
		btnTel = new JButton("��4�ڸ�(FULL) �˻�");
		btnName = new JButton("�� �̸� �˻�");
		btnBuyPoint = new JButton("����Ʈ�θ� ����");
		btnBuy = new JButton("��ǰ ����");
		btnLvOut = new JButton("��޺����");
		btnAllOut = new JButton("��ü���");
		btnInsert = new JButton("ȸ������");
		btnUpdateTel = new JButton("��ȣ����");
		btnDelete = new JButton("ȸ��Ż��");
		btnExit = new JButton("������");
		levels = dao.levelList();
		comLevel = new JComboBox<String>(levels);
		txtId = new JTextField(20);
		txtTel = new JTextField(20);
		txtName = new JTextField(20);
		txtPoint = new JTextField(20);
		txtAmount = new JTextField(20);
		
		jta = new JTextArea(10, 80);
		scrollPane = new JScrollPane(jta);
		
		jp1.add(new JLabel("���̵�", (int) CENTER_ALIGNMENT));
		jp1.add(txtId);
		jp1.add(btnId);
		jp1.add(new JLabel("�� ��ȭ", (int) CENTER_ALIGNMENT));
		jp1.add(txtTel);
		jp1.add(btnTel);
		jp1.add(new JLabel("�� �̸�", (int) CENTER_ALIGNMENT));
		jp1.add(txtName);
		jp1.add(btnName);
		jp1.add(new JLabel("�� �� Ʈ", (int) CENTER_ALIGNMENT));
		jp1.add(txtPoint);
		jp1.add(btnBuyPoint);
		jp1.add(new JLabel("���� �ݾ�", (int) CENTER_ALIGNMENT));
		jp1.add(txtAmount);
		jp1.add(new JLabel());
		jp1.add(new JLabel("�� ���", (int) CENTER_ALIGNMENT));
		jp1.add(comLevel);
		jp1.add(new JLabel());
		
		jp2.add(btnBuy);
		jp2.add(btnLvOut);
		jp2.add(btnAllOut);
		jp2.add(btnInsert);
		jp2.add(btnUpdateTel);
		jp2.add(btnDelete);
		jp2.add(btnExit);
		
		contanPane.add(jp1);
		contanPane.add(jp2);
		contanPane.add(scrollPane);
		
		setSize(new Dimension(1000, 500));
		setVisible(true);
		setLocation(200, 100);
		jta.setText("\t�� �� �� �� �˻� �� �����ϼ��� �� �� ��");
		
		btnId.addActionListener(this);
		btnTel.addActionListener(this);
		btnName.addActionListener(this);
		btnBuyPoint.addActionListener(this);
		btnBuy.addActionListener(this);
		btnLvOut.addActionListener(this);
		btnAllOut.addActionListener(this);
		btnInsert.addActionListener(this);
		btnUpdateTel.addActionListener(this);
		btnDelete.addActionListener(this);
		btnExit.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnId) {  // ID �˻�
			int id;
			try {
				id = Integer.parseInt(txtId.getText().trim());
			} catch (Exception e1) {
				jta.setText("��ȿ���� �ʴ� ���̵� �Է� ���Դϴ�");
				return;
			}

			dto = dao.selectCid(id);
			
			if (dto == null) {
				jta.setText("�˻����� ���� ID�Դϴ�");
				txtTel.setText("");
				txtName.setText("");
				txtPoint.setText("");
				txtAmount.setText("");
				comLevel.setSelectedItem("");
			} else {
				txtTel.setText(dto.getcTel());
				txtName.setText(dto.getcName());
				txtPoint.setText(String.valueOf(dto.getcPoint()));
				comLevel.setSelectedItem(dto.getLevelName());
				jta.setText("ID\t��ȭ\t\t�̸�\t����Ʈ\t���Ŵ�����\t������\t�������� ���� �߰� ������ �ݾ�\n");
				jta.append("��������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������\n");
				jta.append(dto.toString());
			}
			
		} else if (e.getSource() == btnTel) {  // ��ȭ��ȣ �˻�
			String tel = txtTel.getText().trim();
			
			if (tel.equals("")) {
				jta.setText("��ȭ��ȣ�� �Է��ϼ���");
				return;
			}
			
			if (tel.length() < 4) {
				jta.setText("��� 4�ڸ� �̻� �Է��ϼ���");
				return;
			}
			
			customers = dao.selectTel(tel);
			
			if (customers.isEmpty()) {
				jta.setText("�ش� ��ȭ��ȣ�� ���Ե� ���� �����ϴ�");
				txtId.setText("");
				txtName.setText("");
				txtPoint.setText("");
				txtAmount.setText("");
				comLevel.setSelectedItem("");
			} else {
				txtId.setText(String.valueOf(customers.get(0).getcId()));
				txtTel.setText(customers.get(0).getcTel());
				txtName.setText(customers.get(0).getcName());
				txtPoint.setText(String.valueOf(customers.get(0).getcPoint()));
				comLevel.setSelectedItem(customers.get(0).getLevelName());
				jta.setText("ID\t��ȭ\t\t�̸�\t����Ʈ\t���Ŵ�����\t������\t�������� ���� �߰� ������ �ݾ�\n");
				jta.append("��������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������\n");
				for (CustomerDto d : customers) {
					jta.append(d.toString());
				}
			}
			
		} else if (e.getSource() == btnName) {  // �̸��˻�
			String name = txtName.getText().trim();
			
			if (name.equals("")) {
				jta.setText("�̸��� �Է��ϼ���");
				return;
			}
			
			customers = dao.selectCName(name);
			
			if (customers.isEmpty()) {
				jta.setText("�ش� �̸����� ���Ե� ���� �����ϴ�");
				txtId.setText("");
				txtTel.setText("");
				txtPoint.setText("");
				txtAmount.setText("");
				comLevel.setSelectedItem("");
			} else {
				txtId.setText(String.valueOf(customers.get(0).getcId()));
				txtTel.setText(customers.get(0).getcTel());
				txtPoint.setText(String.valueOf(customers.get(0).getcPoint()));
				comLevel.setSelectedItem(customers.get(0).getLevelName());
				jta.setText("ID\t��ȭ\t\t�̸�\t����Ʈ\t���Ŵ�����\t������\t�������� ���� �߰� ������ �ݾ�\n");
				jta.append("��������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������\n");
				for (CustomerDto d : customers) {
					jta.append(d.toString());
				}
			}
			
		} else if (e.getSource() == btnBuyPoint) {  // ����Ʈ�θ� ����
			int id;
			int point;
			int amount;
			try {
				
				id = Integer.parseInt(txtId.getText().trim());
				point = Integer.parseInt(txtPoint.getText().trim());
				amount = Integer.parseInt(txtAmount.getText().trim());
				
				if (point < 0 || amount < 0) {
					jta.setText("0���� ū ���� �Է��ϼ���");
					return;
				}
				
				if (amount > point) {
					jta.setText("����Ʈ�� �����Ͽ� ����Ʈ�� ���Ű� �Ұ��մϴ�");
				} else {
					int result = dao.updatePoint(id, amount);
					jta.setText(result == CustomerDao.SUCCESS ? "����Ʈ�θ� ���� ����" : "���� ����");
					txtPoint.setText(String.valueOf(point - amount));
					txtAmount.setText("");
				}
				
			} catch (Exception e1) {
				jta.setText("��ȿ�� ���̵�, ����Ʈ, ���űݾ��� �Է��ϼ���");
				return;
			}

		} else if (e.getSource() == btnBuy) {  // ��ǰ����
			int id;
			int point;
			int amount;
			try {
				
				id = Integer.parseInt(txtId.getText().trim());
				point = Integer.parseInt(txtPoint.getText().trim());
				amount = Integer.parseInt(txtAmount.getText().trim());
				
				if (amount < 0) {
					jta.setText("0���� ū ���� �Է��ϼ���");
					return;
				}
				int result = dao.updateBuy(id, amount);
				jta.setText(result == CustomerDao.SUCCESS ? "��ǰ ���� �� �� ���� ������Ʈ ����" : "���� ����");
				txtPoint.setText(String.valueOf(point + (int)(amount * 0.05)));
				txtAmount.setText("");
			} catch (Exception e1) {
				jta.setText("��ȿ�� ���̵�, ����Ʈ, ���űݾ��� �Է��ϼ���");
				return;
			}		
			
		} else if (e.getSource() == btnLvOut) { // ��޺� ���
			String levelName = comLevel.getSelectedItem().toString();
			
			if (levelName.equals("")) {
				jta.setText("�� ����� �����ϼ���");
				return;
			}
			customers = dao.selectLevel(levelName);
			
			if (customers.isEmpty()) {
				jta.setText("�ش� ����� ���� �����ϴ�");
			} else {
				jta.setText("ID\t��ȭ\t\t�̸�\t����Ʈ\t���Ŵ�����\t������\t�������� ���� �߰� ������ �ݾ�\n");
				jta.append("��������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������\n");
				for (CustomerDto d : customers) {
					jta.append(d.toString());
				}
			}
			
		} else if (e.getSource() == btnAllOut) {  // ��ü ���
			customers = dao.selectAll();
			if (customers.isEmpty()) {
				jta.setText("���Ե� ���� �����ϴ�");
			} else {
				jta.setText("ID\t��ȭ\t\t�̸�\t����Ʈ\t���Ŵ�����\t������\t�������� ���� �߰� ������ �ݾ�\n");
				jta.append("��������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������\n");
				for (CustomerDto d : customers) {
					jta.append(d.toString());
				}
				jta.append("�� " + customers.size() + "��");
			}
		} else if (e.getSource() == btnInsert) {  // ȸ������
			String tel = txtTel.getText().trim();
			String name = txtName.getText().trim();
			
			if (tel.equals("") || name.equals("")) {
				jta.setText("��ȭ��ȣ �Ǵ� �̸��� �Է��ϼ���");
				return;
			}
			
			if (tel.length() != 13) {
				jta.setText("��ȭ��ȣ �Է½� 010-0000-0000 �� �������� �Է��ϼ���");
				return;
			}
			
			int result = dao.insertCustomer(tel, name);
			jta.setText(result == CustomerDao.SUCCESS ? "ȸ������ �����մϴ�. ����Ʈ 1000���� ȸ�����Լ����� �帳�ϴ�" : "���� ����");			
	
		} else if (e.getSource() == btnUpdateTel) {  // ��ȣ ����
			int id;
			try {
				id = Integer.parseInt(txtId.getText().trim());
			} catch (Exception e1) {
				jta.setText("��ȿ���� �ʴ� ���̵� �Է� ���Դϴ�");
				return;
			}
			String tel = txtTel.getText().trim();
			
			if (tel.equals("")) {
				jta.setText("ID, ��ȭ��ȣ�� �Է��ϼ���");
				return;
			}
			
			if (tel.length() != 13) {
				jta.setText("��ȭ��ȣ �Է½� 010-0000-0000 �� �������� �Է��ϼ���");
				return;
			}
			
			int result = dao.updateTel(tel, id);
			jta.setText(result == CustomerDao.SUCCESS ? "��ȭ��ȣ�� �����Ǿ����ϴ�" : "���� ����");

		} else if (e.getSource() == btnDelete) {  // ȸ�� Ż��
			String tel = txtTel.getText().trim();
			
			if (tel.equals("")) {
				jta.setText("��ȭ��ȣ�� �Է��ϼ���");
				return;
			}
			
			if (tel.length() != 13) {
				jta.setText("��ȭ��ȣ �Է½� 010-0000-0000 �� �������� �Է��ϼ���");
				return;
			}
			
			int result = dao.deleteCustomer(tel);
			jta.setText(result == CustomerDao.SUCCESS ? tel + "���� ȸ��Ż�� �Ϸ�Ǿ����ϴ�" : "ȸ��Ż�� ����");
			
		} else if (e.getSource() == btnExit) {  // ������
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}
	public static void main(String[] args) {
		new CustomerGUI("���۸��� ����");
	}
}
