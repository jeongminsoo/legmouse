<%@page import="java.sql.Date"%>
<%@page import="com.lec.dto.CustomerDto"%>
<%@page import="com.lec.dao.CustomerDao"%>
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
		CustomerDao dao = CustomerDao.getInstance();
		CustomerDto dto = new CustomerDto();
		for (int i = 0; i < 10; i++) {
			dto.setCid("aa"+i);
			dto.setCpw("111");
			if (i % 2 == 0) {
				dto.setCname("홍길동");
				dto.setCgender("m");
			} else {
				dto.setCname("홍길자");
				dto.setCgender("f");
			}
			dto.setCtel("010-1234-123" + i);
			dto.setCemail("hong" + i + "@hong.com");
			dto.setCbirth(Date.valueOf("1995-12-12"));
			int result = dao.joinCustomer(dto);
			out.println(result == CustomerDao.SUCCESS ? "성공<br>" : "실패<br>");
		}
	%>
</body>
</html>