package com.lec.ex6_member;

public class MemberTestMain {

	public static void main(String[] args) {
		
		Member member1 = new Member("aaa", "xxx", "홍길동", "hong@company.com", "서울 강남구", "2000-01-01", 'm');
		
		System.out.println(member1.infoString());
		
		
		Member member2 = new Member();
		
		member2.setId("jeong");
		member2.setPw("minsoo");
		member2.setName("정민수");
		member2.setEmail("leekr44@naver.com");
		member2.setAddress("경기도 안양시");
		member2.setBirth("1992-03-22");
		member2.setGender('m');
		
		System.out.println(member2.infoString());
	}
}
