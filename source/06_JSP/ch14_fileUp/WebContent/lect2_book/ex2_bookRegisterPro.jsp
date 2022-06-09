<%@page import="com.lec.book.BookDto"%>
<%@page import="com.lec.book.BookDao"%>
<%@page import="java.sql.Date"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath%>/css/style.css" rel="stylesheet">
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		String path = request.getRealPath("bookImg");
		int maxSize = 1024*1024*5;
		String[] filenames = {"", ""};
		MultipartRequest mr = null;
		try {
			mr = new MultipartRequest(request, path, maxSize, "utf-8", new DefaultFileRenamePolicy());
			Enumeration<String> paramNames = mr.getFileNames();
			int idx = 0;
			while (paramNames.hasMoreElements()) {
				String param = paramNames.nextElement();
				filenames[idx] = mr.getFilesystemName(param);
				idx++;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		for (String f : filenames) {
			if (f != null) {
				InputStream is = null;
				OutputStream os = null;
				File serverFile = new File(path + "/" + f);
				try {
					is = new FileInputStream(serverFile);
					os = new FileOutputStream("D:/webPro_jeong/source/06_JSP/ch14_fileUp/WebContent/bookImg/" + f);
					byte[] bs = new byte[(int)serverFile.length()];
					while (true) {
						int readbyteCnt = is.read(bs);
						if (readbyteCnt == -1) {
							break;
						}
						os.write(bs, 0, readbyteCnt);
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				} finally {
						if (os != null) {
							os.close();
						}
						if (is != null) {
							is.close();
						}
				}
			}
			
		}
		
		int bid = 0;
		String btitle = mr.getParameter("btitle");
		int bprice = Integer.parseInt(mr.getParameter("bprice"));
		String bimage1 = filenames[1] == null ? "noImg.png" : filenames[1];
		String bimage2 = filenames[0] == null ? "NOTHING.JPG" : filenames[0];
		String bcontent = mr.getParameter("bcontent");
		int bdiscount = Integer.parseInt(mr.getParameter("bdiscount"));
		Date brdate = null;
		
		BookDao dao = BookDao.getInstance();
		BookDto dto = new BookDto(bid, btitle, bprice, bimage1, bimage2, bcontent, bdiscount, brdate);
		int result = dao.addBook(dto);
		if (result == BookDao.SUCCESS) {
	%>
		<h2>책 등록 성공</h2>
	<%
		} else {
	%>
		<h2>책 등록 실패</h2>
	<%
		}
	%>
	<h3>책 이름 : <%=btitle %></h3>
	<h3>책 대표 이미지 : <%=path %>/<%=bimage1 %></h3>
	<img src="<%=conPath %>/bookImg/<%=bimage1 %>" alt="대표">
	<h3>책 이미지2 : <%=path + "/" + bimage2 %></h3>
	<img src="<%=conPath %>/bookImg/<%=bimage2 %>">
	<h3>책 설명</h3>
	<pre><%=bcontent %></pre>
	<h3>책 가격 : <del><%=bprice %></del> <%=bprice * (100-bdiscount)/100%>원</h3>
	<h3>할인율 : <%=bdiscount %></h3>
	<a href="ex3_list_b.jsp">책 전체 리스트(게시판 스타일)</a><br>
	<a href="ex3_list_bp.jsp">책 리스트(paging 게시판 스타일)</a><br>
	<a href="ex3_list_p.jsp">책 전체 리스트(쇼핑몰 스타일)</a><br>
	<a href="ex3_list_pp.jsp">책 리스트(paging 추가된 쇼핑몰 스타일)</a>
</body>
</html>