package com.lec.ex06_volume;

public class TV implements IVolume{

	private static final byte TV_MAX_VOLUME = 50;
	private static final byte TV_MIN_VOLUME = 0;
	private int volumeLevel;
	
	public TV() {	
	}
	
	public TV(int volumeLevel) {
		this.volumeLevel = volumeLevel;
	}
	
	@Override
	public void volumeUp() {
		if (volumeLevel < TV_MAX_VOLUME) {
			volumeLevel++;
			System.out.println("TV ������ 1 �÷Ƚ��ϴ�. ���� ���� : " + volumeLevel);
		} else {
			System.out.println("TV ������ �ִ�ġ�Դϴ�.");
		}
	}

	@Override
	public void volumeUp(int level) {
		if (volumeLevel + level <= TV_MAX_VOLUME) {
			volumeLevel += level;
			System.out.println("TV ������ " + level + " �÷Ƚ��ϴ�. ���� ���� : " + volumeLevel);
		} else {
			int temp = TV_MAX_VOLUME - volumeLevel;
			volumeLevel = TV_MAX_VOLUME;
			System.out.println("TV ������ " + temp + " �÷Ƚ��ϴ�. ���� ���� : " + volumeLevel);
		}
		
	}

	@Override
	public void volumeDown() {
		if (volumeLevel > 0) {
			volumeLevel--;
			System.out.println("TV ������ 1 ���Ƚ��ϴ�. ���� ���� : " + volumeLevel);
		} else {
			System.out.println("TV ������ �ּ�ġ�Դϴ�.");
		}
	}

	@Override
	public void volumeDown(int level) {
		if (volumeLevel - level >= TV_MIN_VOLUME) {
			volumeLevel -= level;
			System.out.println("TV ������ " + level + " ���Ƚ��ϴ�. ���� ���� : " + volumeLevel);
		} else {
			int temp = volumeLevel;
			volumeLevel = TV_MIN_VOLUME;
			System.out.println("TV ������ " + temp + " ���Ƚ��ϴ�. ���� ���� : " + volumeLevel);
		}
	}

}
