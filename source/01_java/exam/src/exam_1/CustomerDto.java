package exam_1;

import java.text.DecimalFormat;

public class CustomerDto {

	private String phone;
	private String name;
	private int point;
	
	
	public CustomerDto() {
	}

	public CustomerDto(String phone, String name, int point) {
		this.phone = phone;
		this.name = name;
		this.point = point;
	}

	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("###,###");
		return phone + "\t\t" + name + "\t" + df.format(point) + "\n";
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


	public int getPoint() {
		return point;
	}


	public void setPoint(int point) {
		this.point = point;
	}
	
	
}
