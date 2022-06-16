package com.lec.service;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.dao.MemberDao;
import com.lec.dto.MemberDto;

public class MemberJoinService implements Service{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		MemberDao dao = MemberDao.getInstance();
		MemberDto dto = new MemberDto();
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String birthStr = request.getParameter("birth");
		if (!birthStr.equals("") && birthStr != null) {
			Date birth = Date.valueOf(birthStr);
			dto.setBirth(birth);
		}
		dto.setId(id);
		dto.setPw(pw);
		dto.setName(name);
		
		
		int result = dao.joinMember(dto);
		request.setAttribute("result", result);
	}

}
