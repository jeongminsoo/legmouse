package com.lec.ex06_volume;

public class TestMain {

	public static void main(String[] args) {
		
		IVolume[] volumes = {new TV(3), new Speaker(5), new TV(10), new Speaker(7)};
		
		for (IVolume v : volumes) {
			v.volumeDown();
			v.volumeDown(20);
			v.volumeUp();
			v.volumeUp(10);
			v.volumeUp(45);
			v.setMute(true);
		}
	}
}
