package com.lec.ex2_swing;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Ex01_Thrusday extends JFrame implements ActionListener{

	private JPanel panel;  // 받아온 컨테이너를 저장
	// private Container contenPane;  
	private JButton jbtn;
	private JLabel jlbl;
	
	public Ex01_Thrusday(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);  // x버튼 클릭 시 종료
		panel = (JPanel) getContentPane();
		panel.setLayout(new FlowLayout());
		jbtn = new JButton("EXIT");
		jlbl = new JLabel("즐거운 목요일", (int)CENTER_ALIGNMENT);
		panel.add(jlbl);
		jlbl.setPreferredSize(new Dimension(150, 200));
		panel.add(jbtn);
		jbtn.setPreferredSize(new Dimension(200, 200));
		setVisible(true);
		setSize(new Dimension(400, 250));
		setLocation(200, 100);
		
		jbtn.addActionListener(this);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jbtn) {
			setVisible(false);  
			dispose();		    
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		new Ex01_Thrusday("title");
	}
	

}
