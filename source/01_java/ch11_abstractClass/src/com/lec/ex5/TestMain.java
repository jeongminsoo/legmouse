package com.lec.ex5;

public class TestMain {

	public static void main(String[] args) {
		
		Employee[] sawon = { new SalaryEmployee("홍길동", 24000000),
							 new SalaryEmployee("강동원", 70000000),
							 new SalaryEmployee("김고은", 12000000),
							 new HourlyEmployee("홍길구", 100, 7000),
							 new HourlyEmployee("김길자", 120, 8000)
							 };
		
		for (Employee emp : sawon) {
			System.out.println("~ ~ ~ 월급명세서 ~ ~ ~");
			System.out.println("성 함 : " + emp.getName());
			System.out.println("월 급 : " + emp.computePay());
			
			int incen = emp.computeIncentive();
			if (incen != 0) {
				System.out.println("상 여 : " + incen);
			}
		}
	}
}
