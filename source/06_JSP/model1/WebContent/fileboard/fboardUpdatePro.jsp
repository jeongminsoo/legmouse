<%@page import="com.lec.dto.FileBoardDto"%>
<%@page import="com.lec.dao.FileBoardDao"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.io.IOException"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String conPath = request.getContextPath();
	request.getParameter("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
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
		FileBoardDao dao = FileBoardDao.getInstance();
		
		String pageNum = mr.getParameter("pageNum");
		String dbfilename = mr.getParameter("dbfilename");
		ffilename = (ffilename == null) ? dbfilename : ffilename;
		int fnum = Integer.parseInt(mr.getParameter("fnum"));
		String cid = dao.detail(fnum).getCid();
		String fsubject = mr.getParameter("fsubject");
		String fcontent = mr.getParameter("fcontent");
		String fpw = mr.getParameter("fpw");
		String fip = request.getRemoteAddr();
		int fhit = dao.detail(fnum).getFhit();
		int fre_step = dao.detail(fnum).getFre_step();
		int fre_level = dao.detail(fnum).getFre_level();
		
		FileBoardDto dto = new FileBoardDto(fnum, cid, fsubject, fcontent, ffilename, fpw, fhit, fnum, fre_step, fre_level, fip, null);

		int result = dao.update(dto);
		if (result == FileBoardDao.SUCCESS) {
	%>
		<script>
			alert('수정 성공!');
			location.href='../fileboard/fboardList.jsp?pageNum=<%=pageNum%>';
		</script>
	<%
		} else {
	%>
		<script>
			alert('수정 실패!');
			history.back();
		</script>
	<%
		}
	%>
</body>
</html>