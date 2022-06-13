<%@page import="com.lec.dao.FileBoardDao"%>
<%@page import="com.lec.dto.FileBoardDto"%>
<%@page import="com.lec.dto.CustomerDto"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="java.io.IOException"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
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
	String path = request.getRealPath("fileboardUpload");
		int maxSize = 1024*1024*5;
		String ffilename = null;
		
		MultipartRequest mr = null;
		
		try {
			mr = new MultipartRequest(request, path, maxSize, "utf-8", new DefaultFileRenamePolicy());
			Enumeration<String> params= mr.getFileNames();
			String param = params.nextElement();
			ffilename = mr.getFilesystemName(param);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		if (ffilename != null) {
			InputStream is = null;
			OutputStream os = null;
			
			try {
				File serverFile = new File(path+"/"+ffilename);
				is = new FileInputStream(serverFile);
				os = new FileOutputStream("D:/webPro_jeong/source/06_JSP/model1/WebContent/fileboardUpload/"+ffilename);
				byte[] bs = new byte[(int)serverFile.length()];
				int readByteCnt;
				while ((readByteCnt = is.read(bs)) != -1 ) {
					os.write(bs, 0, readByteCnt);
				}
			} catch (Exception e) {
				
			} finally {
				if (os != null) {
					os.close();
				}
				if (is != null) {
					is.close();
				}
			}
		}
		String pageNum = mr.getParameter("pageNum");
		int fnum = Integer.parseInt(mr.getParameter("fnum"));
		String cid = ((CustomerDto) session.getAttribute("customer")).getCid();
		String fsubject = mr.getParameter("fsubject");
		String fcontent = mr.getParameter("fcontent");
		String fpw = mr.getParameter("fpw");
		int fref = Integer.parseInt(mr.getParameter("fref"));
		int fre_step = Integer.parseInt(mr.getParameter("fre_step"));
		int fre_level = Integer.parseInt(mr.getParameter("fre_level"));
		String fip = request.getRemoteAddr();
		
		FileBoardDto dto = new FileBoardDto(fnum, cid, fsubject, fcontent, ffilename, fpw, 0, fref, fre_step, fre_level, fip, null);
		
		FileBoardDao dao = FileBoardDao.getInstance();
		
		int result;
		if (fnum == 0) {
			result = dao.insertFileBoard(dto);
		} else {
			result = dao.replyFileBoard(dto);
		}
		if (result == FileBoardDao.SUCCESS) {
%>
		<script>
			alert("글쓰기 성공");
			location.href='fboardList.jsp?pageNum<%=pageNum%>';
		</script>
<%
		} else {
%>
		<script>
			alert("글쓰기 실패");
			history.back();
		</script>
<%
		}
%>
</body>
</html>