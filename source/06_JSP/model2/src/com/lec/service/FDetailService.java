package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.dao.FileBoardDao;
import com.lec.dto.FileBoardDto;

public class FDetailService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int fid = Integer.parseInt(request.getParameter("fid"));
		
		FileBoardDao dao = FileBoardDao.getInstance();
		FileBoardDto dto = dao.detailFileBoard(fid);
		
		
		request.setAttribute("content", dto);

	}

}
