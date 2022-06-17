package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.dao.BoardDao;
import com.lec.dto.BoardDto;

public class BContentService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int bid = Integer.parseInt(request.getParameter("bid"));
		
		BoardDao dao = BoardDao.getInstance();
		BoardDto dto = dao.contentView(bid);
		
		
		request.setAttribute("content", dto);
	}

}
