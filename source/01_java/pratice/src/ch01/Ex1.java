package ch01;

public class Ex1 {

	public static void main(String[] args) {
		
		int kor = 80;
		int eng = 80;
		int math = 80;
		
		int total = kor + eng + math;
		double average = total / 3.0;
		
		System.out.println("±¹¾î : " + kor);
		System.out.println("¿µ¾î : " + eng);
		System.out.println("¼öÇÐ : " + math);
		System.out.println("ÃÑÁ¡ : " + total);
		System.out.println("Æò±Õ : " + average);
	}
}
