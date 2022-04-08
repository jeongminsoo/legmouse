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
		String msg = String.format("��  �� : %s\n�ڵ��� : %s\n�ּ� : %s\n��  �� : %s\n", name, phone, address, birthday);
		return msg;
	}

	public String getAddress() {
		return address;
	}
	
	
}
