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
		String[] filenames = {"", "", ""};
		String[] originalFileNames = {"", "", ""};
		try {
			MultipartRequest mr = new MultipartRequest(request, path, maxSize, "utf-8", new DefaultFileRenamePolicy()); // DefaultFileRenamePolicy() : 같은 이름의 파일이 있는 경우 rename 처리
			Enumeration<String> paramNames = mr.getFileNames(); // 파라미터 이름들
			int idx = 0;
			while (paramNames.hasMoreElements()) {
				String param = paramNames.nextElement();
				filenames[idx] = mr.getFilesystemName(param);
				originalFileNames[idx] = mr.getOriginalFileName(param);
				idx++;
			}
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		for (String f : filenames) {
			if (f != null) {
				InputStream is = null;
				OutputStream os = null;
				try {
					File serverfile = new File(path + "/" + f);
					if (serverfile.exists()) {
						is = new FileInputStream(serverfile);
						os = new FileOutputStream("D:/webPro_jeong/source/06_JSP/ch14_fileUp/WebContent/fileUpFolder/" + f);
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
			}
		}
		

		for (int i = 0; i < filenames.length; i++) {
			if (filenames[i] != null) {
				out.println("<h3>첨부한 원본 파일 이름 :" + originalFileNames[i] + "</h3>");
				out.println("<h3>서버에 저장된 파일 :" + path + "/" + filenames[i] + "</h3>");
				out.println("<img src='" + conPath + "/fileUpFolder/" + filenames[i]+  "' alt='첨부파일'>");
			} else {
				out.println("<h2>첨부되지 않았습니다</h2>");
			}
		}
	%>
</body>
</html>