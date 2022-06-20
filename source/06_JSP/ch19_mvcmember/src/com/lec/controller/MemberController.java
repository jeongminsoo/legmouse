package com.lec.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.service.MJoinService;
import com.lec.service.MListService;
import com.lec.service.MLoginService;
import com.lec.service.MLogoutService;
import com.lec.service.MModifyService;
import com.lec.service.Service;


@WebServlet("*.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private boolean join_view = false;

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
		String command = uri.substring(conPath.length());
		String viewPage = null;
		Service service = null;
		
		if (command.equals("/login_view.do")) {
			viewPage = "member/login_view.jsp";
		} else if (command.equals("/login.do")) {
			service = new MLoginService();
			service.execute(request, response);
			viewPage = "member/main.jsp";
		} else if (command.equals("/join_view.do")) {
			viewPage = "member/join_view.jsp";
			join_view = true;
		} else if (command.equals("/join.do")) {
			if (join_view) {
				service = new MJoinService();
				service.execute(request, response);
				join_view = false;
			}
			viewPage = "login_view.do";
		} else if (command.equals("/logout.do")) {
			service = new MLogoutService();
			service.execute(request, response);
			viewPage = "member/main.jsp";
		} else if (command.equals("/modify_view.do")) {
			viewPage = "member/modify_view.jsp";
		} else if (command.equals("/modify.do")) {
			service = new MModifyService();
			service.execute(request, response);
			viewPage = "member/main.jsp";
		} else if (command.equals("/list_view.do")) {
			service = new MListService();
			service.execute(request, response);
			viewPage = "member/list_view.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(viewPage);
		rd.forward(request, response);
			
			
		
	}

}
