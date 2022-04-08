package com.lec.ex2_map;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

public class FriendMap {

	public static void main(String[] args) {
		
		HashMap<String, Friend> hash = new HashMap<String, Friend>();
		
		hash.put("010-9999-9999", new Friend("홍길동", "010-9999-9999"));
		hash.put("010-9999-8888", new Friend("김길동", "010-9999-8888"));
		hash.put("010-9999-7777", new Friend("신길동", "010-9999-7777"));
		hash.put("010-9999-6666", new Friend("마길동", "010-9999-6666"));
		hash.put("010-9999-5555", new Friend("윤길동", "010-9999-5555", new Date(95, 11, 12)));
		
		Iterator<String> iter = hash.keySet().iterator();
		
		while(iter.hasNext()) {
			String key = iter.next();
			System.out.println(key + "의 데이터는 " + hash.get(key));
		}
	}
}
