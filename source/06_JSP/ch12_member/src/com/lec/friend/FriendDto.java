package com.lec.friend;

public class FriendDto {

	private int no;
	private String name;
	private String phone;
	
	public FriendDto() {
		
	}
	
	public FriendDto(int number, String name, String phone) {
		this.no = number;
		this.name = name;
		this.phone = phone;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "FriendDto [number=" + no + ", name=" + name + ", phone=" + phone + "]";
	}
	
	
}
