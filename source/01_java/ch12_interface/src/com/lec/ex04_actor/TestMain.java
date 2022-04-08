package com.lec.ex04_actor;

public class TestMain {

	public static void main(String[] args) {
		
		Actor park = new Actor("��� �ں���");
		
		park.canCatchCriminal();
		park.canSearch();
		park.makePizza();
		park.makeSpaghetti();
		park.saveMan();
		park.outFire();
		
		IChef chef = new Actor("�丮��");
		
		chef.makePizza();
		chef.makeSpaghetti();
		
		IFireFighter fire = new Actor("�ҹ��");
		
		fire.saveMan();
		fire.outFire();
		
		IPoliceMen police = new Actor("������");
		
		police.canCatchCriminal();
		police.canSearch();
		
	}
}
