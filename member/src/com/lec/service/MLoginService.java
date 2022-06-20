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
		
		int result;
		
		if (!mid.equals("") && !mpw.equals("")) {
			MemberDto member = dao.getMember(mid);
			result = dao.joinMember(member);
			if (result == MemberDao.SUCCESS) {
				
				request.setAttribute("member", member);
			}
		} else {
			result = MemberDao.FAIL;
		}
		
		
		request.setAttribute("loginResult", result);
	}

}
