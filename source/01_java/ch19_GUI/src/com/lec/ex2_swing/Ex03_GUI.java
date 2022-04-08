package com.lec.ex2_swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


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
		jBtn = new JButton("출력", icon);
		jta = new JTextArea(5, 30);
		scrollPaen = new JScrollPane(jta);
		jp.add(new JLabel("이  름", (int)CENTER_ALIGNMENT));
		jp.add(txtName);
		jp.add(new JLabel("전  화", (int)CENTER_ALIGNMENT));
		jp.add(txtTel);
		jp.add(new JLabel("나  이", (int)CENTER_ALIGNMENT));
		jp.add(txtAge);
		contenPane.add(jp, BorderLayout.NORTH);
		contenPane.add(jBtn, BorderLayout.CENTER);
		contenPane.add(scrollPaen, BorderLayout.SOUTH);
		setVisible(true);
		setBounds(200, 100, 400, 300);
		
		
	}
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		new Ex03_GUI("last Ex");
	}
}
