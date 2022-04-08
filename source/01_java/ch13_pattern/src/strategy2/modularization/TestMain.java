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
		System.out.println("소나타를 하이브리드로 교체하고 연비를 20Km/L 로 교체하세요.");
		
		sonata.setFuel(new FuelHybrid());
		sonata.setKm(new Km20());
		
		for (Car c : car) {
			c.shape();
			c.infoPrint();
			c.drive();
		}
	}
}
