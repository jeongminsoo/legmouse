package com.lec.ex3_exceptionex;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Friend {

	private String name;
	private String tel;
	private Date enterDate;
	
	public Friend(String name) {
		this.name = name;
		enterDate = new Date();
	}
	
	public Friend(String name, String tel) {
		this.name = name;
		this.tel = tel;
		enterDate = new Date();
	}
	@Override
	public String toString() {
		String telPost;
		if (tel != null) {
			String post = tel.substring(tel.lastIndexOf('-') + 1);
			telPost = "***-****-" + post;
		} else {
			telPost = "없음";
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yy년M월dd일 친구됨");
		return "[이름]" + name + " [전화]" + telPost + " [입력일]" + sdf.format(enterDate);
	}
}
