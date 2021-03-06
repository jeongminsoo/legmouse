package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.dao.BoardDao;

public class BDeleteService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		int bid = Integer.parseInt(request.getParameter("bid"));
		
		BoardDao dao = BoardDao.getInstance();
		
		
		int result = dao.deleteBoard(bid);
		request.setAttribute("deleteResult", result);

	}

}
