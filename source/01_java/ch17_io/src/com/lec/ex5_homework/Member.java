package com.lec.ex5_homework;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Member {

	private String name;
	private String tel;
	private Date birth;
	private String address;
	
	public Member() {
	}
	
	public Member(String name, String tel, Date birth, String address) {
		this.name = name;
		this.tel = tel;
		this.birth = birth;
		this.address = address;
	}
	
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		return name + " " + tel + " " + sdf.format(birth) + " " + address + "\n";
	}
	
	public Date getBirth() {
		return birth;
	}
}
