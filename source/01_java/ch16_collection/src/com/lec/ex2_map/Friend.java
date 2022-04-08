package com.lec.ex2_map;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Friend {

	private String name;
	private String tel;
	private Date birth;
	
	public Friend(String name, String tel) {
		this.name = name;
		this.tel = tel;
	}

	public Friend(String name, String tel, Date birth) {
		this.name = name;
		this.tel = tel;
		this.birth = birth;
	}
	
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat(", ���� : MM�� dd��");
		String msg = name + "�� ����ó : " + tel;
		if (birth != null) {
			msg += sdf.format(birth);
		}
		return msg;
	}
	
	
	
}
