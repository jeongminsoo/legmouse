package com.lec.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.dao.AdminDao;
import com.lec.dao.MemberDao;
import com.lec.dto.MemberDto;

public class AMemberListService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String pageNum = request.getParameter("pageNum");
		if (pageNum.equals("")) {
			pageNum = "1";
		}
		final int PAGESIZE = 3;
		final int BLOCKSIZE = 5;
		
		int currentPage = Integer.parseInt(pageNum);
		int start = (currentPage - 1) * PAGESIZE + 1;
		int end = start + PAGESIZE - 1;
		
		AdminDao dao = AdminDao.getInstance();
		ArrayList<MemberDto> members = dao.memberList(start, end);
		
		MemberDao mdao = MemberDao.getInstance();
		int mCnt = mdao.countMember();
		int pageCnt = (int) Math.ceil((double)mCnt / PAGESIZE);
		int startPage = ((currentPage - 1) / BLOCKSIZE) * BLOCKSIZE + 1;
		int endPage = startPage + BLOCKSIZE - 1;
		
		request.setAttribute("members", members);
		request.setAttribute("pageCnt", pageCnt);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("BLOCKSIZE", BLOCKSIZE);
	}

}
