package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.dao.MemberDao;
import com.lec.dto.MemberDto;

public class MLoginService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		
		MemberDao dao = MemberDao.getInstance();
		int result = dao.loginChk(mid, mpw);
		
		if (result == MemberDao.SUCCESS) {
			MemberDto member = dao.getMember(mid);
			request.setAttribute("member", member);
		}
		request.setAttribute("loginResult", result);
	}

}
