package com.lec.ex2_swing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Ex03_GUI extends JFrame implements ActionListener{

	private Container contenPane;
	private JPanel jp;
	private JTextField txtName;
	private JTextField txtTel;
	private JTextField txtAge;
	private JButton jBtn;
	private ImageIcon icon;
	private JTextArea jta;
	private JScrollPane scrollPaen;
	private int cnt;
	
	public Ex03_GUI(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contenPane = getContentPane();
		jp = new JPanel(new GridLayout(3,2));
		// jp.setLayout(new GridLayout(3,2));
		txtName = new JTextField();
		txtTel = new JTextField();
		txtAge = new JTextField();
		icon = new ImageIcon("icon/output.png");
		jBtn = new JButton("���", icon);
		jta = new JTextArea(5, 30);
		scrollPaen = new JScrollPane(jta);
		jp.add(new JLabel("��  ��", (int)CENTER_ALIGNMENT));
		jp.add(txtName);
		jp.add(new JLabel("��  ȭ", (int)CENTER_ALIGNMENT));
		jp.add(txtTel);
		jp.add(new JLabel("��  ��", (int)CENTER_ALIGNMENT));
		jp.add(txtAge);
		contenPane.add(jp, BorderLayout.NORTH);
		contenPane.add(jBtn, BorderLayout.CENTER);
		contenPane.add(scrollPaen, BorderLayout.SOUTH);
		setVisible(true);
		setBounds(200, 100, 400, 300);
		
		jBtn.addActionListener(this);
	}
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jBtn) {
			String name  = txtName.getText().trim();
			String tel = txtTel.getText().trim();
			if (name.equals("") || tel.equals("")) {
				System.out.println("�̸��� ��ȭ��ȣ�� �ʼ� �Է� �����Դϴ�.");
				return;
			}
			if (tel.indexOf("-") == tel.lastIndexOf("-") || tel.indexOf("-") == -1
					|| tel.indexOf("-") < 2 || tel.lastIndexOf("-") > 10) {
				System.out.println("��ȭ��ȣ ������ Ȯ�����ּ���.");
				return;
			}
			
			int age = 0;
			try {
				age = Integer.parseInt(txtAge.getText());
				if (age <= 0 || age > 150) {
					System.out.println("��ȿ���� �ʴ� �����̹Ƿ� 0��");
					age = 0;
				}
			} catch (Exception e1) {
				System.out.println("��ȿ���� �ʴ� ���̸� �Է��Ͽ����ϴ�.");
			}
			System.out.println(++cnt + "�� �Էµ�");
			if (cnt == 1) {
				jta.setText("�̸�\t��ȭ\t����\n");
			}
			jta.append(name + "\t" + tel + "\t " + age + "\n");
			txtName.setText("");
			txtTel.setText("");
			txtAge.setText("");
		}
		
	}

	public static void main(String[] args) {
		new Ex03_GUI("last Ex");
	}
}
