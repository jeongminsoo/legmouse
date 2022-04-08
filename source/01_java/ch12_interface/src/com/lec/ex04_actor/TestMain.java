package com.lec.ex04_actor;

public class TestMain {

	public static void main(String[] args) {
		
		Actor park = new Actor("배우 박보검");
		
		park.canCatchCriminal();
		park.canSearch();
		park.makePizza();
		park.makeSpaghetti();
		park.saveMan();
		park.outFire();
		
		IChef chef = new Actor("요리사");
		
		chef.makePizza();
		chef.makeSpaghetti();
		
		IFireFighter fire = new Actor("소방관");
		
		fire.saveMan();
		fire.outFire();
		
		IPoliceMen police = new Actor("경찰관");
		
		police.canCatchCriminal();
		police.canSearch();
		
	}
}
