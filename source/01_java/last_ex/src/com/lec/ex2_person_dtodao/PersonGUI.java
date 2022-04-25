package com.lec.ex2_person_dtodao;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PersonGUI extends JFrame implements ActionListener{

	private Container contanPane;
	private JPanel jpanel1;
	private JPanel jpanel2;
	private JTextField txtName;
	private JTextField txtKor;
	private JTextField txtEng;
	private JTextField txtMat;
	private JComboBox comJob;
	private ImageIcon icon1;
	private ImageIcon icon2;
	private ImageIcon icon3;
	private ImageIcon icon4;
	private JButton btnInput;
	private JButton btnSearch;
	private JButton btnOutput;
	private JButton btnExit;
	private JScrollPane scrollPane;
	private JTextArea jta;

	private PersonDao dao = PersonDao.getInstance();
	private ArrayList<PersonDto> person;
	private Vector<String> jnames;
	
	public PersonGUI(String title) {
		super(title);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contanPane = getContentPane();
		contanPane.setLayout(new FlowLayout());
		jpanel1 = new JPanel(new GridLayout(5, 2));
		jpanel2 = new JPanel();
		txtName = new JTextField(20);
		txtKor = new JTextField(20);
		txtEng = new JTextField(20);
		txtMat = new JTextField(20);
		jnames = dao.jnameList();
		comJob = new JComboBox<String>(jnames);
		icon1 = new ImageIcon("icon/join.png");
		btnInput = new JButton("�Է�", icon1);
		icon2 = new ImageIcon("icon/search.png");
		btnSearch = new JButton("������ȸ", icon2);
		icon3 = new ImageIcon("icon/output.png");
		btnOutput = new JButton("��ü���", icon3);
		icon4 = new ImageIcon("icon/exit.png");
		btnExit = new JButton("����", icon4);
		btnInput.setPreferredSize(new Dimension(150, 50));
		btnSearch.setPreferredSize(new Dimension(150, 50));
		btnOutput.setPreferredSize(new Dimension(150, 50));
		btnExit.setPreferredSize(new Dimension(150, 50));
		jta = new JTextArea(10, 60);
		scrollPane = new JScrollPane(jta);
		
		jpanel1.add(new JLabel("�̸�", (int)CENTER_ALIGNMENT));
		jpanel1.add(txtName);
		jpanel1.add(new JLabel("����", (int)CENTER_ALIGNMENT));
		jpanel1.add(comJob);
		jpanel1.add(new JLabel("����", (int)CENTER_ALIGNMENT));
		jpanel1.add(txtKor);
		jpanel1.add(new JLabel("����", (int)CENTER_ALIGNMENT));
		jpanel1.add(txtEng);
		jpanel1.add(new JLabel("����", (int)CENTER_ALIGNMENT));
		jpanel1.add(txtMat);
		
		jpanel2.add(btnInput);
		jpanel2.add(btnSearch);
		jpanel2.add(btnOutput);
		jpanel2.add(btnExit);
		
		contanPane.add(jpanel1);
		contanPane.add(jpanel2);
		contanPane.add(scrollPane);
		
		setSize(new Dimension(700, 450));
		setVisible(true);
		setLocation(200, 100);
		
		btnInput.addActionListener(this);
		btnSearch.addActionListener(this);
		btnOutput.addActionListener(this);
		btnExit.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnInput) {
			
			String pname = txtName.getText().trim();
			String jname = comJob.getSelectedItem().toString().trim();
			String korStr = txtKor.getText().trim();
			String engStr = txtEng.getText().trim();
			String matStr = txtMat.getText().trim();
			
			
			if (pname.equals("") || jname.equals("") || korStr.equals("") || engStr.equals("") || matStr.equals("")) {
				jta.setText("�̸�, ����, ��, ��, �� ��� �Է��ϼž� �Է� ����");
				return;
			}
			
			int kor = Integer.parseInt(korStr);
			int eng = Integer.parseInt(engStr);
			int mat = Integer.parseInt(matStr);
			
			int result = dao.insertPerson(new PersonDto(pname, jname, kor, eng, mat));
			
			if (result == PersonDao.SUCCESS) {
				jta.setText(pname + "�� �Է¼���");
				txtName.setText("");
				comJob.setSelectedItem("");
				txtKor.setText("");
				txtEng.setText("");
				txtMat.setText("");
			}
			
		} else if (e.getSource() == btnSearch) {
			String jname = comJob.getSelectedItem().toString();
			if (jname.equals("")) {
				jta.setText("���� ���� �� ��ȸ�ϼ���");
				return;
			}
			person = dao.selectJname(jname);
			if (person.size() != 0) {
				jta.setText("���\t�̸�\t����\t����\t����\t����\t����\n");
				for (PersonDto d : person) {
					jta.append(d.toString() + "\n");
				}
			} else {
				jta.setText("�ش� �������� �ο��� �����ϴ�");
			}
			
		} else if (e.getSource() == btnOutput) {
			person = dao.selectAll();
			jta.setText("���\t�̸�\t����\t����\t����\t����\t����\n");
			for (PersonDto d : person) {
				jta.append(d.toString() + "\n");
			}
			
			
		} else if (e.getSource() == btnExit) {
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}
	public static void main(String[] args) {
		new PersonGUI("������ ��������");
	}
}
