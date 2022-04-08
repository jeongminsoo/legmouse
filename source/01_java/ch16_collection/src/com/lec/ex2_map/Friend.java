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
		SimpleDateFormat sdf = new SimpleDateFormat(", 积老 : MM岿 dd老");
		String msg = name + "狼 楷遏贸 : " + tel;
		if (birth != null) {
			msg += sdf.format(birth);
		}
		return msg;
	}
	
	
	
}
