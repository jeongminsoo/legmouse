package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.dao.MemberDao;

public class MEmailChkService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String memail = request.getParameter("memail");
		
		MemberDao dao = MemberDao.getInstance();
		
		int result = dao.emailChk(memail);
		
		if (result == MemberDao.EMAIL_EXISTENT) {
			request.setAttribute("emailChkResult", "중복된 이메일입니다");
		} else {
			request.setAttribute("emailChkResult", "사용 가능한 이메일입니다");
		}

	}

}
