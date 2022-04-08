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
			System.out.println("스피커 볼륨을 1 올렸습니다. 현재 볼륨 : " + volumeLevel);
		} else {
			System.out.println("스피커 볼륨이 최대치입니다.");
		}
	}

	@Override
	public void volumeUp(int level) {
		if (volumeLevel + level <= SPEAKER_MAX_VOLUME) {
			volumeLevel += level;
			System.out.println("스피커 볼륨을 " + level + " 올렸습니다. 현재 볼륨 : " + volumeLevel);
		} else {
			int temp = SPEAKER_MAX_VOLUME - volumeLevel;
			volumeLevel = SPEAKER_MAX_VOLUME;
			System.out.println("스피커 볼륨을 " + temp + " 올렸습니다. 현재 볼륨 : " + volumeLevel);
		}
		
	}

	@Override
	public void volumeDown() {
		if (volumeLevel > 0) {
			volumeLevel--;
			System.out.println("스피커 볼륨을 1 내렸습니다. 현재 볼륨 : " + volumeLevel);
		} else {
			System.out.println("스피커 볼륨이 최소치입니다.");
		}
	}

	@Override
	public void volumeDown(int level) {
		if (volumeLevel - level >= SPEAKER_MIN_VOLUME) {
			volumeLevel -= level;
			System.out.println("스피커 볼륨을 " + level + " 내렸습니다. 현재 볼륨 : " + volumeLevel);
		} else {
			int temp = volumeLevel;
			volumeLevel = SPEAKER_MIN_VOLUME;
			System.out.println("스피커 볼륨을 " + temp + " 내렸습니다. 현재 볼륨 : " + volumeLevel);
		}
	}

}
