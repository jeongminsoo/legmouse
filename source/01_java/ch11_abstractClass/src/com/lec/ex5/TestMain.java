package com.lec.ex5;

public class TestMain {

	public static void main(String[] args) {
		
		Employee[] sawon = { new SalaryEmployee("ȫ�浿", 24000000),
							 new SalaryEmployee("������", 70000000),
							 new SalaryEmployee("�����", 12000000),
							 new HourlyEmployee("ȫ�汸", 100, 7000),
							 new HourlyEmployee("�����", 120, 8000)
							 };
		
		for (Employee emp : sawon) {
			System.out.println("~ ~ ~ ���޸��� ~ ~ ~");
			System.out.println("�� �� : " + emp.getName());
			System.out.println("�� �� : " + emp.computePay());
			
			int incen = emp.computeIncentive();
			if (incen != 0) {
				System.out.println("�� �� : " + incen);
			}
		}
	}
}
