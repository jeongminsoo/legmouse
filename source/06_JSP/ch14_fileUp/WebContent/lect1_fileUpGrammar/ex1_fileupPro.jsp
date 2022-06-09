<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.io.IOException"%>
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
		String path = request.getRealPath("fileUpFolder");
		int maxSize = 1024*1024*10; // 업로드 최대 용량
		String filename = ""; // 서버에 저장될 파일 이름
		String originalFileName = ""; // 업로드한 원본 파일 이름
		try {
			MultipartRequest mr = new MultipartRequest(request, path, maxSize, "utf-8", new DefaultFileRenamePolicy()); // DefaultFileRenamePolicy() : 같은 이름의 파일이 있는 경우 rename 처리
			Enumeration<String> paramNames = mr.getFileNames(); // 파라미터 이름들
			String param = paramNames.nextElement(); // vkfkalxj dlfma "file"
			filename = mr.getFilesystemName(param); // 파라미터 이름으로 저장된 파일 이름
			originalFileName = mr.getOriginalFileName(param);
			System.out.println("파라미터 이름 : " + param + "/서버에 저장된 파일이름 : " + filename + "/사용자가 업로드한 원본 파일이름 : " + originalFileName);
			// 파일을 첨부하지 않을 경우 filename과 originalFilename 에는 null
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		// 서버에 업로드한 파일을 소스의폴더로 복사 
		InputStream is = null;
		OutputStream os = null;
		try {
			File serverfile = new File(path + "/" + filename);
			if (serverfile.exists()) {
				is = new FileInputStream(serverfile);
				os = new FileOutputStream("D:/webPro_jeong/source/06_JSP/ch14_fileUp/WebContent/fileUpFolder/" + filename);
				byte[] bs = new byte[(int)serverfile.length()];
				while (true) {
					int nReadCnt = is.read(bs); // 파일의 끝이 아닐 경우 읽어들인 byte수 : nReadCnt
					if (nReadCnt == -1) {
						break;
					}
					os.write(bs, 0, nReadCnt);
				}
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
		if (filename != null) {
	%>
		<h3>첨부한 원본 파일 이름 : <%=originalFileName %></h3>
		<h3>서버에 저장된 파일 : <%=path %>/<%=filename %></h3>
		<img src="<%=conPath %>/fileUpFolder/<%=filename %>" alt="첨부파일">
	<%
		} else {
	%>
			<h2>첨부 안함</h2>
	<%
		}
	%>
</body>
</html>