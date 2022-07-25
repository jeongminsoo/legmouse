package com.lec.ch19.dao;

import org.apache.ibatis.annotations.Mapper;

import com.lec.ch19.dto.Member;

@Mapper
public interface MemberDao {

	public int idCheck(String mid);
	
	public Member getmember(String mid);
	
	public Member loginCheck(String mid, String mpw);
	
	public int join(Member member);
	
	public int modify(Member member);
}
