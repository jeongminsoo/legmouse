package com.lec.ex6_member;

public class MemberTestMain {

	public static void main(String[] args) {
		
		Member member1 = new Member("aaa", "xxx", "ȫ�浿", "hong@company.com", "���� ������", "2000-01-01", 'm');
		
		System.out.println(member1.infoString());
		
		
		Member member2 = new Member();
		
		member2.setId("jeong");
		member2.setPw("minsoo");
		member2.setName("���μ�");
		member2.setEmail("leekr44@naver.com");
		member2.setAddress("��⵵ �Ⱦ��");
		member2.setBirth("1992-03-22");
		member2.setGender('m');
		
		System.out.println(member2.infoString());
	}
}
