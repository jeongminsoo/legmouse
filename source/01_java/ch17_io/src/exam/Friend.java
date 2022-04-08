package exam;

public class Friend {

	private String name;
	private String phone;
	private String address;
	private String birthday;
	
	public Friend(String name, String phone, String address, String birthday) {
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.birthday = birthday;
	}
	
	@Override
	public String toString() {
		String msg = String.format("이  름 : %s\n핸드폰 : %s\n주소 : %s\n생  일 : %s\n", name, phone, address, birthday);
		return msg;
	}

	public String getAddress() {
		return address;
	}
	
	
}
