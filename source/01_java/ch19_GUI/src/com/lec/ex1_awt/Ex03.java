package com.lec.ex1_awt;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Ex03 extends Frame implements ActionListener{

	private Panel panel;
	private TextField txtField;
	private Button btnOk;
	private Button btnExit;
	private List list;
	
	
	// ���̾ƿ� ����, ������Ʈ ������ add, setVisible, setSize
	public Ex03() {
		panel = new Panel();
		txtField = new TextField(20);
		btnOk = new Button("OK");
		btnExit = new Button("EXIT");
		list = new List();
		
		
		panel.add(new Label("write"));
		panel.add(txtField);
		panel.add(btnOk);
		panel.add(btnExit);
		add(panel, BorderLayout.NORTH);
		add(list, BorderLayout.CENTER);
		setVisible(true);
		setSize(new Dimension(400, 150));
		setLocation(200, 100);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false);  // �Ⱥ��̰�
				dispose();		    // �ڿ� ����
				System.exit(0);     // ���� ����
			}
		});
		
		btnOk.addActionListener(this);
		btnExit.addActionListener(this);
		
		// �̺�Ʈ �߰� 1. implements ActionListener -> override
		// 		   2. �̺�Ʈ ������ �߰�(V)
		// 		   3. override�� �޼ҵ� �ȿ� ���� �߰�
	}
	
	public Ex03(String title) {
		this();
		setTitle(title);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnOk) { // Ok��ư Ŭ���� �����ϴ� ���� : txtField�� �ؽ�Ʈ�� list�� �߰�
			list.add(txtField.getText());
			txtField.setText("");
		} else if(e.getSource() == btnExit) {
			setVisible(false);  
			dispose();		    
			System.exit(0);     
		}
		
	}
	
	public static void main(String[] args) {
		new  Ex03();
	}

}
