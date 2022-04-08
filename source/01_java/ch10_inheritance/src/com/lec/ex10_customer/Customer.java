package com.lec.ex10_customer;

public class Customer extends Person {

	private String address;
	private int sum; // �����ݾ�
	private int point;  // 5%����
	private String date; // �����
	private boolean vip; // true = vip, false = �Ϲ�
	
	public Customer(String name, String tel, String address,String date) {
		super(name, tel);
		this.address = address;
		this.date = date;
		point = 1000; // �ű�ȸ������ 1000����Ʈ ����
		System.out.println(name + "�� �����մϴ�. 1000����Ʈ�� ������ �帳�ϴ�.");
	}
	public void buy(int price) {
		sum += price;
		int tempPoint = (int)(price * 0.05);
		point += tempPoint;
		System.out.println(getName() +"�� �����մϴ�.  ����Ʈ " + tempPoint + "�� �߰��Ǿ� �� ����Ʈ " + point + "�Դϴ�.");
		if (sum >= 1000000 && vip == false) {
			vip = true;
			System.out.println(getName() + "�� VIP ����� �Ǿ����ϴ�.");
		}
	}
	@Override // @ : ������̼�
	public String infoString() {
		return super.infoString() + "[�ּ�]" + address + "[�����ݾ�]" + sum + "[����Ʈ]" + point;
	}
}
