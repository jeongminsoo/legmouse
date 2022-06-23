package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.dao.AdminDao;

public class ALoginService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String aid = request.getParameter("aid");
		String apw = request.getParameter("apw");
		
		AdminDao dao = AdminDao.getInstance();
		
		int result = dao.loginChkAdmin(aid, apw);
		
		if (result == AdminDao.SUCCESS) {
			HttpSession session = request.getSession();
			session.setAttribute("admin", dao.getAdmin(aid));
		}
		request.setAttribute("aloginResult", result);
	}

}
