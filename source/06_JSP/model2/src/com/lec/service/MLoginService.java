package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.dao.MemberDao;

public class MLoginService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		MemberDao dao = MemberDao.getInstance();
		int result = dao.loginChkMember(mid, mpw);
		
		if (result == MemberDao.SUCCESS) {
			HttpSession session = request.getSession();
			session.setAttribute("member", dao.getMember(mid));
		}
		request.setAttribute("memberLoginResult", result);
	}

}
