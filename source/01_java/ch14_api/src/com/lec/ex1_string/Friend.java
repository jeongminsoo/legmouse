package com.lec.ex1_string;

public class Friend {

	private String name;
	private String phone;
	private String birthday;
	
	public Friend(String name, String phone, String birthday) {
		super();
		this.name = name;
		this.phone = phone;
		this.birthday = birthday;
	}
	
	@Override
	public String toString() {
		return "이  름 : " + name + "\n핸드폰 : " + phone + "\n생  일 : " + birthday;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
}
