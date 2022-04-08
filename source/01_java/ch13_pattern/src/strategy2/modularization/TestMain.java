package strategy2.modularization;

import strategy2.interfaces.FuelHybrid;
import strategy2.interfaces.Km20;

public class TestMain {

	public static void main(String[] args) {
		
		Car genesis = new Genesis();
		Car sonata = new Sonata();
		Car accent = new Accent();
		
		Car[] car = {genesis, sonata, accent};
		
		for (Car c : car) {
			c.shape();
			c.infoPrint();
			c.drive();
		}
		System.out.println("�ҳ�Ÿ�� ���̺긮��� ��ü�ϰ� ���� 20Km/L �� ��ü�ϼ���.");
		
		sonata.setFuel(new FuelHybrid());
		sonata.setKm(new Km20());
		
		for (Car c : car) {
			c.shape();
			c.infoPrint();
			c.drive();
		}
	}
}
