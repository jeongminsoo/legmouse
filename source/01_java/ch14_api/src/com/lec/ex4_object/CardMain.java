package com.lec.ex4_object;

import java.util.Random;

public class CardMain {

	public static void main(String[] args) {
		
		Card[] cards = { new Card('��', 1),
						 new Card('��', 2),
						 new Card('��', 3),
						 new Card('��', 4)};
		
		for (Card c : cards) {
			System.out.println(c);
		}
		
		Random random = new Random();
		
		char[] kinds = {'��', '��', '��', '��'};
		
		Card comCard = new Card(kinds[random.nextInt(4)], random.nextInt(13) + 1);
		System.out.println("��ǻ�Ͱ� �����ϰ� ������ ī�� : " + comCard);
		
		for (int i = 0; i < cards.length; i++) {
			if (cards[i].equals(comCard)) {
				System.out.println(i + "��° ī��� ��ġ");
			} else {
				System.out.println(i + "��° ī��� ����ġ");
			}
		}
		
		if (cards[3].equals(comCard)) {
			System.out.println("�� ī��� ��ġ�մϴ�");
		} else {
			System.out.println("�� ī��� ����ġ�մϴ�");
		}
		
	}
}
