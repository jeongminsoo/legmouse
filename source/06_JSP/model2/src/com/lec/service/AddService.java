package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.dao.AdminDao;

public class AddService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String aid = request.getParameter("aid");
		String apw = request.getParameter("apw");
		String aname = request.getParameter("aname");
		
		AdminDao dao = AdminDao.getInstance();
		int result = dao.addAdmin(aid, apw, aname);
		
		request.setAttribute("addResult", result);

	}

}
