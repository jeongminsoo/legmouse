package com.mega.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Exam3")
public class Exam3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String name = request.getParameter("name");
		String content = request.getParameter("content");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<header>");
		out.println("<link href=\"css/style.css\" rel=\"stylesheet\" >");
		out.println("</header>");
		out.println("<body>");
		out.println("<table>");
		out.println("<tr><td colspan='2'>반갑습니다 " + name + "님</td></tr>");
		out.println("<tr><th>글제목</th><td>" + title + "</td></tr>");
		out.println("<tr><th>글내용</th><td><pre>" + content + "</pre></td></tr>");
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
		out.close();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
