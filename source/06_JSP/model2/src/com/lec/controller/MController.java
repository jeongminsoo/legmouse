package com.lec.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.service.MEmailChkService;
import com.lec.service.MIdChkService;
import com.lec.service.MJoinService;
import com.lec.service.Service;


@WebServlet("*.do")
public class MController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		actionDo(request, response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		String viewPage = null;
		Service service = null;
		
		if (com.equals("/join_view.do")) {
			viewPage = "mvc_member/join.jsp";
		} else if (com.equals("/join.do")) {
			service = new MJoinService();
			service.execute(request, response);
			viewPage = "login_view.do";
		} else if (com.equals("/login_view.do")) {
			viewPage = "mvc_member/login.jsp";
		} else if (com.equals("/idChk.do")) {
			service = new MIdChkService();
			service.execute(request, response);
			viewPage = "mvc_member/idChk.jsp";
		} else if (com.equals("/emailChk.do")) {
			service = new MEmailChkService();
			service.execute(request, response);
			viewPage = "mvc_member/emailChk.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(viewPage);
		rd.forward(request, response);
	}

}
