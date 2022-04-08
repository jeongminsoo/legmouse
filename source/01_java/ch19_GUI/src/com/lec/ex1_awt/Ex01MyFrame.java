package com.lec.ex1_awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;

public class Ex01MyFrame extends Frame {

	private Button btn;
	private Button btn1;
	
	public Ex01MyFrame(String title) {
		super(title);
		btn = new Button("버튼");
		btn1 = new Button("그냥 버튼");
		add(btn, BorderLayout.NORTH);
		add(btn1, BorderLayout.CENTER);
//		pack();
		setSize(new Dimension(300, 200));
		setVisible(true);
		setLocation(100, 50);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
		
		setVisible(false);
		dispose();
		System.exit(0);
	}
	
	public static void main(String[] args) {
		new Ex01MyFrame("first GUI");
	}
}
