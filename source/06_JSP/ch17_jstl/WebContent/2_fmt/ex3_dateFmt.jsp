<%@page import="java.sql.Timestamp"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>

</head>
<body>
	<c:set var="nowDate" value="<%=new Date(System.currentTimeMillis()) %>"/>
	<c:set var="nowTimes" value="<%=new Timestamp(System.currentTimeMillis()) %>"/>
	<c:set var="notDateUtil" value="<%=new java.util.Date() %>"/>
	
	Date : ${nowDate }<br>
	Timestamp : ${nowTimes }<br>
	not util : ${notDateUtil }<br>
	fmt(Date) Date : <fmt:formatDate value="${nowDate }" type="date"/><br>
	fmt(both) Date :  <fmt:formatDate value="${nowDate }" type="both"/><br>
	<h2>type : date(날짜만 출력)</h2>
	dateStyle(short) : <fmt:formatDate value="${nowDate }" type="date" dateStyle="short"/><br>
	dateStyle(medium) : <fmt:formatDate value="${nowDate }" type="date" dateStyle="medium"/><br>
	dateStyle(long) : <fmt:formatDate value="${nowDate }" type="date" dateStyle="long"/><br>
	dateStyle(full) : <fmt:formatDate value="${nowDate }" type="date" dateStyle="full"/><br>
	<h2>type : time(시간만 출력)</h2>
	dateStyle(short) : <fmt:formatDate value="${nowDate }" type="time" timeStyle="short"/><br>
	dateStyle(medium) : <fmt:formatDate value="${nowDate }" type="time" timeStyle="medium"/><br>
	dateStyle(long) : <fmt:formatDate value="${nowDate }" type="time" timeStyle="long"/><br>
	dateStyle(full) : <fmt:formatDate value="${nowDate }" type="time" timeStyle="full"/><br>
	<h2>type : both(날짜와 시간 모두 출력)</h2>
	<fmt:formatDate value="${nowDate }" type="both" dateStyle="long" timeStyle="short"/>
	<h2>나만의 패턴</h2>
	<fmt:formatDate value="${nowDate }" pattern="yyyy년 MM월 dd일(E요일) hh:mm:ss:SS(a)"/><br>
	<fmt:formatDate value="${nowDate }" pattern="yy-MM-dd(E) hh:mm:ss:SS(a)"/>
	
</body>
</html>