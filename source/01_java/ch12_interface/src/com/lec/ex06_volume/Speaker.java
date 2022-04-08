package com.lec.ex06_volume;

public class Speaker implements IVolume{

	private static final byte SPEAKER_MAX_VOLUME = 50;
	private static final byte SPEAKER_MIN_VOLUME = 0;
	private int volumeLevel;
	
	public Speaker() {	
	}
	
	public Speaker(int volumeLevel) {
		this.volumeLevel = volumeLevel;
	}
	
	@Override
	public void volumeUp() {
		if (volumeLevel < SPEAKER_MAX_VOLUME) {
			volumeLevel++;
			System.out.println("����Ŀ ������ 1 �÷Ƚ��ϴ�. ���� ���� : " + volumeLevel);
		} else {
			System.out.println("����Ŀ ������ �ִ�ġ�Դϴ�.");
		}
	}

	@Override
	public void volumeUp(int level) {
		if (volumeLevel + level <= SPEAKER_MAX_VOLUME) {
			volumeLevel += level;
			System.out.println("����Ŀ ������ " + level + " �÷Ƚ��ϴ�. ���� ���� : " + volumeLevel);
		} else {
			int temp = SPEAKER_MAX_VOLUME - volumeLevel;
			volumeLevel = SPEAKER_MAX_VOLUME;
			System.out.println("����Ŀ ������ " + temp + " �÷Ƚ��ϴ�. ���� ���� : " + volumeLevel);
		}
		
	}

	@Override
	public void volumeDown() {
		if (volumeLevel > 0) {
			volumeLevel--;
			System.out.println("����Ŀ ������ 1 ���Ƚ��ϴ�. ���� ���� : " + volumeLevel);
		} else {
			System.out.println("����Ŀ ������ �ּ�ġ�Դϴ�.");
		}
	}

	@Override
	public void volumeDown(int level) {
		if (volumeLevel - level >= SPEAKER_MIN_VOLUME) {
			volumeLevel -= level;
			System.out.println("����Ŀ ������ " + level + " ���Ƚ��ϴ�. ���� ���� : " + volumeLevel);
		} else {
			int temp = volumeLevel;
			volumeLevel = SPEAKER_MIN_VOLUME;
			System.out.println("����Ŀ ������ " + temp + " ���Ƚ��ϴ�. ���� ���� : " + volumeLevel);
		}
	}

}
