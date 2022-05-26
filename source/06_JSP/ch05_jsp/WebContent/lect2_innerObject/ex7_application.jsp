<%@page import="java.io.FileReader"%>
<%@page import="java.io.BufferedReader"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%
		String conPath = request.getContextPath();
		String appPath = application.getContextPath();  // 현대프로젝트 상대경로 
		String absolutePath = application.getRealPath("."); // 현제 프로젝트의 절대경로
	%>
	<h2>conPath : <%=conPath %></h2>
	<h2>appPath : <%=appPath %></h2>
	<h2>absolutePath : <%=absolutePath %></h2>
	<%
		String filePath = application.getRealPath("WEB-INF/test.txt");
		out.print(filePath + "의 내용입니다<br><br>");
		// 스트림객체 생성(파일 열기) - 읽기 - 스트림객체 닫기(파일 닫기)
		BufferedReader br = new BufferedReader(new FileReader(filePath));
		while (true) {
			String line = br.readLine();  // 파일  한줄씩 읽기 / 파일이 끝나면 null return
			if (line == null) {
				break;
			}
			out.println(line + "<br>");
		}
		br.close();
		/* BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(filePath));  // 스트림 객체 생성
			while (true) {
				String line = br.readLine();  // 파일  한줄씩 읽기 / 파일이 끝나면 null return
				if (line == null) {
					break;
				}
				out.println(line + "<br>");
			}
		} catch(Exception e) {
			out.println("파일이 존재하지 않거나 읽을 수 없는 파일입니다");
		} finally {
			try{
				if (br != null) {
					br.close();
				}
			} catch(Exception e) {
				
			}
		} */
	%>
</body>
</html>