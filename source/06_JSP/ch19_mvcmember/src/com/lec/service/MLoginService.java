package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
<<<<<<< HEAD
import javax.servlet.http.HttpSession;
=======
>>>>>>> 6b1a7f090987a8a03dae707422fbdb6d5396b8bf

import com.lec.dao.MemberDao;
import com.lec.dto.MemberDto;

public class MLoginService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		
		MemberDao dao = MemberDao.getInstance();
<<<<<<< HEAD
		
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
		
=======
		int result = dao.loginChk(mid, mpw);
		
		if (result == MemberDao.SUCCESS) {
			MemberDto member = dao.getMember(mid);
			request.setAttribute("member", member);
		}
>>>>>>> 6b1a7f090987a8a03dae707422fbdb6d5396b8bf
		request.setAttribute("loginResult", result);
	}

}
