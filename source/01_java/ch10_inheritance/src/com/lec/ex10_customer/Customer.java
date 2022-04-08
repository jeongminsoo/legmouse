package com.lec.ex10_customer;

public class Customer extends Person {

	private String address;
	private int sum; // 누적금액
	private int point;  // 5%적립
	private String date; // 기념일
	private boolean vip; // true = vip, false = 일반
	
	public Customer(String name, String tel, String address,String date) {
		super(name, tel);
		this.address = address;
		this.date = date;
		point = 1000; // 신규회원가입 1000포인트 지급
		System.out.println(name + "님 감사합니다. 1000포인트를 선물로 드립니다.");
	}
	public void buy(int price) {
		sum += price;
		int tempPoint = (int)(price * 0.05);
		point += tempPoint;
		System.out.println(getName() +"님 감사합니다.  포인트 " + tempPoint + "가 추가되어 총 포인트 " + point + "입니다.");
		if (sum >= 1000000 && vip == false) {
			vip = true;
			System.out.println(getName() + "님 VIP 등급이 되었습니다.");
		}
	}
	@Override // @ : 어노테이션
	public String infoString() {
		return super.infoString() + "[주소]" + address + "[누적금액]" + sum + "[포인트]" + point;
	}
}
