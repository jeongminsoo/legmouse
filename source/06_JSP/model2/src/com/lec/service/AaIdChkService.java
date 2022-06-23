package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.dao.AdminDao;

public class AaIdChkService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String aid = request.getParameter("aid");
		
		AdminDao dao = AdminDao.getInstance();
		int result = dao.aidChk(aid);
		if (result == AdminDao.AID_EXISTENT) {
			request.setAttribute("aidChkResult", "중복된 아이디입니다");
		} else {
			request.setAttribute("aidChkResult", "사용 가능한 아이디입니다");
		}
	}

}
