package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.dao.MemberDao;

public class MIdChkService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String mid = request.getParameter("mid");
		MemberDao dao = MemberDao.getInstance();
		
		int result = dao.idChk(mid);
		
		if (result == MemberDao.ID_EXISTENT) {
			request.setAttribute("idChkResult", "중복된 아이디입니다");
		} else {
			request.setAttribute("idChkResult", "사용 가능한 아이디입니다");
		}
	}

}
