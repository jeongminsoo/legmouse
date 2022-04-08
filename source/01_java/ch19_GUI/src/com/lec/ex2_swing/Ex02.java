package com.lec.ex2_swing;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Ex02 extends JFrame implements ActionListener{

	private Container contentPane;
	private ImageIcon icon;
	private JButton jBtn;
	private JTextField jTxtField;
	private Vector<String> items;
	// private String[] item = { "A", "B", "C"};
	private JComboBox<String> jCombo;  // item이 가변적일때는 Vector , 고정적일때는 String 배열
	private JCheckBox jCheck;
	private JLabel jLBlank;
	private JButton jBtnExit;
	
	public Ex02() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		icon = new ImageIcon("icon/write.gif");
		jBtn = new JButton("Button", icon);
		jTxtField = new JTextField(20);
		// jCombo = new JComboBox<String>(item);  // 콤보박스 item 리스트 추가 방법 첫번째 : string배열 (고정)
		items = new Vector<String>();
		items.add("A");
		items.add("B");
		items.add("C");
		jCombo = new JComboBox<String>(items); // 콤보박스 item 리스트 추가 방법 두번째 : vectorr이용 (가변)
		jCheck = new JCheckBox("CheckBox");
		jLBlank = new JLabel("");
		jBtnExit = new JButton("Exit");
		
		contentPane.add(new JLabel("Label"));
		contentPane.add(jBtn);
		contentPane.add(jTxtField);
		contentPane.add(jCombo);
		contentPane.add(jCheck);
		contentPane.add(jLBlank);
		contentPane.add(jBtnExit);
		
		jBtn.setPreferredSize(new Dimension(200, 50));
		jTxtField.setPreferredSize(new Dimension(300, 50));
		jCombo.setPreferredSize(new Dimension(100, 50));
		jCheck.setPreferredSize(new Dimension(100, 50));
		jLBlank.setPreferredSize(new Dimension(200, 50));
		jBtnExit.setPreferredSize(new Dimension(100, 50));
		
		setVisible(true);
		pack();
		setLocation(200, 100);
		
		jBtnExit.addActionListener(this);
		jBtn.addActionListener(this);
		jCombo.addActionListener(this);
		jCheck.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jBtn) {
			String temp = jTxtField.getText().trim().toUpperCase();
			if (temp.equals("")) {
				System.out.println("?");
				return;
			}
			jCombo.addItem(temp);
			jLBlank.setText(jTxtField.getText().trim());
			jTxtField.setText("");
			
		} else if (e.getSource() == jCombo) {
			String temp1 = jCombo.getSelectedItem().toString();  // 선택된 콤보박스 항목
			int no = jCombo.getSelectedIndex();  // 선택된 항목 위치
			jLBlank.setText(no + "번째 " + temp1 + " 선택");
			jCombo.setSelectedItem("A");
		} else if (e.getSource() == jCheck) {
			if (jCheck.isSelected()) {
				jLBlank.setText(jCheck.getText());
			} else {
				jLBlank.setText("");
			}
		} else if (e.getSource() == jBtnExit) {
			setVisible(false);  
			dispose();
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		new Ex02();
	}
}
