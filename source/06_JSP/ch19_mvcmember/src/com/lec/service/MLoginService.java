package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.dao.MemberDao;
import com.lec.dto.MemberDto;

public class MLoginService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		
		MemberDao dao = MemberDao.getInstance();
		
		int result;
		
		if (!mid.equals("") && !mpw.equals("")) {
			result = dao.loginChk(mid, mpw);
			if (result == MemberDao.SUCCESS) {
				MemberDto member = dao.getMember(mid);
				HttpSession session = request.getSession();
				session.setAttribute("member", member);
				session.removeAttribute("id");
			}
		} else {
			result = MemberDao.FAIL;
		}
		
		request.setAttribute("loginResult", result);
	}

}
