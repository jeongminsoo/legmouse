package com.lec.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.dao.MemberDao;
import com.lec.dto.MemberDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class MJoinService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
	
		
		String path = request.getRealPath("filecopy");
		int maxSize = 1024*1024*5;
		String image = "";
		
		MultipartRequest mr = null;
		
		try {
			mr = new MultipartRequest(request, path, maxSize, "utf-8", new DefaultFileRenamePolicy());
			Enumeration<String> paramName = mr.getFileNames();
			if(paramName.hasMoreElements()) {
				String param = paramName.nextElement();
				image = mr.getFilesystemName(param);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		InputStream is = null;
		OutputStream os = null;
		File serverFile = new File(path + "/" + image);
		
		try {
			if (serverFile.exists()) {
				is = new FileInputStream(serverFile);
				os = new FileOutputStream("C:/Users/ddong/Desktop/»õ Æú´õ/legmouse/member/WebContent/filecopy/" + image);
				byte[] bs = new byte[(int)serverFile.length()];
				while (true) {
					int readbyteCnt = is.read(bs);
					if (readbyteCnt == -1) {
						break;
					}
					os.write(bs, 0, readbyteCnt);
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			
				try {
					if (os != null) {
						os.close();
					}
					if (is != null) {
						is.close();
					}
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
		}

		String mid = mr.getParameter("mid");
		String mpw = mr.getParameter("mpw");
		String mpwChk = mr.getParameter("mpwChk");
		String mname = mr.getParameter("mname");
		String memail = mr.getParameter("memail");
		String tempbirth = mr.getParameter("tempbirth");
		String maddress = mr.getParameter("maddress");
		String mphoto = image == null ? "NOIMG.JPG" : image;
		int result;
		
		MemberDao dao = MemberDao.getInstance();
		
		if (dao.idChk(mid) == MemberDao.ID_NONEXISTENT) {
			if (mpw.equals(mpwChk)) {
				MemberDto member = new MemberDto();
				member.setMid(mid);
				member.setMpw(mpw);
				member.setMname(mname);
				member.setMemail(memail);
				member.setMbirth(Date.valueOf(tempbirth));
				member.setMaddress(maddress);
				member.setMphoto(mphoto);
				result = dao.joinMember(member);
				request.setAttribute("id", mid);
			} else {
				result = MemberDao.FAIL;
			}
		} else {
			result = MemberDao.ID_EXISTENT;
		}
		request.setAttribute("joinResult", result);
	}

}
