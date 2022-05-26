<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%
		// 특정 세션 속성값 가져오기
		String sessionName = (String)(session.getAttribute("sessionName"));
		Integer myNum = (Integer)session.getAttribute("myNum");
		out.println("seesionName : " + sessionName + "<br>");
		out.println("myNum : " + myNum + "<br>");
		out.println("id : " + session.getAttribute("id") + "<br>");  // 속성값이 없을 경우 null
		
		// 모든 세션 속성 리스트 출력
		out.println("<h4>모든 세션 속성들 list</h4>");
		Enumeration<String> sAttrNames = session.getAttributeNames();
		int cnt = 0;
		while (sAttrNames.hasMoreElements()) {
			String sName = sAttrNames.nextElement();  // 세션(속성) 이름
			String sValue = session.getAttribute(sName).toString(); // 세션(속성) 값
			out.println("세션 이름 : " + sName + "<br>" + "세션 값 : " + sValue + "<br>");
			cnt++;
		}
		if (cnt == 0) {
			out.println("추가된 세션 속성이 없습니다");
		}
		
		// 특정 세션 삭제(로그아웃시 사용)
		session.removeAttribute("myNum");
		
		out.println("<h4>myNum 세션 속성 삭제 후</h4>");
		sAttrNames = session.getAttributeNames();
		cnt = 0;
		while (sAttrNames.hasMoreElements()) {
			String sName = sAttrNames.nextElement();  // 세션(속성) 이름
			String sValue = session.getAttribute(sName).toString(); // 세션(속성) 값
			out.println("세션 이름 : " + sName + "<br>" + "세션 값 : " + sValue + "<br>");
			cnt++;
		}
		if (cnt == 0) {
			out.println("추가된 세션 속성이 없습니다");
		}
		// 모든 세션 삭제(로그아웃시 사용)
		out.println("<h4>모든 세션 속성 삭제 후</h4>");
		session.invalidate();
		
		if (request.isRequestedSessionIdValid()) {
			out.println("session valid<br>");
		} else {
			out.println("session invalid<br>");
		}
		out.println("세션 ID : " + session.getId() + "<br>");
		out.println("세션의 유효시간 : " + session.getMaxInactiveInterval() + "<br>");
	%>
</body>
</html>