package com.mega.lect;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ex2")
public class Ex2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] menu = request.getParameterValues("menu");
		String[] rest = request.getParameterValues("rest");
		String nation = request.getParameter("nation");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		if (menu != null ) {
			out.println("<h2> 선택한 메뉴는");
			for (String m : menu) {
				out.print(m + " ");
			}
			out.println("</h2>");
		}else {
			out.println("<h3>선택한 메뉴가 없습니다</h3>");
		}
		if (rest != null) {
			out.println("<h2>선택한 식당 지역은 " + Arrays.toString(rest) + "입니다</h2>");
		} else {
			out.println("<h3>선택한 식당 지역이 없습니다</h3>");
		}
		out.println("<h2>국적 : " + nation + "</h2>");
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
