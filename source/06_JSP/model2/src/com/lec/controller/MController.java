package com.lec.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.service.AddService;
import com.lec.service.FDeleteService;
import com.lec.service.ALoginService;
import com.lec.service.AMemberListService;
import com.lec.service.AaIdChkService;
import com.lec.service.FDetailService;
import com.lec.service.FFileBoardListService;
import com.lec.service.FUpdateService;
import com.lec.service.FWriteService;
import com.lec.service.MEmailChkService;
import com.lec.service.MIdChkService;
import com.lec.service.MJoinService;
import com.lec.service.MLoginService;
import com.lec.service.MModifyServiece;
import com.lec.service.Service;


@WebServlet("*.do")
public class MController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private boolean join_view = false;
	private boolean add_view = false;
	private boolean write_view = false;
	
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
		
		// 사용자 회원가입 view
		if (com.equals("/join_view.do")) {
			viewPage = "mvc_member/join.jsp";
			join_view = true;
			
		// 사용자 회원가입 do
		} else if (com.equals("/join.do")) {
			if (join_view) {
				service = new MJoinService();
				service.execute(request, response);
				join_view = false;
			}
			viewPage = "login_m_view.do";
		
		// 사용자 로그인 view
		} else if (com.equals("/login_m_view.do")) {
			viewPage = "mvc_member/login_m.jsp";
			
		// 사용자 로그인 do
		} else if (com.equals("/login_m.do")) {
			service = new MLoginService();
			service.execute(request, response);
			viewPage = "main/main.jsp";
			
		// 사용자 아이디 체크
		} else if (com.equals("/idChk.do")) {
			service = new MIdChkService();
			service.execute(request, response);
			viewPage = "mvc_member/idChk.jsp";
			
		// 사용자 이메일 체크
		} else if (com.equals("/emailChk.do")) {
			service = new MEmailChkService();
			service.execute(request, response);
			viewPage = "mvc_member/emailChk.jsp";
		
		// 정보수정 view
		} else if (com.equals("/modify_view.do")) {
			viewPage = "mvc_member/modify.jsp";
		
		// 정보수정 do
		} else if (com.equals("/modify.do")) {
			service = new MModifyServiece();
			service.execute(request, response);
			viewPage = "main/main.jsp";
			
		// 관리자 로그인 view
		} else if (com.equals("/login_a_view.do")) {
			viewPage = "mvc_admin/login_a.jsp";
			
		// 관리자 로그인 do
		} else if (com.equals("/login_a.do")) {
			service = new ALoginService();
			service.execute(request, response);
			viewPage = "main/main.jsp";
			
		// 관리자 추가 view
		} else if (com.equals("/add_view.do")) {
			viewPage = "mvc_admin/add.jsp";
			add_view = true;
			
		// 관리자 추가 do
		} else if (com.equals("/add.do")) {
			if (add_view) {
				service = new AddService();
				service.execute(request, response);
				add_view = false;
			}
			viewPage = "main/main.jsp";
			
		// 관리자 아이디 체크
		} else if (com.equals("/aidChk.do")) {
			service = new AaIdChkService();
			service.execute(request, response);
			viewPage = "mvc_admin/aidChk.jsp";
		
		// 회원 전체 리스트
		} else if (com.equals("/memberList_view.do")) {
			service = new AMemberListService();
			service.execute(request, response);
			viewPage = "mvc_admin/memberList.jsp";
			
		// 글 리스트
		} else if (com.equals("/fileboardList.do")) {
			service = new FFileBoardListService();
			service.execute(request, response);
			viewPage = "mvc_fileboard/fileboardList.jsp";
			
		// 글쓰기 view
		} else if (com.equals("/write_view.do")) {
			viewPage = "mvc_fileboard/write.jsp";
			write_view = true;
		
		// 글쓰기 do
		} else if (com.equals("/write.do")) {
			if (write_view) {
				service = new FWriteService();
				service.execute(request, response);
				write_view = false;
			}
			viewPage = "write_view.do";
			
		// 상세보기
		} else if (com.equals("/detail.do")) {
			service = new FDetailService();
			service.execute(request, response);
			viewPage = "mvc_fileboard/fcontent.jsp";
			
		// 글 수정 view
		} else if (com.equals("/update_view.do")) {
			viewPage = "mvc_fileboard/update.jsp";
			
		// 글 수정 do
		} else if (com.equals("/update.do")) {
			service = new FUpdateService();
			service.execute(request, response);
			viewPage = "fileboardList.do";
		
		// 글삭제 
		} else if (com.equals("/deleteFileboard.do")) {
			service = new FDeleteService();
			service.execute(request, response);
			viewPage = "fileboardList.do";
			
		// 사용자 로그아웃
		} else if (com.equals("/logout.do")) {
			viewPage = "mvc_member/logout.jsp";
		
		// 관리자 로그아웃
		} else if (com.equals("/alogout.do")) {
			viewPage = "mvc_admin/alogout.jsp";
		}
		
		
		RequestDispatcher rd = request.getRequestDispatcher(viewPage);
		rd.forward(request, response);
	}

}
