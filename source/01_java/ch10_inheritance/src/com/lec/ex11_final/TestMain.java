package com.lec.ex11_final;

public class TestMain {

	public static void main(String[] args) {
		
		Animal[] ani = { new Dog(),
						 new Rabbit()};
		
//		ani[0].running();
//		ani[0].running();
//		ani[0].stop();
//		
//		ani[1].running();
//		ani[1].running();
//		ani[1].stop();
		for (Animal a : ani) {
			a.running();
			a.running();
			a.stop();
		}
		
	}
}
