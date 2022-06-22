package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.dao.MemberDao;

public class IdConfirmService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String mId = request.getParameter("mId");
		MemberDao dao = MemberDao.getInstance();
		int result = dao.idChk(mId);
		
		if (result == MemberDao.ID_EXISTENT) {
			request.setAttribute("idConfirmResult", "중복된 ID입니다");
		} else {
			request.setAttribute("idConfirmResult", "사용 가능한 ID입니다");
		}
	}

}
