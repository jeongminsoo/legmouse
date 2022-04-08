package com.lec.ex1_list;

import java.util.ArrayList;
import java.util.Date;

import com.lec.ex2_map.Friend;

public class FriendArrayList {

	public static void main(String[] args) {
		
		Friend[] friend = new Friend[5];
		
		friend[0] = new Friend("È«", "010-9999-9999");
		friend[1] = new Friend("±è", "010-9999-8888");
		
		for (int i = 0; i < friend.length; i++) {
			System.out.println(friend[i]);
		}
		
		ArrayList<Friend> friends = new ArrayList<Friend>();
		
		friends.add(new Friend("È«", "010-9999-9999"));
		friends.add(new Friend("±è", "010-9999-8888"));
		
		Friend temp = new Friend("ÀÌ", "010-9999-7777", new Date(95, 11, 12));
		
		friends.add(temp);
		
		for (Friend f : friends) {
			System.out.println(f);
		}
	}
}
