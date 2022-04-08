package com.lec.ex2_swing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyFrame extends JFrame implements ActionListener {

	private ArrayList<Person> people;
	
	private Container contenPane;
	private JPanel jp1;
	private JPanel jp2;
	private JTextField txtName;
	private JTextField txtTel;
	private JTextField txtAge;
	private JButton btnIn;
	private JButton btnOut;
	private ImageIcon icon1;
	private ImageIcon icon2;
	private int cnt;

	public MyFrame(String title) {
		super(title);
		people = new ArrayList<Person>();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contenPane = getContentPane();
		jp1 = new JPanel(new GridLayout(3, 2));
		jp2 = new JPanel();
		txtName = new JTextField();
		txtTel = new JTextField();
		txtAge = new JTextField();
		icon1 = new ImageIcon("icon/join.png");
		btnIn = new JButton("입력", icon1);
		icon2 = new ImageIcon("icon/output.png");
		btnOut = new JButton("출력", icon2);
		
		jp1.add(new JLabel("이  름", (int) CENTER_ALIGNMENT));
		jp1.add(txtName);
		jp1.add(new JLabel("전  화", (int) CENTER_ALIGNMENT));
		jp1.add(txtTel);
		jp1.add(new JLabel("나  이", (int) CENTER_ALIGNMENT));
		jp1.add(txtAge);
		jp2.add(btnIn);
		jp2.add(btnOut);
		
		contenPane.add(jp1, BorderLayout.NORTH);
		contenPane.add(jp2, BorderLayout.CENTER);
		
		setVisible(true);
		pack();
		setLocation(200, 100);

		btnIn.addActionListener(this);
		btnOut.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnIn) {
			String name = txtName.getText().trim();
			String tel = txtTel.getText().trim();
			
			if (name.equals("") || tel.equals("")) {
				System.out.println("이름과 전화번호는 필수 입력 사항입니다.");
				return;
			}
			
			if (tel.indexOf("-") == tel.lastIndexOf("-") || tel.indexOf("-") == -1 || tel.indexOf("-") < 2
					|| tel.lastIndexOf("-") > 10) {
				System.out.println("전화번호 형식을 확인해주세요.");
				return;
			}
			int age = 0;
			
			try {
				
				age = Integer.parseInt(txtAge.getText());
				
				if (age <= 0 || age > 150) {
					System.out.println("유효하지 않는 나이이므로 0살");
					age = 0;
				}
				
			} catch (Exception e1) {
				System.out.println("유효하지 않는 나이를 입력하였습니다.");
			}

			System.out.println(++cnt + "명 입력됨");
			
			people.add(new Person(name, tel, age));

			txtName.setText("");
			txtTel.setText("");
			txtAge.setText("");
		} else if (e.getSource() == btnOut) {
			
			OutputStream os = null;

			try {

				os = new FileOutputStream("src/com/lec/ex2_swing/person.txt", true);

				for (Person p : people) {
					System.out.print(p);
					os.write(p.toString().getBytes());
				}
					
			} catch (IOException e1) {
				System.out.println(e1.getMessage());
			} finally {
				try {
					if (os != null) {
						os.close();
					}
				} catch (IOException e1) {
				}
			}
		}
	}

	public static void main(String[] args) {

		new MyFrame("입출력 시스템");
	}

}
