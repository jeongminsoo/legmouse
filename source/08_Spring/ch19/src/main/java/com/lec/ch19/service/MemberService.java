package com.lec.ch19.service;

import javax.servlet.http.HttpSession;

import com.lec.ch19.dto.Member;

public interface MemberService {

	public int idCheck(String mid);
	
	public Member getmember(String mid);
	
	public String loginCheck(String mid, String mpw, HttpSession session);
	
	public int join(Member member);
	
	public int modify(HttpSession session, Member member);
}
